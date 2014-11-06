package impl.asd.cs.mum;

import java.util.Iterator;
import java.util.Vector;
import iface.asd.cs.mum.IIterator;
import app.asd.cs.mum.Swimmer;
import app.asd.cs.mum.SwimmersList;

public class SelectiveSwimmers extends GenericSwimmers implements IIterator {

	public SelectiveSwimmers(SwimmersList swimmersList) {
		super(swimmersList);
	}

	public Iterator iterate() {
		Vector tmpSwimmers = new Vector();
		Vector swimmers = swimmersList.getSwimmers();
		for (int x=0; x<swimmers.size(); x++){
		    Swimmer swimmer= (Swimmer)swimmers.elementAt(x);
		    if (swimmer.getAge()>=12)
		       tmpSwimmers.add(swimmer);
		}
		return tmpSwimmers.iterator();
	}
}
