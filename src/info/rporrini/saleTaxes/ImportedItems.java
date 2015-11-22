package info.rporrini.saleTaxes;

public class ImportedItems {

	public ImportedItems inspect(Item item) {
		if(item.description().startsWith("imported")){
			item.imported();
		}
		return this;
	}

}
