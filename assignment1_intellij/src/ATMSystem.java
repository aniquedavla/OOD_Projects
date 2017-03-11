import java.util.ArrayList;

/**
 * Created by elmog on 2/22/2017.
 */
public class ATMSystem {
    public final static  int numberOfAAccounts=2;
    public final static  int numberOfBAccounts=2;
    public final static  int numberOfExpirationDateElements=3;
    public static void main(String[] args) {
        String bankAID = "A";//A or B
        ArrayList<Integer> bankAAccountNumbers = new ArrayList<>();
        bankAAccountNumbers.add(11);//11,12 ... 111,122,133
        bankAAccountNumbers.add(12);
        ArrayList<String> bankAPasswords = new ArrayList<>();
        bankAPasswords.add("mypassword");//mypassword, mypassword
        bankAPasswords.add("mypassword");
        //Create bankA
        ArrayList<String> bankACardNumbers = new ArrayList<>();//A11, A12, B111, B122, B133
        ArrayList<Integer> bankABalance = new ArrayList<>();
        bankABalance.add(50);
        bankABalance.add(50);
        Bank bankOfA = new Bank(bankAID,bankAAccountNumbers,bankAPasswords,bankACardNumbers, bankABalance);//,ATMsBankA);

        int[] ExpirationDate = new int[numberOfExpirationDateElements];
        CashCard atm1ACard=new CashCard(bankACardNumbers,ExpirationDate);//card number from user + read expiration date from card
        CashCard atm2ACard=new CashCard();//card number from user + read expiration date from card
        ATM ATM1_A = new ATM(50,atm1ACard,bankOfA);
        ATM ATM2_A = new ATM(50,atm2ACard,bankOfA);
//        ATM[] ATMsBankA = new ATM[2];
//        ATMsBankA[0] = ATM1_A;
//        ATMsBankA[1] = ATM2_A;
        ATM[] ATMsBankA = {ATM1_A,ATM2_A};
//        ========================================================

        //bank B
        String bankBID = "B";
        ArrayList<Integer> bankBAccountNumbers = new ArrayList<>();
        bankBAccountNumbers.add(111);
        bankBAccountNumbers.add(122);
        bankBAccountNumbers.add(133);
        ArrayList<String> bankBPasswords = new ArrayList<>();
        bankBPasswords.add("mypassword");
        bankBPasswords.add("mypassword");
        bankBPasswords.add("mypassword");
        //Create bankA
        ArrayList<String> bankBCardNumbers = new ArrayList<>();
        ArrayList<Integer> bankBBalance = new ArrayList<>();
        bankABalance.add(50);
        bankABalance.add(50);
        Bank bankOfB = new Bank(bankBID,bankBAccountNumbers,bankBPasswords,bankBCardNumbers,bankBBalance);
        CashCard atm1BCard=new CashCard();//card number from user + read expiration date from card
        CashCard atm2BCard=new CashCard();//card number from user + read expiration date from card
        ATM ATM1_B = new ATM(50,atm1BCard, bankOfB);
        ATM ATM2_B = new ATM(50,atm2BCard, bankOfB);
//        ATM[] ATMsBankA = new ATM[2];
//        ATMsBankA[0] = ATM1_A;
//        ATMsBankA[1] = ATM2_A;
        ATM[] ATMsBankB = {ATM1_B,ATM2_B};
        //print

        //        ========================================================


    }
}
