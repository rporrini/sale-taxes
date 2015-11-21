package info.rporrini.saleTaxes;

import java.util.Arrays;
import java.util.List;

public class TaxationRegimes {

	private List<String> specialCategories;

	public TaxationRegimes(String... specialCategories) {
		this.specialCategories = Arrays.asList(specialCategories);
	}

	public void track(Item item) {
		if(specialCategories.contains(item.category())) {
			item.underSpecialTaxationRegime();
		}
	}
}
