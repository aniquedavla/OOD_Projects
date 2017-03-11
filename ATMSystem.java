import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by aniquedavla on 2/25/17.
 */
public class ATMSystem {


    public static void main(String[] args) throws ParseException {
        Bank bankA = new Bank("A");
        Account acctA1 = new Account(new CashCard("A100","02/19"),"mypassword",100);
        bankA.addAccount(acctA1);

        Bank bankB = new Bank("B");
        Account acctB1 = new Account(new CashCard("B120","01/2012"),"123",200);
        bankB.addAccount(acctB1);
        ATM atm1A = new ATM(bankA,100);
        ATM atm2A = new ATM(bankA,50);
        ATM atm1B = new ATM(bankB,150);
        ATM atm2B = new ATM(bankB,200);

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Network System"+"\n");
        System.out.println("Enter your choice of ATM");
        String atmChoice = in.nextLine();
        switch (atmChoice) {
                case "atm1A":
                    boolean loop1 = false;
                    String cardNum = null;
                    System.out.println("Enter your card");
                    while(!loop1) {
                        cardNum = in.nextLine();
                        loop1 = atm1A.validateCard(cardNum);
                        if(!loop1){
                        }
                    }
                    System.out.println("The card is accepted. Please enter your password.");
                    boolean loop = true;
                    while(loop){
                        String password = in.nextLine();
                        if(atm1A.authenticateCard(cardNum, password)) {
                            loop = false;
                            System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
                        } else{
                            System.out.println("This is a wrong password. Enter your password again.");
                        }
                    }
                    boolean breakLoop = false;
                    while(!breakLoop && in.hasNextDouble()) {
                        double transactionAmount = in.nextDouble();
                        String transactionResponse = atm1A.withdraw(cardNum, transactionAmount);
                        System.out.println(transactionResponse);
                        if(in.nextLine().equals("quit")){
                            break;
                        }
                    }
                    break;
            case "atm1B":
                boolean loop12 = false;
                String cardNum2 = null;
                System.out.println("Enter your card");
                while(!loop12) {
                    cardNum2 = in.nextLine();
                    loop12 = atm1B.validateCard(cardNum2);
                    if(!loop12){
                    }
                }
                System.out.println("The card is accepted. Please enter your password.");
                boolean loop2 = true;
                while(loop2){
                    String password = in.nextLine();
                    if(atm1B.authenticateCard(cardNum2, password)) {
                        loop2 = false;
                        System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
                    } else{
                        System.out.println("This is a wrong password. Enter your password again.");
                    }
                }
                boolean breakLoop2 = false;
                while(!breakLoop2 && in.hasNextDouble()) {
                    double transactionAmount = in.nextDouble();
                    String transactionResponse = atm1B.withdraw(cardNum2, transactionAmount);
                    System.out.println(transactionResponse);
                    if(in.nextLine().equals("quit")){
                        break;
                    }
                }
                break;
//                case "atm2A":
//                    System.out.println("Enter your card");
//                    String cardNum2A = in.nextLine();
//                    String response2A = atm2A.validateCard(cardNum2A);
//                    System.out.println(response2A);
//                    String password2A = in.nextLine();
//                    atm2A.authenticateCard(cardNum2A, password2A);
//                    double transactionAmount2A = in.nextDouble();
//                    String transactionResponse2A = atm2A.withdraw(cardNum2A, transactionAmount2A);
//                    System.out.println(transactionResponse2A);
//                case "atm2B":
//                    System.out.println("Enter your card");
//                    String cardNum2B = in.nextLine();
//                    String response2B = atm1A.validateCard(cardNum2B);
//                    System.out.println(response2B);
//                    String password2B = in.nextLine();
//                    atm1A.authenticateCard(cardNum2B, password2B);
//                    double transactionAmount2B = in.nextDouble();
//                    String transactionResponse2B = atm1A.withdraw(cardNum2B, transactionAmount2B);
//                    System.out.println(transactionResponse2B);
                default:
                    System.out.println("Invalid ATM choice.Try again");
                    break;
        }
    }
}

