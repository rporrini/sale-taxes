package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasketTest {

	@Test
	public void shouldBeEmptyByDefault() {
		
		Basket basket = new Basket();
		
		assertThat(basket.items(), empty());
	}
	
	@Test
	public void shouldAcceptNewItems() throws Exception {
		
		String[] item = new String[]{"1", "the item", "2.0", "the category"};
		
		Basket basket = new Basket().add(item);
		
		assertThat(basket.items(), not(empty()));
	}
	
	@Test
	public void shouldBuildItemsWithTheRightDescription() throws Exception {
		
		String[] item = new String[]{"1", "the item", "2.0", "the category"};
		
		Basket basket = new Basket().add(item);
		
		assertThat(firstItemOf(basket).description(), equalTo("the item"));
	}
	
	private Item firstItemOf(Basket basket) {
		return basket.items().get(0);
	}
}
