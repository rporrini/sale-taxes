package info.rporrini.saleTaxes;

import java.util.ArrayList;

public class Basket {

	private ArrayList<Item> items;

	public Basket() {
		items = new ArrayList<Item>();
	}

	public Basket add(String[] rawItem) {
		items.add(new Item()
						.withAmount(Integer.parseInt(rawItem[0]))
						.withDescription(rawItem[1])
						.withPrice(Double.parseDouble(rawItem[2]))
						.withCategory(rawItem[3]));
		return this;
	}
	
	public void scan(BasketInspection inspector){
		for(Item item : this.items){
			inspector.inspect(item);
		}
		inspector.finish();
	}
}
