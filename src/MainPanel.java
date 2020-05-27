import java.util.ArrayList;
import java.util.Scanner;

public class MainPanel{

    public static int  userCounter=0;
    static User[] customers = new User[100];
    static User currentUser;

    static void addAccount(int balance,
                           int minimumBalanceLimit,
                           double accountNumber,
                           String IbanNumber){


    }

    static boolean logIn(double customerNumber, double password){
        for(int i=0; i < customers.length-1; i++){
            if(customerNumber == customers[i].getCustomerNumber()) {
                if (password == customers[i].getPassword()) {
                    System.out.println("Successfully logged in");
                    currentUser=customers[i];
                    return true;
                }
                else {
                    System.out.println("Invalid password");
                    return false;
                }
            }
            else{
                System.out.println("Invalid customer number");
                return false;
            }
        }
        System.out.println("debug");
        return false;
    }

    public static void newUser(String name,String surname,double customerNumber,String emailAddress,
                        double password, double telephoneNumber){

        customers[userCounter] = new User(name, surname, customerNumber,
                emailAddress, password, telephoneNumber);
        System.out.println("User has been created successfully");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        newUser("Husam","Demirtas",12345,
                "husamdemirtas1@gmail.com",12345,554947619);
        System.out.println(customers[0].getName());

        System.out.println("1 for log in, 2 for sign up");
        int x = input.nextInt();
        if(x==1){
            System.out.println("Please enter your customer number");
            double customerNo, pd;
            customerNo = input.nextDouble();
            System.out.println("Please enter your password");
            pd = input.nextDouble();
            logIn(customerNo,pd);
        }

    }
}

