package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasketTest {

	@Test
	public void shouldBeEmptyByDefault() {
		
		InspectionTestDouble inspector = new InspectionTestDouble();
		
		new Basket().inspectWith(inspector);
		
		assertThat(inspector.items, empty());
	}
	
	@Test
	public void shouldBuildItemsWithTheRightRepresentationFromARawItem() throws Exception {
		
		InspectionTestDouble inspector = new InspectionTestDouble();
		
		new Basket().add("1 the item description at 2.0").inspectWith(inspector);
		
		assertThat(inspector.last().amount(), equalTo(1));
		assertThat(inspector.last().description(), equalTo("the item description"));
		assertThat(inspector.last().priceAfterTaxes(), equalTo(2.2));
	}
}
