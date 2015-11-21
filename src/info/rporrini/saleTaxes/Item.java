package info.rporrini.saleTaxes;

public class Item{
	
	private double price = 0.0;
	private double taxRate = 10.0;
	
	private int amount = 1;
	
	private String description = "";
	private String category = "";

	public Item withDescription(String description){
		this.description = description;
		return this;
	}
	
	public Item withCategory(String category){
		this.category = category;
		return this;
	}
	
	public String category() {
		return category;
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
		return rounded(this.amount * (this.price + tax()));
	}
	
	public double totalTaxes() {
		return rounded(this.amount * tax());
	}
	
	public Item withAmount(int amount) {
		this.amount = amount;
		return this;
	}
	
	public Item notTaxed() {
		this.taxRate = 0.0;
		return this;
	}
	
	private double tax() {
		return this.price * this.taxRate / 100.0;
	}
	
	private double rounded(double totalPrice) {
		return Math.round(totalPrice * 100d) / 100d;
	}
}