package projectr;
import java.io.*;
import java.util.Scanner;

public class file {
    public void write(String information,String PhoneNumber) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(PhoneNumber+".txt" ,true));
            BufferedWriter aa = new BufferedWriter(new FileWriter(PhoneNumber+"-tracking.txt" ,true));
            write.write(information + "\n");
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToJson(String information) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("AllInformation.JSON", true));
            BufferedReader read = new BufferedReader(new FileReader("AllInformation.JSON"));
                String line ;
                if ((line = read.readLine()) == null) {
                    write.write("[{" + information + "}\n");
                }
                else{
                    write.write(", {" + information + "}\n");
                }
                write.close();

                }
             catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        public void read(String PhoneNumber) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(PhoneNumber+".txt"));
        String line;

        while ((line = read.readLine()) != null) {
            System.out.println(read.readLine());
        }
        read.close();
    }
    public void login(String password,String Username) throws IOException {

        SignUpPage signUp = new SignUpPage();
        BufferedReader read = new BufferedReader(new FileReader(Username+".txt"));
        BufferedReader read2 = new BufferedReader(new FileReader(Username+"-password.txt"));
        String line;
        String line2;
        while ((line = read.readLine()) != null && (line2 = read2.readLine()) != null){
            if((line = read.readLine()).equals(Username) && (line2 = read2.readLine()).equals(password)) {
                System.out.println("correct Username and password");
            }
            else {
                System.out.println("wrong username or password");

            }

        }
        read.close();
    }
    public void writeInformationSignUp(String information)throws IOException {
        BufferedWriter write = new BufferedWriter(new FileWriter("usersinfo.txt" ,true));
        write.write(information + "\n");
        write.close();
    }
    public void writeUsernameSignUp(String information, String fileName) throws IOException {
        BufferedWriter write = new BufferedWriter(new FileWriter(fileName+".txt" ,true));
        write.write(information + "\n");
        write.close();
    }
    public void writePasswordSignUp(String information, String fileName)throws IOException {
        BufferedWriter write = new BufferedWriter(new FileWriter(fileName+"-Password.txt" ,true));
        write.write(information + "\n");
        write.close();
    }
    public void SignUp(String information,String fileUsername,String password,String Username)throws IOException  {
            file file = new file();
            file.writeInformationSignUp(information);
            file.writePasswordSignUp(password,fileUsername);
            file.writeUsernameSignUp(Username,fileUsername);


    }

}
