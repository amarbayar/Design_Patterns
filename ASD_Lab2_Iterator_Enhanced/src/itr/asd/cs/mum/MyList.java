package itr.asd.cs.mum;

import java.util.Iterator;
import java.util.Vector;

import app.asd.cs.mum.Swimmer;
import app.asd.cs.mum.SwimmersList;

public class MyList<T> extends Vector{
	
	private SwimmersList swimmersList;
	
	public MyList(SwimmersList swimmersList){
		this.swimmersList = swimmersList;
	}
	
	public Iterator<T> reverseIterator(){
		Vector tmpSwimmers = new Vector();
		Vector swimmers = swimmersList.getSwimmers();
		for (int x=swimmers.size()-1; x>-1; x--){
		    tmpSwimmers.add((Swimmer)swimmers.elementAt(x));
		}
		return tmpSwimmers.iterator();
	}
}
