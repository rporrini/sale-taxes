package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class TotalTaxes implements Inspection{

	private Screen out;
	private double taxes = 0.0;

	public TotalTaxes(OutputStream out) {
		this.out = new Screen(out);
	}

	public void finishInspection() {
		out.send("Sales Taxes: " + new PrintedNumber(taxes).asString());
		out.flush();
	}

	public TotalTaxes inspect(Item item) {
		taxes += item.totalTaxes();
		return this;
	}
}
