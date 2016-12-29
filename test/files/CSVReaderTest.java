package files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import model.Moeda;

public class CSVReaderTest {
	
	private CSVReader csvreader = new CSVReader();

	BufferedReader reader = null;
	
	@Before
	public void setup() throws FileNotFoundException{
		reader = csvreader.readFile();
	}
	
	@Test
	public void readFileNotNull() throws IOException{
		String line = reader.readLine();
		assertNotNull(line);
	}
	
	@Test
	public void getCsvValues() {
		csvreader = new CSVReader();
		reader = csvreader.readFile();
		List<Moeda> moedas = csvreader.parseValuesToQuotation(reader);
		assertEquals("28/12/2016", moedas.get(0).getQuotationDate());
		
	}
}
