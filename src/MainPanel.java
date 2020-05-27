import java.util.ArrayList;
import java.util.Scanner;

public class MainPanel{

    public static int  userCounter=0;
    static User[] customers = new User[100];
    static User currentUser;

    static void addAccount(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your balance");
        int balance = input.nextInt();
        System.out.println("Please enter your minimum balance limit");
        int minimumBalanceLimit = input.nextInt();
        System.out.println("Please enter your accountNumber");
        double accountNumber = input.nextDouble();
        System.out.println("Please enter your IBan Number");
        String IbanNumber = input.nextLine();

        int nextAccountCounter = currentUser.getAccountCounter()+1;
        currentUser.getBankAccounts()[nextAccountCounter] = new Account(balance,minimumBalanceLimit,accountNumber,IbanNumber);

    }

    static boolean logIn(){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your customer Number");
        double customerNumber = input.nextDouble();
        System.out.println("Please enter your password");
        double password = input.nextDouble();


        for(int i=0; i < customers.length-1; i++){ // scans all the array
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

    public static void newUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = input.nextLine();

        System.out.println("Please enter your surname");
        String surname = input.nextLine();

        System.out.println("Please enter your customer number");
        double customerNumber = input.nextDouble();

        System.out.println("Please enter your email address");
        String emailAddress = input.nextLine();

        System.out.println("Please enter your password");
        double password = input.nextDouble();

        System.out.println("Please enter your telephone number");
        double telephoneNumber = input.nextDouble();



        customers[userCounter] = new User(name, surname, customerNumber,
                emailAddress, password, telephoneNumber);
        System.out.println("User has been created successfully");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 for log in, 2 for sign up");
        int x = input.nextInt();
        if(x==1){
            logIn();


        }
        if (x==2){
            newUser();

        }

    }
}

