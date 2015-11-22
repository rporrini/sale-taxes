package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ImportedItemsTaxationTest {

	@Test
	public void notImportedItemsShouldHaveRegularTaxation() {
		
		Item item = new Item().withDescription("an item").notTaxed().withPrice(1.0);
		
		new ImportedItemsTaxation().inspect(item);
		
		assertThat(item.totalTaxes(), equalTo(0.0));
	}
	
	@Test
	public void importedItemsShouldHaveRegularTaxation() {
		
		Item item = new Item().withDescription("imported item").notTaxed().withPrice(1.0);
		
		new ImportedItemsTaxation().inspect(item);
		
		assertThat(item.totalTaxes(), equalTo(0.05));
	}
}
