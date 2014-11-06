package asd.cs.mum;

public interface ShapeResizeSubject {
	public void attach(ShapeResizeObserver observer);
	public void detach(ShapeResizeObserver observer);
	public void setCount(int cnt);
	public int getCount();
	public void increment();
	public void decrement();
	public void notifyObservers();
}
