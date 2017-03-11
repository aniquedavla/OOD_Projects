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
        for(int i=0;i<this.cardNumbers.size();i++){
            if(Objects.equals(this.cardNumbers.get(i),cardNumber)){
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

    //expirationdate is array of 3 ...//-1<= expired //0== does not belong to bankid //1>= validated
    public byte validate(String cardNumber, int[] expirationDate){
        if (!cardBelongsToBank(cardNumber)){
            //System.out.println( "card does not belong to bankid");
            return 0;
        }
        //IMPORTANT: I would use real time date but I will use todays date for the assignment.
        int[] todaysDate={2,22,17};
        if(expirationDate[2] < todaysDate[2]) { //year
            System.out.println("validation of the year failed");
            return -1;
        }
        else if (expirationDate[2] > todaysDate[2]) {
            System.out.println( "card validated");
            return 1;
        }
        else { // same year ==
            //check month
            if (expirationDate[0] < todaysDate[0]) {
                System.out.println("validation of the year/month failed");
                return -1;
            } else if (expirationDate[0] > todaysDate[0]) {
                System.out.println( "card validated");
                return 1;
            } else { //same month ==
                //check days
                if (expirationDate[1] < todaysDate[1]) {
                    System.out.println( "validation of the year/month/day failed");
                    return -1;
                } else if (expirationDate[1] > todaysDate[1]) {
                    System.out.println( "card validated");
                    return 1;
                } else { //same days
                    System.out.println( "card validated");
                    return 1;
                }
            }
        }
}

    public boolean checkPassword(String password, String cardNumber){
        for(int i=0; i<this.cardNumbers.size(); i++){
            if(Objects.equals(this.cardNumbers.get(i), cardNumber)){
                if(Objects.equals(this.passwords.get(i), password)) {
                    return true;
                }
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
    public byte withdraw(int amount, String cardNumber) {
        for (int i = 0; i < this.cardNumbers.size(); i++) {
            if (Objects.equals(this.cardNumbers.get(i), cardNumber)) {
                if(amount > 50){
                    return -1; //amount exceed maximum per transacrion of atm
                }
                else if(this.balance.get(i) < amount){ //amount exceeds balance
                   return 0;
                }
                int balanceTemp = this.balance.get(i) - amount;
                this.balance.set(i,balanceTemp);
                return 1;//transaction successful
            }
        }
        return 0;
    }
    public int getBalance(String cardNumber) {
        for (int i = 0; i < this.cardNumbers.size(); i++) {
            if (Objects.equals(this.cardNumbers.get(i), cardNumber)) {
                return this.balance.get(i);
            }
        }
        return 0;
    }

    //boolean return false
    //string return  null
    //number return 0
    //string is object
    //obj -> null
    //number -> 0

}
