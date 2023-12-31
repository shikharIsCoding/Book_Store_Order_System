public class Invoice {
    //attributes
    private String invoiceNbr;
    private Shipping bookOrder;
    private Stock stock;
    private Shipping shipOrder;
    private double totalCost;



    //complete the constructor
  public Invoice (String invoiceNbr, Stock stock, Shipping shipOrder){
      this.invoiceNbr = invoiceNbr;
      this.stock = stock;
      this.shipOrder = shipOrder;
  }

    //complete the getter()
    public String getInvoiceNbr(){
      return invoiceNbr;
    }

    public double invoice(){
      totalCost = stock.getPrice()+ shipOrder.getShipCost();
      return totalCost;
    }


    //complete the totalCost for a shipping order

}
