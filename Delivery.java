
package projectr;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;


public class Delivery {
    private String recipientName;
    private String deliveryAddress;
    private String OrderNumber;
    private int deliveryFee;
    private int Wiegth;
    private String trucks;
    private int Distance;
   
    Scanner scanner = new Scanner(System.in);
    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

     public int getDeliveryFee() {

        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
  

    public int getWiegth() {
        return Wiegth;
    }

    public void setWiegth(int Wiegth) {
        this.Wiegth = Wiegth;
    }
    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }
 
     public String gettrucks() {
        return trucks;
    }

    public void settrucks(String trucks) {
        this.trucks = trucks;
    }

    // Methods
   
    public double calculateDeliveryFee(String truckType ,int Distance ) {
        // calculate delivery fee based on Truck type, Distance 
        double fee=0.0;
        if(truckType=="Heavy-duty trucks")
        {
            fee=Distance * 1.5;
        }
        else if (truckType=="Medium-duty trucks"){
            fee=Distance * 1;

        } else if (truckType=="Mini trucks"){ 
            fee = Distance*.5;

        }

        else {
            fee=Distance*.3;

        }
        return fee;
        
    }

    public String determineTruckType(int weight) {
        // determine the type of truck required based on weight order,
        // return a string representing the truck type
        //if wieght>= 18 M.k <=25  truck =Heavy-duty trucks
        String truck= "";
        if(Wiegth>=16 &&Wiegth<=25)
        truck="Heavy-duty trucks";
        else if(Wiegth>=4 &&Wiegth<=15)
        truck="Medium-duty trucks";
        else if(Wiegth>=1 &&Wiegth<=10)
        truck="Mini trucks";
        else 
        truck="Light commercial vehicles";
        return truck;
    }

    public void displayOrderDelivery() {
        System.out.println("Welcome to our Order Delivery page");
        System.out.println("Please fill out the following information to make a Ordering:");

        String OrderNumber;
            System.out.print("Enter Your Order Number (10 digits): ");
            OrderNumber = validateOrderNumber(scanner.nextLine());

        String recipientName;
        do {
            System.out.print("Recipient Name: ");
            recipientName = scanner.nextLine();
        } while (recipientName.isEmpty());

        String deliveryAddress;
        do {
            System.out.print("Delivery Address: ");
            deliveryAddress = scanner.nextLine();
        } while (deliveryAddress.isEmpty());
        int Wiegth=0;
        String truckType="";
        do {
            System.out.print("Order Weight : ");
            Wiegth = scanner.nextInt();
            truckType=determineTruckType(Wiegth);

        } while (Wiegth==0);
        int Distance=0;
        do {
            System.out.print("Order Distance : ");
            Distance = scanner.nextInt();

        } while (Distance==0);

        double deliveryFee = calculateDeliveryFee(truckType,Distance);
        System.out.println("\nOrdering Details:");
        System.out.println("order Number: " + OrderNumber);
        System.out.println("Recipient Name: " + recipientName);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Order Wiegth : " + Wiegth);
        System.out.println("Truck Type : " + truckType);
        System.out.println("Order Distrance : $" + Distance);
        System.out.println("Delivery Fee: $" + deliveryFee);
        LocalDate currentDate = LocalDate.now();
        System.out.println("Deliver after 5 days from " + currentDate);
        System.out.println("\n\n");

        file file = new file();
        file.write("\n"+OrderNumber + " " + recipientName + " " + deliveryAddress + " " + Wiegth + " "+truckType +"" +Distance+"" + deliveryFee +" "+ currentDate,OrderNumber);
        file.writeToJson(
            "\n "+"\"OrderNumber\": "
            +"\""+OrderNumber+"\"" 
            + ",\"recipientName\":"
            +"\""+recipientName +"\","
            +"\"deliveryAddress\":"
            +"\""+deliveryAddress+"\","
            +"\"Wiegth\":"
            + Wiegth+"\","

            +"\"truckType\":"+"\""
            + truckType+"\","
            +"\"Distance\":"+"\""
            + Distance+"\","
           
            +"\"deliveryFee\":"
            +deliveryFee+","
            +"\"Order date\":"
            +"\""+currentDate+"\""
            
            );
    }

    private String validateOrderNumber(String OrderNumber) {
        while (!OrderNumber.matches("\\d{10}")) {
            System.out.println("Invalid Order number. Please enter a 10-digit number.");
            OrderNumber = scanner.nextLine();
        }
        return OrderNumber;
    }

}