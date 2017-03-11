/**
 * Created by elmog on 2/22/2017.
 */
public class CashCard {
    private String cardNumber;
    private int[] expirationDate;

    public CashCard(){//String cardNumber,int[] expirationDate){
        this.cardNumber = "x11";
        this.expirationDate = new int [3];
    }
    //setters are coming from user
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(int[] expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int[] getExpirationDate() {
        return expirationDate;
    }
}
