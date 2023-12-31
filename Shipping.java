
import java.time.LocalDate;


//import to be included
public class Shipping{
    private Order orderOBJECT;
    private LocalDate shipDate;
    private double shipCost;
    public static int countUrgent;

    public Shipping(Order orderObject,LocalDate shipDate ){

        this.orderOBJECT = orderObject;
        this.shipDate = shipDate;
    }


    public LocalDate getShipDate(){

        return shipDate;
    }

    public double getShipCost(){

        return shipCost;
    }

    public void setShipCost(double shipCost){

        this.shipCost = shipCost;
    }

    public double calcShipCost(boolean isUrgent){

        if (isUrgent==false){
            setShipCost(3.95);
            return getShipCost();

        }
        else {
            setShipCost(5.45);
            countUrgent+=1;
            return getShipCost();
            }



        }
    }
        




