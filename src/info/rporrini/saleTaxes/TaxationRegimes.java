package info.rporrini.saleTaxes;

import java.util.Arrays;
import java.util.List;

public class TaxationRegimes implements Inspection{

	private List<String> specialCategories;

	public TaxationRegimes(String... specialCategories) {
		this.specialCategories = Arrays.asList(specialCategories);
	}

	@Override
	public TaxationRegimes inspect(Item item) {
		if(specialCategories.contains(item.category())) {
			item.notTaxed();
		}
		return this;
	}

	@Override
	public void finishInspection() {}
}
