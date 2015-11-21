package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class TotalTaxesTest {

	@Test
	public void totalTaxesShouldBeZeroWhenNoItemsWereProcessed() {
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new TotalTaxes(output).finish();
		
		assertThat(new String(output.toByteArray()), containsString("Sales Taxes: 0.00"));
	}
	
	@Test
	public void shouldComputeTheTotalPriceForItems() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new TotalTaxes(output).inspect(new Item().withPrice(10.0)).finish();
		
		assertThat(new String(output.toByteArray()), containsString("Sales Taxes: 1.00"));
	}	
}
