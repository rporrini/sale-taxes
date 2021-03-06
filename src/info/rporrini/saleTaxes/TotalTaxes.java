package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class TotalTaxes implements BasketInspection{

	private Screen out;
	private double taxes = 0.0;

	public TotalTaxes(OutputStream out) {
		this.out = new Screen(out);
	}

	public TotalTaxes inspect(Item item) {
		taxes += item.totalTaxes();
		return this;
	}
	
	public void finish() {
		out.send("Sales Taxes: " + new PrintedNumber(taxes).asString());
		out.printAll();
	}
}
