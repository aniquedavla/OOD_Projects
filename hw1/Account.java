/**
 * Created by aniquedavla on 2/25/17.
 */
public class Account {
    private CashCard cashCardAssociated;
    private int accountNumber;
    private String bankID;
    private double balance;
    private String password;

    public Account(CashCard cashCard, String password,double initialDeposit) {
        this.cashCardAssociated = cashCard;
        this.password = password;
        this.balance = initialDeposit;
    }

    public CashCard getCashCardAssociated() {
        return cashCardAssociated;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
