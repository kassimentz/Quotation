package files;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Moeda;



public class CSVReader {
	
	private final static String FILE = "/Users/kassianesmentz/Downloads/20161228.csv";
	private final static String SEPARATOR =";"; 
	BufferedReader reader = null;
	
	
	public BufferedReader readFile() {
		try {
			File inputF = new File(FILE);
			InputStream inputFS = new FileInputStream(inputF);
		    reader = new BufferedReader(new InputStreamReader(inputFS));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return this.reader;
	}

	public List<Moeda> parseValuesToQuotation(BufferedReader reader) {
		
		List<Moeda> moedas = new ArrayList<>();
		
		moedas = reader.lines().map(mapToItem).collect(Collectors.toList());
		return moedas;
		
		
	}
	
	private Function<String, Moeda> mapToItem = (line) -> {
		  String[] p = line.split(SEPARATOR);
		  Moeda moeda = new Moeda();
		  moeda.setQuotationDate(p[0]);
		  moeda.setMoeda(p[3]);
		  moeda.setTaxaDeCompra(new BigDecimal(p[4].replace(",", ".")));
		  
		  return moeda;
	};
	

}
