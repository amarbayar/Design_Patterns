package app.asd.cs.mum;

import java.text.DecimalFormat;

import iface.asd.cs.mum.Computer;
import impl.asd.cs.mum.*;

public class lab3 {
    static public void main(String args[]) {
    	
    	Hardware cabinet = new Hardware("Cabinet", 12.99);
    	Computer d1 = new Part("Driver 1", 7.99);
    	Computer d2 = new Part("Driver 2", 8.99);
    	Computer d3 = new Part("Driver 3", 9.99);
    	
    	Hardware board = new Hardware("Board", 31.99);
    	Computer bus = new Part("Bus", 22.99);
    	Computer c1 = new Part("Card 1", 7.99);
    	Computer c2 = new Part("Card 2", 7.99);
    	Computer c3 = new Part("Card 3", 7.99);
    	Computer c4 = new Part("Card 4", 7.99);
    	board.addPart(c1);
    	board.addPart(c2);
    	board.addPart(c3);
    	board.addPart(c4);
    	board.addPart(bus);
    	
    	cabinet.addPart(d1);
    	cabinet.addPart(d2);
    	cabinet.addPart(d3);
    	cabinet.addPart(board);

    	System.out.println("Total price of the computer is: " + new DecimalFormat("#0.00").format(cabinet.computePrice()));
    }
}
