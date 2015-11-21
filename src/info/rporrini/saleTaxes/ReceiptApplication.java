package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class ReceiptApplication {

	private OutputStream out;

	public ReceiptApplication(OutputStream out) {
		this.out = out;
	}

	public void process(String[][] rawBasket) {
		
		Basket basket = basketFrom(rawBasket);
		for(BasketInspection inspector : basketInspections()){
			basket.scan(inspector);
		}
	}

	private BasketInspection[] basketInspections() {
		return new BasketInspection[]{
					new TaxationRegimes("books", "food", "medicals"),
					new ItemDescriptions(out),
					new TotalTaxes(out),
					new TotalPrice(out)
		};
	}

	private Basket basketFrom(String[][] rawBasket) {
		Basket basket = new Basket();
		for(String[] rawItem : rawBasket){
			basket.add(rawItem);
		}
		return basket;
	}
}
