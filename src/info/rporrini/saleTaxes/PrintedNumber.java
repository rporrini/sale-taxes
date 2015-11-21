package info.rporrini.saleTaxes;

import java.text.DecimalFormat;

public class PrintedNumber{
	
	private double number;

	public PrintedNumber(double number){
		this.number = number;
	}
	
	public String asString(){
		return new DecimalFormat("0.00").format(number);
	}
}