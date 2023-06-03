package projectr;
import java.io.IOException;
import java.io.IOException;
import java.util.Scanner;

public class SignUpPage {
    // Fields
    private String FirstName;
    private String LastName;
    private String Username;
    private String PhoneNumber;
    private String Password;
    private String ConfirmPassword;

    Scanner scanner = new Scanner(System.in);



    // Setters and getters
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setUsername(String Usernamel) {
        this.Username = Username;
    }

    public String getUsername() {
        return Username;
    }

     public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
   
     public String getPhoneNumber() {
        return PhoneNumber;
    }
     
    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return Password;
    }
    public void setConfirmPassword(String password) {
        this.ConfirmPassword = ConfirmPassword;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }
    // Methods
    

    public boolean displaySignUpPage() throws IOException {
        file file = new file();

        System.out.println("Welcome to our sign-up page!");
        System.out.println("Please fill out the following information to create your account:");


        System.out.print("First Name: ");
        setFirstName(validateInput(scanner.nextLine(), 3));

        System.out.print("Last Name: ");
        setLastName(validateInput(scanner.nextLine(), 3));

        System.out.print("Username: ");
        String User = (validateInput(scanner.nextLine(), 3));
        System.out.print("Phone Number: ");
        setPhoneNumber(validatePhoneNumber(scanner.nextLine()));

        System.out.print("Password: ");
        setPassword(validatePassword(scanner.nextLine()));

        System.out.print("Confirm Password: ");
        setConfirmPassword(validateConfirmPassword(scanner.nextLine()));

        System.out.println("Your account has been created.");

        file.SignUp("\n"+getFirstName() + " " + getLastName() + " " + User + " " + getPhoneNumber() + " " + getPassword() , User , "\n"+getPassword() ,"\n"+User);
        return false;
    }

    private String validateInput(String input, int minLength) {
        while (input.trim().length() < minLength) {
            System.out.println("Invalid input. The input must have at least " + minLength + " characters. Please try again.");
            input = scanner.nextLine();
        }
        return input;
    }

    private String validatePhoneNumber(String phoneNumber) {
        while (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Invalid phone number. Please enter a 10-digit number.");
            phoneNumber = scanner.nextLine();
        }
        return phoneNumber;
    }

    private String validatePassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[@#$%]).{8,}$";

        while (!password.matches(passwordRegex)) {
            System.out.println("Invalid password. The password must be at least 8 characters long and contain at least one uppercase letter and one of the following special characters: @, #, $, or %.");
            password = scanner.nextLine();
        }

        return password;
    }

    private String validateConfirmPassword(String confirmPassword) {
        while (!confirmPassword.equals(getPassword())) {
            System.out.println("Passwords do not match. Please try again.");
            confirmPassword = scanner.nextLine();
        }
        return confirmPassword;
    }

    public static void main(String[] args) throws IOException {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.displaySignUpPage();
     
    }
}