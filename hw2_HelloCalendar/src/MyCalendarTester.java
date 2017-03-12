import java.util.Calendar;
import java.util.GregorianCalendar;
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
                        int[] currentDateA = calendarConsole.getCurrentDateA();
                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(currentDateA));
                        while(true){
                            switch (calendarConsole.getPNMChooser()){
                                case "P":;
                                case "p":
                                    if(currentDateA[0]!=1) {
                                        int[] newDate = {currentDateA[0] - 1, currentDateA[1], currentDateA[2]};
                                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(newDate));
                                    }else{
                                        //int[] newDate = {getDaysNumberofMonth(currentDateA[1]),}
                                    }
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
                    String deleteOp = calendarConsole.deleteOption();
                    if(deleteOp.equals("S")){
                        calendarConsole.deleteSelectedEvent(calendarConsole.eventDateSelection());

                    }else if(deleteOp.equals("A")){
                        calendarConsole.deleteAllEvents();
                    }
                case "Q":;
                case"q":
            }
        }
        //shows main menu after every operation.
        while (in.hasNextLine());
    }
    public static int getDaysNumberofMonth(int i){
        Calendar mycal = new GregorianCalendar(2017, i, 1);
        return mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}