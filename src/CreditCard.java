public class CreditCard {
    // class properties
    private double limit;
    private double creditCardNumber;
    private int totalDebt;
    private int minimumDebt; // the minimum amount of paying debt
    private int creditCardCounter=0;

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(double creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public int getMinimumDebt() {
        return minimumDebt;
    }

    public void setMinimumDebt(int minimumDebt) {
        this.minimumDebt = minimumDebt;
    }
    public CreditCard(double limit, double creditCardNumber, int totalDebt, int minimumDebt){
        // constructor method
        this.limit=limit;
        this.creditCardNumber=creditCardNumber;
        this.totalDebt=totalDebt;
        this.minimumDebt=minimumDebt;
        this.creditCardCounter++;

    }
    public CreditCard(){
        // polymorphic constructor
        this(100,1,50,0);
    }
    public void withdrawDebt(int amount, Account account1){
        if(amount <= (this.limit - this.totalDebt)){
            account1.setBalance(account1.getBalance()+amount);        // this command withdraws the money
            this.totalDebt=this.totalDebt+amount;               // this command line increase the total debt
            System.out.println("[The amount of withdrawn money is "+ amount+
                    " Your new bank balance is "+ account1.getBalance()+
                    " Your new total debt is "+this.totalDebt+"]");
        }
        else{
            System.out.println("[You dont acquire the the requirements of withdraw"+
                    " Your requested amount "+amount+"" +
                    " is lower than your remaninig limit "+(this.limit-this.totalDebt)+"]"); // reamining limit
        }
    }

    public void payDebt(int amount, Account account1){   // pay debt method
        if((account1.getBalance() >= amount) && (amount >=this.minimumDebt) ){
            /*
             if the account has enough money to pay the debt and if the amount is higher than minimum debt
             value, then the money from the bank balance will be transferred to the credit card and
             the amount will be cut down from total debt.
             */
            this.totalDebt=this.totalDebt-amount;
            account1.subtractBalance(amount);        // this method is the one that subtract the money from balance
        }

    }

}
