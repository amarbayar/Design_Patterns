package asd.cs.mum;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class ShapeResizeSubjectImpl implements ShapeResizeSubject {
	private List<ShapeResizeObserver> observers;
	private int count;
	
	public ShapeResizeSubjectImpl(){
		this.observers = new ArrayList<>();
	}
	
	public void attach(ShapeResizeObserver observer){
		this.observers.add(observer);
	}
	
	public void detach(ShapeResizeObserver observer){
		observers.remove(observer);
	}
	
	public void notifyObservers(){
		for(ShapeResizeObserver obs: this.observers){
			obs.setCount(this.getCount());
		}
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		if(count < 0)
			this.count = 0;
		this.count = count;
		notifyObservers();
	}
	
	public void increment(){
		this.count++;
		notifyObservers();
	}
	public void decrement(){
		this.count--;
		if(this.count < 0)
			this.count = 0;
		notifyObservers();
	}

}
