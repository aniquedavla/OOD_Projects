import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by elmog on 2/22/2017.
 */
public class ATMSystem {
    public final static int numberOfAAccounts = 2;
    public final static int numberOfBAccounts = 2;
    public final static int numberOfExpirationDateElements = 3;

    //database of expiration date
    public static int[] expirationDate(String cardNumber) {
        int[] A = new int[3];
        //0 -> month
        //1 -> day
        //2 -> year
        if (Objects.equals(cardNumber, "A11")) { //expired
            A[0] = 1;
            A[1] = 3;
            A[2] = 16;
        } else if (Objects.equals(cardNumber, "A12")) { //
            A[0] = 2;
            A[1] = 3;
            A[2] = 18;
        } else if (Objects.equals(cardNumber, "B111")) { //=
            A[0] = 4;
            A[1] = 2;
            A[2] = 17;
        } else if (Objects.equals(cardNumber, "B122")) { //
            A[0] = 5;
            A[1] = 24;
            A[2] = 18;
        } else if (Objects.equals(cardNumber, "B133")) { //
            A[0] = 6;
            A[1] = 25;
            A[2] = 19;
        } else {
            A[0] = 1;
            A[1] = 1;
            A[2] = 10;
        }
        return A;
    }

    private static String enterYourCard() {
        System.out.println("Enter your card");
        Scanner var = new Scanner(System.in);
        return var.nextLine();//string ---- A11, A12, B111, B122, B133  cardNumbers
    }

    private static String atmOfChoice() {
        System.out.println("Enter your choice of ATM");
        Scanner var = new Scanner(System.in);
        return var.nextLine(); //string --- atmChoice = ATM_A1 or ATM_A2 or ATM_B1 or ATM_B2
    }

    private static boolean authorize(ATM ATMsBankX) {
        System.out.println("The card is accepted. Please enter your password. " +
                "(ATM takes this password and sends it back to the bank");
        Scanner var = new Scanner(System.in);
        boolean authorization = false;
        while (!authorization) {
            authorization = ATMsBankX.checkPassword(var.nextLine());
            if (authorization) {
                System.out.print("Authorization is accepted.");
            } else {
                System.out.println("This is a wrong password. Enter your password.");
            }
        }
        return authorization;
    }

    private static boolean withdrawalAmount(ATM ATMsBankX) {
        Scanner var = new Scanner(System.in);
        byte withdrawalSuccess = 0;
        int amount = 0;
        String scannedString;
        do {
            scannedString = var.nextLine();
            if (scannedString.matches("\\d+")) {
                amount = Integer.parseInt(scannedString);
                withdrawalSuccess = ATMsBankX.withdraw(amount);
            } else if (scannedString.matches("quit")) {
                withdrawalSuccess = 10;
            } else {
                System.out.println("you are not supposed to input anything other than quit");
            }

            if (withdrawalSuccess == -1) {
                System.out.println("The amount exceeds the maximum amout you can withdraw per transaction" +
                        " Please enter the amount or quit");
            } else if (withdrawalSuccess == 1) {
                System.out.println("(ATM passes $" + amount + " to the bank to " +
                        "determine the current balance can afford this money.)");
                System.out.println("$" + amount + " is withdrawn from your account." +
                        "The remaning balance of this account is $" + ATMsBankX.getBalance() + ". " +
                        "If you have more transactions, enter the amount or quit");
            } else if (withdrawalSuccess == 0) {
                System.out.println("The amount exceeds the current balance. Enter another amount or quit");
            } else if (withdrawalSuccess == 10) {
                System.exit(0);
            } else {
                System.out.println("error");
            }
        }
        while (withdrawalSuccess != 10);
        return true;
    }

