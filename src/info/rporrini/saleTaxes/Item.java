package info.rporrini.saleTaxes;

public class Item{
	private String description;

	public Item withDescription(String description){
		this.description = description;
		return this;
	}
	
	public String description() {
		return this.description;
	}
}