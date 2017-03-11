import java.util.Objects;

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

    public byte withdraw(int amount){
        return (associatedBank.withdraw(amount, cardInProcess.getCardNumber()));
    }

    //-1<= expired //0== does not belong to bankid //1>= validated
    public byte validate(){//String cardNumber){
        byte i;
        i=associatedBank.validate(cardInProcess.getCardNumber(), cardInProcess.getExpirationDate());
        if(i<=-1) return -1;    //expired
        else if(i==0) return 0; //does not belong to bankid
        else if(i>=1) return 1; //validated
        else return 0; //default
//            return "card returned, can not be validated at ATM";
    }
    public int getBalance() {
        return associatedBank.getBalance(cardInProcess.getCardNumber());
    }
        public void returnCard(){
        System.out.println("card returned");
    }

    public boolean checkPassword(String password){
        return (associatedBank.checkPassword(password, cardInProcess.getCardNumber()));
    }

//    public void inputCard(CashCard card){
//        System.out.println("card is placed in atm");
//    }
}
