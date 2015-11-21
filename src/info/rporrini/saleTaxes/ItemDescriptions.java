package info.rporrini.saleTaxes;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemDescriptions {

	private Screen out;
	private List<String> lines;

	public ItemDescriptions(OutputStream out) {
		this.out = new Screen(out);
		this.lines = new ArrayList<String>();
	}

	public ItemDescriptions inspect(Item item) {
		lines.add(item.amount() + " " + item.description() + ": " + new PrintedNumber(item.priceAfterTaxes()).asString());
		return this;
	}
	
	public void finishInspection(){
		for(String line : lines){
			this.out.send(line);
		}
		this.out.flush();
	}
}