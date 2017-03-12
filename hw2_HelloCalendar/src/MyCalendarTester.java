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
                case "L":;
                case "l":
                case "V":;
                case "v":
                    if(calendarConsole.viewChooser().equals("D")){
                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getCurrentDate());
                        while(true){
                            switch (calendarConsole.getPNMChooser()){
                                case "P":
                                case "N":
                                case "M":break;
                            }
                            break;
                        }
                    }else{
                        System.out.println("Month View Chosen");
                    }
                    break;
                case "C":
                        Event newEvent = calendarConsole.eventSelection();
                        calendarConsole.addEventToMap(newEvent);
                        System.out.println(newEvent.getTitle());
                        break;
                case "G":;
                case "g":
                        String dateTOGo = calendarConsole.eventDateSelection();
                        calendarConsole.getCurrentDateAndEvents(dateTOGo);
                        while(true){
                            switch (calendarConsole.getPNMChooser()){
                                case "P":
                                case "N":
                                case "M":break;
                            }
                            break;
                        }
                case "E":;
                case "e":
                        calendarConsole.printEventList();
                        break;
                case "D":;
                case "d":
                case "Q":
            }
        }
        //shows main menu after every operation.
        while (in.hasNextLine());
    }
}