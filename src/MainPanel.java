import java.util.Scanner;

public class MainPanel{
    static Scanner input = new Scanner(System.in);


    public static int  userCounter=0;
    static User[] customers = new User[100];
    static User currentUser;

    void payDebt(){
        System.out.println("Please enter the credit card number you want to pay debt of ");
        double selectedCreditCardNumber = input.nextDouble();

        System.out.println("Please enter your Account number you want to transfer from");
        int accountNumber= input.nextInt();

        Account selectedAccount = null;

        for(int i = 0 ; i < currentUser.getBankAccounts().length; i++){
            if(currentUser.getBankAccounts()[i].getAccountNumber()==accountNumber){
                selectedAccount = currentUser.getBankAccounts()[i];
            }
            else {
                System.out.println("You don't have an account that has this account number");
            }
        }


        for(int i=0; i < currentUser.getCreditCards().length ; i++) {
            if(selectedCreditCardNumber==currentUser.getCreditCards()[i].getCreditCardNumber()){
                System.out.println("Please enter the amount you want to pay");
                int amount = input.nextInt();
                currentUser.getCreditCards()[i].payDebt(amount,selectedAccount);
            }
        }
    }

    void EFTforCurrentUser(){
        System.out.println("Please enter the amount you want to transfer");
        int amount = input.nextInt();

        System.out.println("Please enter your Account number you want to transfer from");
        int accountNumber= input.nextInt();

        Account selectedAccount = null;

        for(int i = 0 ; i < currentUser.getBankAccounts().length; i++){
            if(currentUser.getBankAccounts()[i].getAccountNumber()==accountNumber){
                selectedAccount = currentUser.getBankAccounts()[i];
            }
            else {
                System.out.println("You don't have an account that has this account number");
            }
        }

        System.out.println("Please enter the IBAN number of the  you want to transfer to ");
        String IBAN = input.nextLine();

        for(int sayac = 0 ; sayac < customers.length-1 ; sayac++){
            for( int sayac2= 0; sayac2 < customers[sayac].getBankAccounts().length; sayac2++){
                if(customers[sayac].getBankAccounts()[sayac2].getIbanNumber()==IBAN){
                    selectedAccount.EFT(amount,customers[sayac].getBankAccounts()[sayac2]);
                }
            }
        }

    }

    void addCard(){
        int nextCreditCardCounter = currentUser.getCreditCardCounter()+1;
        currentUser.getCreditCards()[nextCreditCardCounter] = new CreditCard();
        System.out.println("Credit card is created.");
    }

    void addAccount(){
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
        System.out.println("Account is created");

    }

    static void logOut(){
        currentUser=null;
        System.out.println("Logged out.");
    }

    static boolean logIn(){
        // this method is used by user
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
        System.out.println("1 for log in \n2 for sign up");
        int x = input.nextInt();
        if(x==1){
            logIn();
            System.out.println("1 for add account \n2 for add card");
        }
        else if(x==2){
            newUser();
        }
        else{
            System.out.println("Yanlış tuş girildi");
        }

    }
}

