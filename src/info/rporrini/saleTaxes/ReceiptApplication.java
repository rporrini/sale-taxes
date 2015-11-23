package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class ReceiptApplication {

	private OutputStream out;
	private String[] rawBasket;
	private ItemsCategory category;

	public ReceiptApplication(String[][] categories, String[] rawBasket, OutputStream out) {
		this.out = out;
		this.rawBasket = rawBasket;
		this.category = new ItemsCategory(categories);
	}

	public void process() {
		
		Basket basket = new Basket().from(rawBasket);
		basket.inspectWith(taxations());
		basket.inspectWith(receiptPrint());
		
	}

	private BasketInspection[] taxations() {
		return new BasketInspection[]{
				new CategorizeItems(category),
				new ImportedItemsTaxation(),
				new SpecialTaxationRegimes("books", "food", "medicals"),	
		};
	}

	private BasketInspection[] receiptPrint() {
		return new BasketInspection[]{
					new ItemDescriptions(out),
					new TotalTaxes(out),
					new TotalPrice(out)
		};
	}
}
