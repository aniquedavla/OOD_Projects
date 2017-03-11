/**
 * Created by aniquedavla on 2/25/17.
 */
public class CashCard {
    private String cardNumber;
    private String expirationDate;

    public CashCard(String cardNumber, String expirationDate){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public String getExpirationDate(){
        return expirationDate;
    }
}
