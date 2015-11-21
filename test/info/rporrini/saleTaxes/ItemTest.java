package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ItemTest {

	@Test
	public void shouldTrackASimpleAmountByDefault() {
		
		int amount = new Item().amount();
		
		assertThat(amount, equalTo(1));
	}

	@Test
	public void thePriceAfterTaxesShouldBeZeroByDefault() throws Exception {
		
		Item item = new Item();
		
		assertThat(item.priceAfterTaxes(), equalTo(0.0));
	}
	
	@Test
	public void theTaxationRegimeShouldBeTenPercentByDefault() throws Exception {
		
		Item item = new Item().withPrice(10.0);
		
		assertThat(item.priceAfterTaxes(), equalTo(11.0));
	}
	
	@Test
	public void totalPriceAfterTaxesShouldBeSummedUp() throws Exception {
		
		Item item = new Item().withAmount(2).withPrice(10.0);
		
		assertThat(item.priceAfterTaxes(), equalTo(22.0));
	}
}
