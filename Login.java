
package projectr;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;
    
   

     public void setUsername(String username) {
        this.username = username;
    }
     
    public String getUsername() {
        return username;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    
    // Method to verify login credentials
    public boolean verifyCredentials(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    public void displayLogin() throws IOException {



        System.out.println("Welcome to our Login page!");
        System.out.println("Please fill out the following information to Login to your account:");
        Scanner scanner = new Scanner(System.in);

        String username;
        do {
            System.out.print("Username (at least 3 characters): ");
            username = scanner.nextLine();
        } while (username.length() < 3);

        String password;
        boolean isValidPassword = false;
        do {
            System.out.print("Password (at least 8 characters, with one uppercase letter and one special character): ");
            password = scanner.nextLine();
            if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[!@#$%^&*()].*")) {
                isValidPassword = true;
            } else {
                System.out.println("Invalid password format. Please try again.");
            }
        } while (!isValidPassword);
        file file = new file();
        file.login( password , username );

    }

        public static void main(String[] args) throws IOException {
        Login Login = new Login();
        Login.displayLogin();
    }
}