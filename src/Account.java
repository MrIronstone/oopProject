public class Account {

    private int balance;
    private int minimumBalanceLimit;
    private double accountNumber;
    private String IbanNumber;
    private static int accountCounter=0;
    // deneme



    public Account(int balance, int minimumBalanceLimit, double accountNumber, String IbanNumber){
        this.balance=balance;
        this.minimumBalanceLimit=minimumBalanceLimit;
        this.accountNumber=accountNumber;
        this.IbanNumber=IbanNumber;
        this.accountCounter++;
    }

    public int getAccountCounter() {
        return accountCounter;
    }

    public void setAccountCounter(int accountCounter) {
        this.accountCounter = accountCounter;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMinimumBalanceLimit() {
        return minimumBalanceLimit;
    }

    public void setMinimumBalanceLimit(int minimumBalanceLimit) {
        this.minimumBalanceLimit = minimumBalanceLimit;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIbanNumber() {
        return IbanNumber;
    }

    public void setIbanNumber(String IbanNumber) {
        this.IbanNumber = IbanNumber;
    }

    public void addBalance(int amount){
        this.balance=this.balance+amount;
    }
    public void subtractBalance(int amount){
        this.balance=this.balance-amount;
    }
    public boolean isEligible(int amount) {
        return this.balance>=amount;  // eft limit is bank balance;
    }
    public void EFT (int amount, Account receiver){
        if(isEligible(amount)) {
            this.balance = this.balance - amount;
            receiver.balance = receiver.balance + amount;
            System.out.println("[EFT completed. EFT amount is "+amount
                    +" and your new balance is "+this.balance+"]");
        }
        else{
            System.out.println("[You don't acquire the requirements of EFT "+
                                "Your requested amount is " + amount +
                                " But your balance is "+ this.balance+
                                " Your requested amount must be between "+this.minimumBalanceLimit +
                                " and " +this.balance+"]");
        }
    }
}
