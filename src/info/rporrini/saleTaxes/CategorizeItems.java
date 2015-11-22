package info.rporrini.saleTaxes;

public class CategorizeItems implements BasketInspection{

	private ItemsCategory category;

	public CategorizeItems(ItemsCategory category) {
		this.category = category;
	}

	@Override
	public CategorizeItems inspect(Item item) {
		item.withCategory(category.of(itemDescription(item)));
		return this;
	}

	private String itemDescription(Item item) {
		return item.description().replace("imported ", "");
	}

	@Override
	public void finish() {}
}
