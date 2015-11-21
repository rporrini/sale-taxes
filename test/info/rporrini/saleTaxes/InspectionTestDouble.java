package info.rporrini.saleTaxes;

import java.util.ArrayList;
import java.util.List;

public class InspectionTestDouble implements Inspection{
	
	public List<Item> items = new ArrayList<Item>();
	
	@Override
	public void track(Item item) {
		items.add(item);
	}
	
	public Item last() {
		return this.items.get(0);
	}
}