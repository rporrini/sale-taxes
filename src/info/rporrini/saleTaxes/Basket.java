package info.rporrini.saleTaxes;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private ArrayList<Item> items;

	public Basket() {
		items = new ArrayList<Item>();
	}

	public List<Item> items() {
		return items;
	}

	public Basket add(String[] rawItem) {
		items.add(new Item().withDescription(rawItem[1]));
		return this;
	}
}
