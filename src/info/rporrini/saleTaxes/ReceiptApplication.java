package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class ReceiptApplication {

	private OutputStream out;

	public ReceiptApplication(OutputStream out) {
		this.out = out;
	}

	public void process(String[][] rawBasket) {
		Basket basket = new Basket();
		for(String[] rawItem : rawBasket){
			basket.add(rawItem);
		}
		
		Inspection[] inspections = new Inspection[]{
				new TaxationRegimes("books", "food", "medicals"),
				new ItemDescriptions(out),
				new TotalTaxes(out),
				new TotalPrice(out)
		};
		for(Inspection inspector : inspections){
			basket.scan(inspector);
			inspector.finishInspection();
		}
	}
}
