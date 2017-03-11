import java.text.SimpleDateFormat;

/**
 * Created by elmog on 2/22/2017.
 */
public class ATM {
    private int maxAmount;//max amount per transaction
    private CashCard cardInProcess;
    private Bank associatedBank;

    public ATM(int maxAmount, CashCard cardInProcess, Bank associatedBank) {
        this.maxAmount = maxAmount;
        this.cardInProcess = cardInProcess;
        this.associatedBank = associatedBank;
    }

    public String withdraw(int amount){
        associatedBank.withdraw(amount, cardInProcess.getCardNumber());
        return null;
    }

    public String validate(){//String cardNumber){
        if ( associatedBank.validate(cardInProcess.getCardNumber(), cardInProcess.getExpirationDate() )== "card validated" ) {
            return "card validated at ATM";
        }
        else{
            return "card returned, can not be validated";
        }
    }

    public void returnCard(){
        System.out.println("card returned");
    }

    public boolean checkPassword(String password){
        associatedBank.checkPassword(password, cardInProcess.getCardNumber());
        return false;
    }
    SimpleDateFormat

//    public void inputCard(CashCard card){
//        System.out.println("card is placed in atm");
//    }
}
