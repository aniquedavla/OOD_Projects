import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by aniquedavla on 3/11/17.
 */
public class MyCalendarTester {
    /**
     * main method which is a loop over the main menu
     * @param args
     * @throws Exception to support the exception at the serializer
     */
    public static void main(String [] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Console calendarConsole = new Console(in);
        int i = mainMenu(calendarConsole,in);
        System.out.print("Calendar Exited!");
//        while(true) {
//            i = calendarConsole.action();
//            calMethods = serializer(calMethods, i);
//        }
    }
    public static int getDaysNumberForMonth(int i){
        Calendar mycal = new GregorianCalendar(2017, i, 1);
        return mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int mainMenu(Console calendarConsole, Scanner in) {
        String mainI = "";
        int index = 0;
        while(true){
            calendarConsole.printMainCalender();
            mainI = calendarConsole.mainMenu();
            switch (mainI) {
                case "L":;
                case "l": index = 1;break;
                case "V":;
                case "v":
                        view(calendarConsole, calendarConsole.getArrayDateToString(calendarConsole.getCurrentDateA()));
                        continue;
                case "C":
                    Event newEvent = calendarConsole.eventSelection();
                    calendarConsole.addEventToMap(newEvent);
                    System.out.println(newEvent.getTitle());
                    continue;
                case "G":;
                case "g":
                    String dateTOGo = calendarConsole.eventDateSelection();
                    boolean found = calendarConsole.getCurrentDateAndEvents(dateTOGo);
                    while(found){
                        view(calendarConsole,dateTOGo);
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
                    index = 6;
                    break;
            }
            break;
        }
        //shows main menu after every operation.
        return index;
    }

public static void view(Console calendarConsole, String dayView){
    String viewI = calendarConsole.viewChooser();
    if(viewI.equals("D")){
        dayView(calendarConsole,dayView);
    }
    else if (viewI.equals("M")) {
            //you dnt need current day for Month view
            int[] currentDateA = calendarConsole.sampleCal.currentDayArray();
            calendarConsole.printMainCalender();
            GregorianCalendar newCal = new GregorianCalendar(2017, currentDateA[1], 1);
            calendarConsole.sampleCal.eventListMonth(newCal);

            int temMonth = currentDateA[1];
            while (temMonth >=1 && temMonth<=12 ) {
                switch (calendarConsole.getPNMChooser()) {
                    case "P":;
                    case "p":
                        newCal = new GregorianCalendar(2017, (temMonth - 1), 1);
                        //+1 to be converted to string
                        calendarConsole.sampleCal.printCalendar(newCal, (temMonth - 1));
                        temMonth -= 1;
                        calendarConsole.sampleCal.eventListMonth(newCal);
                        continue;
                    case ("N"):;
                    case "n":
                        newCal = new GregorianCalendar(2017, temMonth + 1, 1);
                        calendarConsole.sampleCal.printCalendar(newCal, (temMonth + 1));
                        temMonth +=1;
                        calendarConsole.sampleCal.eventListMonth(newCal);
                        continue;
                    case "M":
                        return;
                }
            }
        return;
    }
}
    public static void dayView(Console calendarConsole,String date){
        int[] currentDateA = calendarConsole.sampleCal.stringToArrayDate(date);
        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(currentDateA));
        int temDay = currentDateA[0];
        while(1 <= temDay && temDay <= 31){
            switch (calendarConsole.getPNMChooser()){
                case "P":;
                case "p":
                    if(temDay==1) {
                        int[] newDate = {getDaysNumberForMonth(temDay - 1),currentDateA[1] - 1,currentDateA[2]};
                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(newDate));
                        temDay -= 1;
                    }
                    else{
                        int[] newDate = {temDay -1, currentDateA[1], currentDateA[2]};
                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(newDate));
                        temDay -= 1;
                    }
                    continue;
                case "N":;
                case "n":
                    if(temDay==getDaysNumberForMonth(currentDateA[1])) {
                        int[] newDate = {1,currentDateA[1]+1,currentDateA[2]};
                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(newDate));
                        temDay = 1;
                    }
                    else{
                        int[] newDate = {temDay+1, currentDateA[1], currentDateA[2]};
                        calendarConsole.getCurrentDateAndEvents(calendarConsole.getArrayDateToString(newDate));
                        temDay +=1;
                    }
                    continue;
                case "M":return;
            }
            return;
        }
    }
    /**
     *
     * @param consoleCal a CalendarExample to create the events.txt object serializer
     * @param  index represent [Q]uit or [L]oad fn.
     * @return calendar deserialization object that from events.txt
     * @throws IOException
     */
    public static Console serializer(Console consoleCal, int index ) throws IOException {
        if(index==6){
            FileOutputStream file = new FileOutputStream("events.txt");
            ObjectOutput output = new ObjectOutputStream(file);
            output.writeObject(consoleCal);
            output.close();

        }else if(index ==1){
            FileInputStream file = new FileInputStream("events.txt");
            ObjectInput out = new ObjectInputStream(file);
            try{
                Console sampleC = (Console) out.readObject();
                consoleCal = sampleC;
            }catch(ClassNotFoundException e){
                System.out.println("No such file exists as it is the first run.");
                System.err.println(e);
            }
            out.close();
        }
        return consoleCal;
    }

//    public int action() throws IOException {
//        int i = mainMenu();
//        return i;
//    }


}