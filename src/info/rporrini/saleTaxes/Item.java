package info.rporrini.saleTaxes;

public class Item{
	
	private String description;
	private double price = 0.0;
	private int amount = 1;
	private double taxRate = 10.0;

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
		return this.amount * incrementBy(this.price, taxRate);
	}

	public Item withAmount(int amount) {
		this.amount = amount;
		return this;
	}
	
	private double incrementBy(double price, double rate) {
		return this.price + (this.price * rate / 100.0);
	}

	public Item underSpecialTaxationRegime() {
		this.taxRate = 0.0;
		return this;
	}
}