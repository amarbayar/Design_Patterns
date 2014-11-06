package v2.asd.cs.mum;

import java.util.Observable;

public class ShapeResizeSubjectImpl extends Observable {
	private int count;
	
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
		setChanged();
		notifyObservers();
	}
	public void decrement(){
		this.count--;
		if(this.count < 0)
			this.count = 0;
		setChanged();
		notifyObservers();
	}
}
