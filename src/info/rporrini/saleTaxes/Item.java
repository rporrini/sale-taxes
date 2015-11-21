package info.rporrini.saleTaxes;

public class Item{
	
	private String description;
	private double price = 0.0;
	private int amount = 1;

	public Item withDescription(String description){
		this.description = description;
		return this;
	}
	
	public String description() {
		return this.description;
	}

	public int amount() {
		return this.amount;
	}

	public Item withPrice(double shelfPrice) {
		this.price = shelfPrice;
		return this;
	}

	public double priceAfterTaxes() {
		return this.amount * (this.price + (this.price * 10.0 / 100.0));
	}

	public Item withAmount(int amount) {
		this.amount = amount;
		return this;
	}
}