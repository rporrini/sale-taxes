package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasketTest {

	@Test
	public void shouldBeEmptyByDefault() {
		
		InspectionTestDouble inspector = new InspectionTestDouble();
		
		new Basket().scan(inspector);
		
		assertThat(inspector.items, empty());
	}
	
	@Test
	public void shouldAcceptNewItems() throws Exception {
		
		InspectionTestDouble inspector = new InspectionTestDouble();
		
		new Basket().add(new String[]{"1", "the item", "2.0", "the item category"}).scan(inspector);
		
		assertThat(inspector.items, not(empty()));
	}
	
	@Test
	public void shouldBuildItemsWithTheRightRepresentation() throws Exception {
		
		InspectionTestDouble inspector = new InspectionTestDouble();
		
		new Basket().add(new String[]{"1", "the item", "2.0", "the item category"}).scan(inspector);
		
		assertThat(inspector.last().description(), equalTo("the item"));
		assertThat(inspector.last().category(), equalTo("the item category"));
		assertThat(inspector.last().priceAfterTaxes(), equalTo(2.2));
	}
}
