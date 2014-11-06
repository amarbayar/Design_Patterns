package t_app.asd.cs.mum;

public class Drive {
  public double netPrice()     {return 10.00;}
  public double discountPrice() {return 4.00;}
  public double computePrice(){
    return discountPrice();  
  }
}

