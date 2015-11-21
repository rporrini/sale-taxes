package info.rporrini.saleTaxes;

import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemDescriptions {

	private OutputStream out;
	private List<String> lines;

	public ItemDescriptions(OutputStream out) {
		this.out = out;
		this.lines = new ArrayList<String>();
	}

	public ItemDescriptions inspect(Item item) {
		lines.add(item.amount() + " " + item.description() + ": " + formattedPrice(item.priceAfterTaxes()));
		return this;
	}
	
	public void finishInspection(){
		PrintStream stream = new PrintStream(out);
		for(String line : lines){
			stream.println(line);
		}
		stream.flush();
		stream.close();
	}

	private String formattedPrice(double number) {
		return new DecimalFormat("0.00").format(number);
	}
}
