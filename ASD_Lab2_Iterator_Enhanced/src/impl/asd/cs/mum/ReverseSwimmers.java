package impl.asd.cs.mum;

import java.util.Iterator;
import java.util.Vector;
import iface.asd.cs.mum.IIterator;
import app.asd.cs.mum.Swimmer;
import app.asd.cs.mum.SwimmersList;

public class ReverseSwimmers extends GenericSwimmers implements IIterator{

	public ReverseSwimmers(SwimmersList swimmersList) {
		super(swimmersList);
	}

	public Iterator iterate() {
		Vector tmpSwimmers = new Vector();
		Vector swimmers = swimmersList.getSwimmers();
		for (int x=swimmers.size()-1; x>-1; x--){
		    tmpSwimmers.add((Swimmer)swimmers.elementAt(x));
		}
		return tmpSwimmers.iterator();
	}

}
