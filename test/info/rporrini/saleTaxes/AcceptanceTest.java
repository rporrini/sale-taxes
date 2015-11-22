package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class AcceptanceTest {

	@Test
	public void shouldPrintTheDetailsForNotImportedItems() {
		
		String[] basket = new String[]{
									"1 book at 12.49",
									"1 music CD at 14.99",
									"1 chocolate bar at 0.85"
								};
		
		String receipt = printTheReceiptOf(basket, testCategories());
		
		assertThat(receipt, 
					allOf(containsString("1 book: 12.49"), 
						  containsString("1 music CD: 16.49"),
						  containsString("1 chocolate bar: 0.85"),
						  containsString("Sales Taxes: 1.50"),
						  containsString("Total: 29.83")));
	}

	@Test
	public void shouldPrintTheDetailsForImportedItems() {
		String[] basket = new String[]{
							"1 imported box of chocolates at 10.00",
							"1 imported bottle of perfume at 47.50",
						};
		
		String receipt = printTheReceiptOf(basket, testCategories());
		
		assertThat(receipt, 
					allOf(containsString("1 imported box of chocolates: 10.50"), 
						  containsString("1 imported bottle of perfume: 54.65"),
						  containsString("Sales Taxes: 7.65"),
						  containsString("Total: 65.15")));
	}
	
	@Test
	public void shouldPrintTheDetailsForMixedItems() {
		String[] basket = new String[]{
									"1 imported bottle of perfume at 27.99",
									"1 bottle of perfume at 18.99",
									"1 packet of headache pills at 9.75",
									"1 box of imported chocolates at 11.25",
							};
		
		String receipt = printTheReceiptOf(basket, testCategories());
		
		assertThat(receipt, 
					allOf(containsString("1 imported bottle of perfume: 32.19"), 
						  containsString("1 bottle of perfume: 20.89"),
						  containsString("1 packet of headache pills: 9.75"),
						  containsString("1 box of imported chocolates: 11.85"),
						  containsString("Sales Taxes: 6.70"),
						  containsString("Total: 74.68")));
	}
	
	private String printTheReceiptOf(String[] basket, String[][] categories) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		new ReceiptApplication(categories, basket, output).process();
		return new String(output.toByteArray());
	}
	
	public String[][] testCategories(){
		return new String[][]{
				{"book", "books"},
				{"music CD", "music"},
				{"chocolate bar", "food"},
				{"box of chocolates", "food"},
				{"bottle of perfume", "perfumes"},
				{"packet of headache pills", "medicals"}
		};
	}
}
