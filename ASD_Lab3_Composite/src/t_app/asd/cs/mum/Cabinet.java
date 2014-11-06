package t_app.asd.cs.mum;

import java.util.*;

public class Cabinet {
  private Board board;
  private Vector<Drive> drivelist = new Vector<>();
  public void setBoard (Board b){
    board=b;
  }
  public void addDrive (Drive d){
    drivelist.addElement(d);
  }
  public double netPrice()      {return 6.00;}
  public double discountPrice() {return 3.00;}
  
  public double computePrice(){
    double tmp=netPrice();
    if (board!= null)
       tmp+=board.computePrice();
    for (Drive drive  : drivelist)
        tmp+=drive.computePrice();
    return tmp;  
  }
}
