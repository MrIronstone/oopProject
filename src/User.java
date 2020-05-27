import com.sun.tools.javac.Main;

public class User
{
    private String name;
    private String surname;
    private double customerNumber;
    private String emailAddress;
    private double password;
    private double telephoneNumber;
    private Account[] bankAccounts;
    private CreditCard[] creditCards;
    private int accountCounter=0;
    private int creditCardCounter=0;


    public User(String name, String surname, double customerNumber, String emailAddress,
                double password, double telephoneNumber){
        this.name=name; this.surname=surname; this.customerNumber=customerNumber;
        this.emailAddress=emailAddress; this.password=password; this.telephoneNumber=telephoneNumber;
        this.bankAccounts = new Account[5];
        this.creditCards = new CreditCard[2];
        MainPanel.userCounter++;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public double getCustomerNumber()
    {
        return customerNumber;
    }

    public void setCustomerNumber(double customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public double getPassword()
    {
        return password;
    }

    public void setPassword(double password)
    {
        this.password = password;
    }

    public double getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(double telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public Account[] getBankAccounts()
    {
         return bankAccounts;
    }

    public void setBankAccounts(Account[] bankAccounts) {
        this.bankAccounts = bankAccounts;

    }

    public CreditCard[] getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(CreditCard[] creditCards) {
        this.creditCards = creditCards;
    }

    public int getAccountCounter() {
        return accountCounter;
    }

    public void setAccountCounter(int accountCounter) {
        this.accountCounter = accountCounter;
    }

    public int getCreditCardCounter() {
        return creditCardCounter;
    }

    public void setCreditCardCounter(int creditCardCounter) {
        this.creditCardCounter = creditCardCounter;
    }
}
