package info.rporrini.saleTaxes;

public class ImportedItemsTaxation implements BasketInspection {

	public ImportedItemsTaxation inspect(Item item) {
		if(item.description().contains("imported")){
			item.imported();
		}
		return this;
	}

	@Override
	public void finish() {}
}
