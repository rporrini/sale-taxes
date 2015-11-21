package info.rporrini.saleTaxes;

import java.util.ArrayList;
import java.util.List;

public class InspectionTestDouble implements Inspection{
	
	public List<Item> items = new ArrayList<Item>();
	
	@Override
	public InspectionTestDouble inspect(Item item) {
		items.add(item);
		return this;
	}
	
	public Item last() {
		return this.items.get(0);
	}

	@Override
	public void finishInspection() {}
}