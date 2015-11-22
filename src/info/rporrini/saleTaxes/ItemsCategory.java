package info.rporrini.saleTaxes;

import java.util.HashMap;

public class ItemsCategory {

	private HashMap<String, String> map;

	public ItemsCategory(String[]... correspondencies) {
		this.map = mapFrom(correspondencies);
	}

	private HashMap<String, String> mapFrom(String[][] correspondencies) {
		HashMap<String, String> map = new HashMap<String, String>();
		for(String[] correspondence : correspondencies){
			map.put(correspondence[0], correspondence[1]);
		}
		return map;
	}

	public String of(String item) {
		String category = this.map.get(item);
		if(category != null) return category;
		return "uncategorized";
	}

}
