package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class ItemsCategoryTest {

	@Test
	public void whenEmptyAnyItemIsNotCategorized() {
		
		ItemsCategory category = new ItemsCategory();
		
		assertThat(category.of("any item"), equalTo("uncategorized"));
	}
	
	@Test
	public void whenFilledWithCorrespondenciesShouldReturnTheRightCategory() throws Exception {
		
		String[] correspondency = new String[]{"the item", "the category"};
		
		String category = new ItemsCategory(correspondency).of("the item");
		
		assertThat(category, equalTo("the category"));
	}
}
