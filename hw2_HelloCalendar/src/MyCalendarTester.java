import java.util.Scanner;

/**
 * Created by aniquedavla on 3/11/17.
 */
public class MyCalendarTester {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Console calendarConsole = new Console(in);
        String mainI ="";
        do {
            calendarConsole.printMainCalender();
            mainI = calendarConsole.mainMenu();
            switch (mainI) {
                case "L":
                case "V":
                    if(calendarConsole.viewChooser().equals("D")){
                        calendarConsole.getCurrentDateAndEvents();
                    }else{
                        System.out.println("Month View Chosen");
                    }
                case "C":
                case "G":
                case "E":
                case "D":
                case "Q":
            }
        }
        //shows main menu after every operation.
        while (in.hasNextLine());
    }
}