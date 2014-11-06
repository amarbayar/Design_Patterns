package app.asd.cs.mum;

import java.util.*;

public class SwimmersList
{
    private Vector slist= new Vector();
    
    public void addSwimmer( Swimmer swimmer){
        slist.addElement(swimmer);
    }
    
    public Vector getSwimmers(){
        return slist;
    }
    
//    public Iterator getSwimmers(){
//    	return slist.iterator();
//    }
}
