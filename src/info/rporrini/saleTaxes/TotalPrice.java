package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class TotalPrice implements BasketInspection{
	
	private Screen out;
	private double totalPrice = 0.0;

	public TotalPrice(OutputStream out) {
		this.out = new Screen(out);
	}

	public TotalPrice inspect(Item item) {
		this.totalPrice += item.priceAfterTaxes();
		return this;
	}
	
	public void finish() {
		out.send("Total: " + new PrintedNumber(this.totalPrice).asString());
		out.printAll();
	}
}
