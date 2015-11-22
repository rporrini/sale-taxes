package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

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
	
	@Test
	public void thePriceWithTaxesShouldBeRobustToDecimals() throws Exception {
		
		Item item = new Item().withAmount(2).withPrice(1.0);
		
		assertThat(item.priceAfterTaxes(), equalTo(2.2));
	}
	
	@Test
	public void priceAfterTaxesShouldBeRounded() throws Exception {
		
		Item item = new Item().withAmount(1).withPrice(14.99);
		
		assertThat(item.priceAfterTaxes(), equalTo(16.49));
	}
	
	@Test
	public void specialTaxationRegimeShouldMeanNoTaxes() throws Exception {
		
		Item item = new Item().withPrice(1.0).exemptedFromTaxes();
		
		assertThat(item.priceAfterTaxes(), equalTo(1.0));
	}
	
	@Test
	public void shouldComputeTheTotalTaxes() throws Exception {
		
		Item item = new Item().withAmount(2).withPrice(14.99);
		
		assertThat(item.totalTaxes(), equalTo(3.00));
	}
	
	@Test
	public void taxesForImportedItemsShouldBeReisedBy5Percent() throws Exception {
		
		Item item = new Item().withPrice(27.99).imported();
		
		assertThat(item.priceAfterTaxes(), equalTo(32.19));
	}
	
	@Test
	public void taxesForImportedItemsShouldBeReisedBy5PercentAlsoWhenAreNotTaxed() throws Exception {
		
		Item item = new Item().withPrice(1.00).exemptedFromTaxes().imported();
		
		assertThat(item.priceAfterTaxes(), equalTo(1.05));
	}
	
	@Test
	public void theTotalTaxesShouldBeRoundedUpToTheNearestMultipleOf5() throws Exception {
		
		Item item = new Item().withPrice(1.01);
		
		assertThat(item.totalTaxes(), equalTo(0.15));
	}
}
