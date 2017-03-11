import java.util.ArrayList;

public class Bank {
    private String bankID;
    private ArrayList<ATM> atm = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String bankID){
        this.bankID = bankID;
    }

    public void addAccount(Account theAccount){
        accounts.add(theAccount);
    }
    public Account findAccount(String cardNumber){
        Account theAccount = null;
        for(Account theAcc: accounts){
            if(theAcc.getCashCardAssociated().getCardNumber().equals(cardNumber)){
                theAccount = theAcc;
            } else {
                return null;
            }
        }
        return theAccount;
    }
    public String getBankID(){
        return bankID;
    }
    public boolean checkCardPassword(String cardNumber, String password){
        return findAccount(cardNumber).getPassword().equals(password);

    }


    public String withdraw(String cardNumb, double transactionAmount) {
        double currentBalance = findAccount(cardNumb).getBalance();
        if(transactionAmount <= currentBalance){
            findAccount(cardNumb).setBalance(currentBalance-transactionAmount);
            return "$"+transactionAmount +"is withdrawn from  your account. Remaining balance for card number " +cardNumb+" : "+"$"+findAccount(cardNumb).getBalance()+". If you have more transactions, enter the amount or quit.";
        } else {
            return "The amount exceeds the current balance of "+ currentBalance +" . Enter another amount or quit.";
        }
    }
}
