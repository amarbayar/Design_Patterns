package impl.asd.cs.mum;

import java.util.Iterator;
import app.asd.cs.mum.SwimmersList;
import iface.asd.cs.mum.IIterator;

public class RegularSwimmers extends GenericSwimmers implements IIterator {

	public RegularSwimmers(SwimmersList swimmersList) {
		super(swimmersList);
	}

	public Iterator iterate() {
		return swimmersList.getSwimmers().iterator();
	}
	
}
