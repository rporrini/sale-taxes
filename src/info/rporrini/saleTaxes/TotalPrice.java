package info.rporrini.saleTaxes;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

public class TotalPrice {
	
	private OutputStream out;
	private double totalPrice = 0.0;

	public TotalPrice(ByteArrayOutputStream out) {
		this.out = out;
	}

	public void finishInspection() {
		PrintStream stream = new PrintStream(this.out);
		stream.println("Total: " + formattedPrice(this.totalPrice));
		stream.flush();
		stream.close();		
	}

	public TotalPrice inspect(Item item) {
		this.totalPrice += item.priceAfterTaxes();
		return this;
	}
	
	private String formattedPrice(double number) {
		return new DecimalFormat("0.00").format(number);
	}
}
