package info.rporrini.saleTaxes;

import java.io.OutputStream;

public class ItemDescriptions implements BasketInspection{

	private Screen screen;

	public ItemDescriptions(OutputStream out) {
		this.screen = new Screen(out);
	}

	@Override
	public ItemDescriptions inspect(Item item) {
		screen.send(item.amount() + " " + item.description() + ": " + new PrintedNumber(item.priceAfterTaxes()).asString());
		return this;
	}
	
	@Override
	public void finish(){
		this.screen.printAll();
	}
}
