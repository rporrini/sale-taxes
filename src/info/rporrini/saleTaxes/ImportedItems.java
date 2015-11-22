package info.rporrini.saleTaxes;

public class ImportedItems implements BasketInspection {

	public ImportedItems inspect(Item item) {
		if(item.description().startsWith("imported")){
			item.imported();
		}
		return this;
	}

	@Override
	public void finish() {}
}