    private static byte validationMainCheck(CashCard atmXCard, ATM ATMsBankX) {//}, String cardNumber1) {
        String cardNumber1;
        byte validateReturn;
        validateReturn = ATMsBankX.validate();
        while (validateReturn != 1) {
            if (validateReturn <= -1) {
                System.out.println("This card is expired and returned to you");
                cardNumber1 = enterYourCard();
                atmXCard.setCardNumber(cardNumber1);
                atmXCard.setExpirationDate(expirationDate(cardNumber1));
                validateReturn = ATMsBankX.validate();
            } else if (validateReturn == 0 || validateReturn > 1) {
                System.out.println("This card is not supported by this ATM");
                cardNumber1 = enterYourCard();
                atmXCard.setCardNumber(cardNumber1);
                atmXCard.setExpirationDate(expirationDate(cardNumber1));
                validateReturn = ATMsBankX.validate();
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String bankAID = "A";//A or B
        ArrayList<Integer> bankAAccountNumbers = new ArrayList<>();
        bankAAccountNumbers.add(11);//11,12 ... 111,122,133
        bankAAccountNumbers.add(12);
        ArrayList<String> bankAPasswords = new ArrayList<>();
        bankAPasswords.add("mypassword");//mypassword, mypassword
        bankAPasswords.add("mypassword");
        //Create bankA
        ArrayList<String> bankACardNumbers = new ArayList<>();//A11, A12, B111, B122, B133
        bankACardNumbers.add(bankAID + bankAAccountNumbers.get(0));
        bankACardNumbers.add(bankAID + bankAAccountNumbers.get(1));
        ArrayList<Integer> bankABalance = new ArrayList<>();
        bankABalance.add(40);
        bankABalance.add(40);
        Bank bankOfA = new Bank(bankAID, bankAAccountNumbers, bankAPasswords, bankACardNumbers, bankABalance);//,ATMsBankA);

//        int[] ExpirationDate = new int[numberOfExpirationDateElements];
        //        //bankACardNumbers,ExpirationDate /// to use setters, .add(set method)
        CashCard atmACard = new CashCard();//card number from user + read expiration date from card
        //CashCard atm2ACard=new CashCard();//card number from user + read expiration date from card
        ATM ATM1_A = new ATM(50, atmACard, bankOfA);
        ATM ATM2_A = new ATM(50, atmACard, bankOfA);
//        ATM[] ATMsBankA = new ATM[2];
//        ATMsBankA[0] = ATM1_A;
//        ATMsBankA[1] = ATM2_A;
        ATM[] ATMsBankA = {ATM1_A, ATM2_A};
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
        //Create bankB
        ArrayList<String> bankBCardNumbers = new ArrayList<>();
        ArrayList<Integer> bankBBalance = new ArrayList<>();
        bankBCardNumbers.add(bankBID + bankBAccountNumbers.get(0));
        bankBCardNumbers.add(bankBID + bankBAccountNumbers.get(1));
        bankBCardNumbers.add(bankBID + bankBAccountNumbers.get(2));
        bankBBalance.add(50);
        bankBBalance.add(50);
        Bank bankOfB = new Bank(bankBID, bankBAccountNumbers, bankBPasswords, bankBCardNumbers, bankBBalance);
        CashCard atmBCard = new CashCard();//card number from user + read expiration date from card
        //CashCard atm2BCard=new CashCard();//card number from user + read expiration date from card
        ATM ATM1_B = new ATM(50, atmBCard, bankOfB);
        ATM ATM2_B = new ATM(50, atmBCard, bankOfB);
//        ATM[] ATMsBankA = new ATM[2];
//        ATMsBankA[0] = ATM1_A;
//        ATMsBankA[1] = ATM2_A;
        ATM[] ATMsBankB = {ATM1_B, ATM2_B};
        //==========///////////==================//////////////////===============
        //validation
        //int variable= var.nextInt(); //int
        //String variable= var.next(); //double
        String atmChoice = atmOfChoice(); //string --- atmChoice = ATM_A1 or ATM_A2 or ATM_B1 or ATM_B2
        String cardNumber = enterYourCard();//string ---- A11, A12, B111, B122, B133  cardNumbers
        byte validationReturn;
        if (Objects.equals(atmChoice, "ATM_A1") || Objects.equals(atmChoice, "ATM_A2")) {
            //atmA or bankA is used
            atmACard.setCardNumber(cardNumber);
            atmACard.setExpirationDate(expirationDate(cardNumber));
            if (Objects.equals(atmChoice, "ATM_A1")) {
                validationReturn = validationMainCheck(atmACard, ATMsBankA[0]);
            } else {
                validationReturn = validationMainCheck(atmACard, ATMsBankA[1]);
            }
        } else if (Objects.equals(atmChoice, "ATM_B1") || Objects.equals(atmChoice, "ATM_B2")) {
            //atmB or bankB is used
            atmBCard.setCardNumber(cardNumber);
            atmBCard.setExpirationDate(expirationDate(cardNumber));
            if (Objects.equals(atmChoice, "ATM_B1")) {
                validationReturn = validationMainCheck(atmACard, ATMsBankB[0]);
            } else {
                validationReturn = validationMainCheck(atmACard, ATMsBankA[1]);
            }

        } else {
            validationReturn = -1;
            System.out.println("The ATM you entered does not exist");
        }
        //==========///////////==================//////////////////===============
        //authorization
        boolean authorization;
        if (validationReturn == 1) {
            if (Objects.equals(atmChoice, "ATM_A1")) {
                authorization = authorize(ATMsBankA[0]);
            } else if (Objects.equals(atmChoice, "ATM_A2")) {
                authorization = authorize(ATMsBankA[1]);
            } else if (Objects.equals(atmChoice, "ATM_B1")) {
                authorization = authorize(ATMsBankB[0]);
            } else if (Objects.equals(atmChoice, "ATM_B2")) {
                authorization = authorize(ATMsBankB[1]);
            }
        }
        //==========///////////==================//////////////////===============
        //withdrawal
        boolean withdrawal=false;
        if (authorization = true) {
            System.out.println(" Start your transaction by entering the amout to withdraw");
            withdrawalAmount(ATMsBankA[0]);
            if (Objects.equals(atmChoice, "ATM_A1")) {
                withdrawal = withdrawalAmount(ATMsBankA[0]);
            } else if (Objects.equals(atmChoice, "ATM_A2")) {
                withdrawal = withdrawalAmount(ATMsBankA[1]);
            } else if (Objects.equals(atmChoice, "ATM_B1")) {
                withdrawal = withdrawalAmount(ATMsBankB[0]);
            } else if (Objects.equals(atmChoice, "ATM_B2")) {
                withdrawal = withdrawalAmount(ATMsBankB[1]);
            }
        }
    }
}
