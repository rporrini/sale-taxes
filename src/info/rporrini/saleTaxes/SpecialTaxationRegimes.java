package info.rporrini.saleTaxes;

import java.util.Arrays;
import java.util.List;

public class SpecialTaxationRegimes implements BasketInspection{

	private List<String> specialCategories;

	public SpecialTaxationRegimes(String... specialCategories) {
		this.specialCategories = Arrays.asList(specialCategories);
	}

	@Override
	public SpecialTaxationRegimes inspect(Item item) {
		if(specialCategories.contains(item.category())) {
			item.exemptedFromTaxes();
		}
		return this;
	}

	@Override
	public void finish() {}
}
