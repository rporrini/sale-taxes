package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class TotalPriceTest {

	@Test
	public void theTotalAmountShouldBeZeroByDefault() {
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new TotalPrice(output).finishInspection();
		
		assertThat(new String(output.toByteArray()), containsString("Total: 0.00"));
	}

	@Test
	public void shouldTrackComputeTheTotalPriceForItems() throws Exception {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new TotalPrice(output).inspect(new Item().withPrice(10.0).notTaxed()).finishInspection();
		
		assertThat(new String(output.toByteArray()), containsString("Total: 10.00"));
	}	
}
