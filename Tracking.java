
package projectr;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracking {
    private String OrderNumber;

    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void mapping() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ;
        System.out.println("Enter your Order number for tracking ");
        String readTracking = scanner.nextLine();

    }

    public void displayTracking() throws IOException {
        Scanner scanner = new Scanner(System.in);
        file read = new file();
        Tracking Tracking = new Tracking();
        int a = 0;
        while (a != 3) {
            System.out.println("1- tracking map");
            System.out.println("2- Shipment Tracking ");
            System.out.println("3- exit ");
            a = scanner.nextInt();
            switch (a) {
                case 1:
                    Tracking.mapping();
                    break;
                case 2:
                    String OrderNumber;
                    System.out.println("Tracking Page");
                    System.out.print("Enter Your Order Number To Tracking\n");
                    OrderNumber = validateOrderNumber(scanner.nextLine());
                    System.out.println("This is your Shipment Information");
                    read.read(OrderNumber);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("you only can enter 1 , 2 and 3 ");

                    break;
            }
        }
    }
    private String validateOrderNumber(String OrderNumber) {
        while (!OrderNumber.matches("\\d{10}")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Invalid order number. Please enter a 10-digit number.");
            OrderNumber = scanner.nextLine();
        }
        return OrderNumber;
    }

    public void trackingMainPage() throws IOException {
        Scanner input = new Scanner(System.in);
        Tracking Tracking = new Tracking();
        Delivery OrderDelivery = new Delivery();
        int a = 0;
        while (a != 3) {
            System.out.println("1- Shipment Order Delivery");
            System.out.println("2- Shipment Tracking ");
            System.out.println("3- Logout");
            System.out.print("please pick a number :");
            a = input.nextInt();

            switch (a) {
                case 1:
                    OrderDelivery.displayOrderDelivery();
                    break;
                case 2:
                    Tracking.displayTracking();
                    break;
                case 3:
                    System.out.println("thank you for using our app");
                    break;
                default:
                    System.out.println("you only can enter 1 , 2  and 3");

                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Tracking Tracking = new Tracking();
        Login login = new Login();
        SignUpPage SignUp = new SignUpPage();
        boolean c = true;
        int b = 0;
        while (b != 3) {

            System.out.println("welcome in Ordering Shipment System !please Choice: ");
            System.out.println("1- login ");
            System.out.println("2- SignUp ");
            System.out.println("3- exit ");
            b = input.nextInt();
            switch (b) {
                case 1:
                    login.displayLogin();
                    System.out.println("Your account has been logged in!");
                    Tracking.trackingMainPage();
                    break;

                case 2:
                    SignUp.displaySignUpPage();
                    break;
                case 3:
                    System.out.println("thank you for using our app");

break;
                default:
                    System.out.println("you only can enter 1 , 2  and 3");

                    break;
            }
        }
    }
}