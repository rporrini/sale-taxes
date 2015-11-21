package info.rporrini.saleTaxes;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class ItemDescriptionsTest {

	@Test
	public void shouldPrintOutTheDescriptionOfAnItem() {
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		new ItemDescriptions(output).inspect(new Item().withDescription("the item").withPrice(10).notTaxed()).finish();
		
		assertThat(new String(output.toByteArray()), containsString("1 the item: 10.00"));
	}

}
