package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import info.rporrini.saleTaxes.ReceiptApplication;

import java.io.ByteArrayOutputStream;

import org.junit.Ignore;
import org.junit.Test;

public class ReceiptApplicationAcceptanceTest {

	@Test
	@Ignore
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
						  containsString("Sale Taxes: 1.50"),
						  containsString("Total: 29.83")));
	}

}
