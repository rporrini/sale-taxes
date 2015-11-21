package info.rporrini.saleTaxes;

import java.util.ArrayList;

public class Basket {

	private ArrayList<Item> items;

	public Basket() {
		items = new ArrayList<Item>();
	}

	public Basket add(String[] rawItem) {
		items.add(new Item()
						.withDescription(rawItem[1])
						.withCategory(rawItem[3])
						.withPrice(Double.parseDouble(rawItem[2])));
		return this;
	}
	
	public void scan(Inspection visitor){
		for(Item item : this.items){
			visitor.inspect(item);
		}
	}
}
