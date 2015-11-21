package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TaxationRegimesTest {

	@Test
	public void shouldLeaveTheStandardTaxationRegimeByDefault() throws Exception {
		
		Item item = new Item().withPrice(1.0);
		
		new TaxationRegimes().inspect(item);
		
		assertThat(item.priceAfterTaxes(), equalTo(1.1));
	}
	
	@Test
	public void shouldSwitchTheTaxationRegimeForASpecificCategory() throws Exception {
		
		Item item = new Item().withPrice(1.0).withCategory("special items");
		
		new TaxationRegimes("special items").inspect(item);
		
		assertThat(item.priceAfterTaxes(), equalTo(1.0));
	}
}
