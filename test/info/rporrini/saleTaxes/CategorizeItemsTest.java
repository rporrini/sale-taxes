package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategorizeItemsTest {

	@Test
	public void shouldCategorizeAnUnknownItem() {
		
		Item item = new Item();
		
		new CategorizeItems(new ItemsCategory()).inspect(item);
		
		assertThat(item.category(), equalTo("uncategorized"));
	}
	
	@Test
	public void shouldCategorizeAnImportedItem() {
		
		Item item = new Item().withDescription("an imported item");
		ItemsCategory category = new ItemsCategory(new String[]{"an item", "category"});
		
		new CategorizeItems(category).inspect(item);
		
		assertThat(item.category(), equalTo("category"));
	}
}
