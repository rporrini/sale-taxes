package info.rporrini.saleTaxes;

import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

public class ItemDescriptions {

	private OutputStream out;

	public ItemDescriptions(OutputStream out) {
		this.out = out;
	}

	public void track(Item item) {
		PrintStream stream = new PrintStream(out);
		stream.println(asString(item));
		stream.flush();
		stream.close();
	}

	private String asString(Item item) {
		return item.amount() + " " + item.description() + ": " + formattedPrice(item);
	}

	private String formattedPrice(Item item) {
		return new DecimalFormat("###.00").format(item.priceAfterTaxes());
	}
}
