package impl.asd.cs.mum;

import iface.asd.cs.mum.Computer;

public class Part implements Computer {
	
	private double price;
	private String name;
	
	public Part(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public double computePrice() {
		System.out.println("Printing: " + name + " | " + price);
		return price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
