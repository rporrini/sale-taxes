package info.rporrini.saleTaxes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basket {

	private ArrayList<Item> items;

	public Basket() {
		items = new ArrayList<Item>();
	}

	public void inspectWith(BasketInspection... inspections) {
		for(BasketInspection inspection : inspections){
			for(Item item : this.items){
				inspection.inspect(item);
			}
			inspection.finish();
		}
	}

	public Basket from(String... rawBasket) {
		Pattern pattern = Pattern.compile("^(?<amount>\\d+) (?<description>.+) at (?<price>\\d+\\.\\d+)");
		for(String rawItem : rawBasket){
			Matcher matcher = pattern.matcher(rawItem);
			matcher.matches();
			
			items.add(new Item()
							.withAmount(Integer.parseInt(matcher.group("amount")))
							.withDescription(matcher.group("description"))
							.withPrice(Double.parseDouble(matcher.group("price"))));
		}
		return this;
	}
}
