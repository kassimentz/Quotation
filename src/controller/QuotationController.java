package controller;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Predicate;

import files.CSVReader;
import model.Moeda;
import utils.DateUtils;
import utils.NumberUtils;
import utils.StringUtils;

public class QuotationController {
	
	CSVReader csvReader = null;
	BufferedReader reader = null;
	List<Moeda> moedasCotadas = null;
	
	public QuotationController() {
		csvReader = new CSVReader();
		reader = csvReader.readFile();
		moedasCotadas = csvReader.parseValuesToQuotation(reader);
	}
	
	public BigDecimal currencyQuotation(String from, String to, Number value, String quotation) {
		if(StringUtils.isValid(from) && StringUtils.isValid(to) && NumberUtils.isValid(value) && dataIsAvaiable(quotation)) {
			return calculateCurrencyQuotation(value, from, to);
			
		} else { 
			return null;
		}
		
	}

	private BigDecimal calculateCurrencyQuotation(Number value, String from, String to) {
		
		//valor * from % to
		BigDecimal taxaCompraFrom = findTaxaCompraFrom(from);
		BigDecimal taxaCompraTo = findTaxaCompraTo(to);
		
		BigDecimal result = taxaCompraFrom.multiply(new BigDecimal(value.toString())).divide(taxaCompraTo, 2, RoundingMode.HALF_UP);
		return result;
	}
	
	private BigDecimal findTaxaCompraFrom(String from) {
		Predicate<Moeda> predicate = m-> m.getMoeda().equalsIgnoreCase(from);
		Moeda obj = moedasCotadas.stream().filter(predicate).findFirst().get();
		if(obj != null) {
			return obj.getTaxaDeCompra();
		} else {
			return null;
		}
	}
	
	private BigDecimal findTaxaCompraTo(String to) {
		Predicate<Moeda> predicate = m-> m.getMoeda().equalsIgnoreCase(to);
		Moeda obj = moedasCotadas.stream().filter(predicate).findFirst().get();
		if(obj != null) {
			return obj.getTaxaDeCompra();
		} else {
			return null;
		}
	}

	private boolean dataIsAvaiable(String quotation) {
		
		String validQuotation = DateUtils.checkWorkingDays(quotation);
		Predicate<Moeda> predicate = m-> m.getQuotationDate().equals(validQuotation);
		if(moedasCotadas.stream().filter(predicate).findFirst().isPresent()) {
			return true;
		} else {
			throw new IllegalArgumentException("Quotation not avaiable");
		}
		
			
	}

}
