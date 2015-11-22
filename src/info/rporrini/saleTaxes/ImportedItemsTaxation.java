package info.rporrini.saleTaxes;

public class ImportedItemsTaxation implements BasketInspection {

	public ImportedItemsTaxation inspect(Item item) {
		if(item.description().startsWith("imported")){
			item.imported();
		}
		return this;
	}

	@Override
	public void finish() {}
}
