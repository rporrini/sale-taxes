package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class ReceiptApplicationAcceptanceTest {

	@Test
	public void shouldPrintTheDetailsForNotImportedItems() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new ReceiptApplication(output).process(new String[][]{
												{"1", "book", "12.49", "books"},
												{"1", "music CD", "14.99", "music"},
												{"1", "chocolate bar", "0.85", "food"}
										});
		
		assertThat(new String(output.toByteArray()), 
					allOf(containsString("1 book: 12.49"), 
						  containsString("1 music CD: 16.49"),
						  containsString("1 chocolate bar: 0.85"),
						  containsString("Sales Taxes: 1.50"),
						  containsString("Total: 29.83")));
	}
	
	@Test
	public void shouldPrintTheDetailsForImportedItems() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new ReceiptApplication(output).process(new String[][]{
												{"1", "imported box of chocolates", "10.00", "food"},
												{"1", "imported bottle of perfume", "47.50", "perfumes"},
										});
		
		assertThat(new String(output.toByteArray()), 
					allOf(containsString("1 imported box of chocolates: 10.50"), 
						  containsString("1 imported bottle of perfume: 54.65"),
						  containsString("Sales Taxes: 7.65"),
						  containsString("Total: 65.15")));
	}
	
	@Test
	public void shouldPrintTheDetailsForMixedItems() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new ReceiptApplication(output).process(new String[][]{
												{"1", "imported bottle of perfume", "27.99", "perfumes"},
												{"1", "bottle of perfume", "18.99", "perfumes"},
												{"1", "packet of headache pills", "9.75", "medicals"},
												{"1", "imported box of chocolates", "11.25", "food"},
										});
		
		assertThat(new String(output.toByteArray()), 
					allOf(containsString("1 imported bottle of perfume: 32.19"), 
						  containsString("1 bottle of perfume: 20.89"),
						  containsString("1 packet of headache pills: 9.75"),
						  containsString("1 imported box of chocolates: 11.85"),
						  containsString("Sales Taxes: 6.70"),
						  containsString("Total: 74.68")));
	}
}
