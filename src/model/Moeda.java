package model;

import java.math.BigDecimal;

public class Moeda {
	
	private String quotationDate;
	private String moeda;
	private BigDecimal taxaDeCompra;
	
	
	public Moeda() {
		
	}


	public String getQuotationDate() {
		return quotationDate;
	}


	public void setQuotationDate(String quotationDate) {
		this.quotationDate = quotationDate;
	}


	public String getMoeda() {
		return moeda;
	}


	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}


	public BigDecimal getTaxaDeCompra() {
		return taxaDeCompra;
	}


	public void setTaxaDeCompra(BigDecimal taxaDeCompra) {
		this.taxaDeCompra = taxaDeCompra;
	}


	@Override
	public String toString() {
		return "Moeda [quotationDate=" + quotationDate + ", moeda=" + moeda + ", taxaDeCompra=" + taxaDeCompra + "]";
	}



}
