import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by elmog on 2/22/2017.
 */
public class Bank {
    private String bankID;//A
    private ArrayList<Integer> accountNumbers;//11
    private ArrayList<String>  passwords;//"mypassword"
    private ArrayList<String>  cardNumbers;//A11
    private ArrayList<Integer> balance;

    //ATM[] atms = new ATM[2];

    public Bank(String bankID, ArrayList<Integer> accountNumbers, ArrayList<String> passwords, ArrayList<String> cardNumbers, ArrayList<Integer> balance){//, ATM[] atms) {
        this.bankID = bankID;
        this.accountNumbers = accountNumbers;
        this.passwords = passwords;
        this.cardNumbers = cardNumbers;
        this.balance = balance;
        //this.atms = atms;
    }

    /**
     *
     * @param bankID
     * @return
     */
    private boolean bankIDMatches(String bankID){
        if(this.bankID == bankID) {
            return true;
        }
        return false;
    }

    //checks if the card is within the bank system or not
    public boolean cardBelongsToBank(String cardNumber){
        for(String s : cardNumbers){
            if(s==cardNumber){
                return true;
            }
        }
        return false;
    }

    //A11 ... 11 out
    private int extractAccountNumber(String cardNumber){
        for(int i=0; i<this.cardNumbers.size(); i++){
            if(Objects.equals(this.cardNumbers.get(i), cardNumber)){
                return this.accountNumbers.get(i);
            }
        }
        return -1;
    }

    //expirationdate is array of 3
    public String validate(String cardNumber, int[] expirationDate){
        if (!cardBelongsToBank(cardNumber)){
            return "card does not belong to bankid";
        }
        //IMPORTANT: I would use real time date but I will use todays date for the assignment.
        int[] todaysDate={2,22,17};
        if(expirationDate[2] < todaysDate[2]) { //year
            return "validation of the year failed";
        }
        else if (expirationDate[0] > todaysDate[0]) {
            return "card validated";
        }
        else { // same year ==
            //check month
            if (expirationDate[0] < todaysDate[0]) {
                return "validation of the year/month failed";
            } else if (expirationDate[0] > todaysDate[0]) {
                return "card validated";
            } else { //same month ==
                //check days
                if (expirationDate[1] < todaysDate[1]) {
                    return "validation of the year/month/day failed";
                } else if (expirationDate[1] > todaysDate[1]) {
                    return "card validated";
                } else { //same days
                    return "card validated";
                }
            }
        }
}

    public boolean checkPassword(String password, String cardNumber){
        for(int i=0; i<this.cardNumbers.size(); i++){
            if(Objects.equals(this.cardNumbers.get(i), cardNumber)){
                if(Objects.equals(this.passwords.get(i), password))
                    return true;
            }
        }
        return false;
    }

    //false did not go

    /**
     *
     * @param amount
     * @param cardNumber
     * @return
     */
    public boolean withdraw(int amount, String cardNumber) {
        for (int i = 0; i < this.cardNumbers.size(); i++) {
            if (Objects.equals(this.cardNumbers.get(i), cardNumber)) {
                if(this.balance.get(i) < amount){
                   return false;
                }
                int balanceTemp = this.balance.get(i) - amount;
                this.balance.set(i,balanceTemp);
                return true;
            }
        }
        return false;
    }

    //boolean return false
    //string return  null
    //number return 0
    //string is object
    //obj -> null
    //number -> 0

}
