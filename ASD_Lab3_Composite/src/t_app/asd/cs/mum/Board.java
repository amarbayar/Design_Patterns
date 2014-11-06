package t_app.asd.cs.mum;

import java.util.*;

public class Board {
  private Bus bus;
  private Vector<Card> cardlist = new Vector<>();
  public void setBus (Bus b){
    bus=b;
  }
  public void addCard(Card d){
    cardlist.addElement(d);
  }
  public double netPrice()      {return 26.00;}
  public double discountPrice() {return  6.00;}
  
  public double computePrice(){
    double tmp=discountPrice();
    if (bus!= null)
       tmp+=bus.computePrice();
    for (Card card : cardlist)
        tmp+=card.computePrice();
    return tmp;
  }
}
