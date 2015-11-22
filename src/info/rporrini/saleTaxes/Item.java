package info.rporrini.saleTaxes;

public class Item{
	
	private double price = 0.0;
	
	private int taxRate = 10;
	private int amount = 1;
	
	private String description = "";
	private String category = "";

	public Item withPrice(double shelfPrice) {
		this.price = shelfPrice;
		return this;
	}
	
	public Item withAmount(int amount) {
		this.amount = amount;
		return this;
	}
	
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

	public double priceAfterTaxes() {
		return rounded(priceBeforeTaxes() + totalTaxes());
	}

	public double totalTaxes() {
		return this.amount * roundedUp(tax());
	}

	public Item exemptedFromTaxes() {
		this.taxRate -= 10;
		return this;
	}
	
	public Item imported(){
		this.taxRate += 5;
		return this;
	}
	
	private double priceBeforeTaxes() {
		return this.amount * this.price;
	}
	
	private double tax() {
		return this.price * this.taxRate / 100.0;
	}
	
	private double roundedUp(double tax) {
		return Math.ceil(tax * 20) / 20;
	}
	
	private double rounded(double number) {
		return Math.round(number * 100.0) / 100.0;
	}
}