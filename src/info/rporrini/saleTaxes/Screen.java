package info.rporrini.saleTaxes;

import java.io.OutputStream;
import java.io.PrintStream;

public class Screen{
	
	private PrintStream out;

	public Screen(OutputStream out){
		this.out = new PrintStream(out);
	}
	
	public void send(String content){
		this.out.println(content);
	}
	
	public void printAll(){
		this.out.flush();
		this.out.close();
	}
}