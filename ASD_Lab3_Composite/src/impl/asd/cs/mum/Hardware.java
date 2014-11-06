package impl.asd.cs.mum;

import iface.asd.cs.mum.Computer;
import java.util.Iterator;
import java.util.Vector;

public class Hardware implements Computer{

	private Vector<Computer> parts;
	private double price;
	private String name;
	
	public Hardware(String name, double price){
		parts = new Vector<>();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public double computePrice() {
		
		double sum = 0; 
		System.out.println("Printing: " + name + "  | " + price);
		Iterator<Computer> itr = parts.iterator();
		while(itr.hasNext()){
			Computer c = itr.next();
			sum = sum + c.computePrice();
		}
		return price + sum;
	}

	public void addPart(Computer part){
		parts.add(part);
	}
	
	public void removePart(Computer part){
		parts.remove(part);
	}
	
	public Computer getPart(int i){
		return parts.get(i);
	}

	public Vector<Computer> getParts() {
		return parts;
	}

	public void setParts(Vector<Computer> parts) {
		this.parts = parts;
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
