import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by aniquedavla on 3/11/17.
 */
public class Console {
    private Scanner input;
    CalendarExample sampleCal;

    public Console(Scanner input) {
        sampleCal = new CalendarExample(new GregorianCalendar());
        this.input = input;
    }

    /**
     * @return
     */
    public String mainMenu() {
        System.out.println("");
        System.out.println("Select one of the following options:");
        return optionSelection("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
    }

    String optionSelection(String options) {
        String s = "";
        //? can remove, handle corner cases.
        System.out.println(options + "\n");
        while (true) {
            String selection = input.nextLine().toUpperCase();
            if (options.contains("[" + selection + "]"))
                return selection;
        }
    }

    /**
     * @return
     */
    public String viewChooser() {
        return optionSelection("[D]ay view or [M]view ?");
    }

    /**
     * @return
     */
    public int[] getCurrentDateA() {
        return sampleCal.currentDayArray();
    }

    public String getArrayDateToString(int[] date) {
        return sampleCal.getArrayDateToString(date);
    }


    /**
     * @param date
     */
    public boolean getCurrentDateAndEvents(String date) {
//        String pattern = "DD/MM/YYYY";
//        String dateInString  = new SimpleDateFormat(pattern).format(new Date());

        return sampleCal.printEventsFromMap(date);

    }

    /**
     *
     */
    public void printMainCalender() {
        sampleCal.printCalendar();
    }

//    /**
//     * @return
//     */
//    public String createEventDialog() {
//        System.out.println("[C]reate");
//        return optionSelection("[C]reate");
//    }

    public String getPNMChooser() {
        return optionSelection("[P]revious or [N]ext or [M]ain menu ?");
    }

    String eventTileSelection() {
        return input.nextLine();
    }

    String eventDateSelection() {
        System.out.println("Enter a date of this event in this format DD/MM/YYYY [separated by / ]");
        if (input.hasNext())
            return input.nextLine();
        else return null;
    }

    Event eventSelection() {
        boolean canCreateEvent = false;
        System.out.println("Enter a title for the event:");
        String eventTitle = eventTileSelection();
        String date = eventDateSelection();
        String[] dateArray = date.split("/");
        String day = dateArray[0];
        String month = dateArray[1];
        String year = dateArray[2];
        int startTimeHR = 0;
        int startTimeMN = 0;
        boolean endTimeFlag = false;
        int endTimeHR = 0;
        int endTimeMN = 0;

        System.out.println("Enter a starting time \"HH MM\" for the event[HH and MM separated by spaces]");
        while (input.hasNext()) {
            if (input.hasNextInt())
                startTimeHR = input.nextInt();
            if (input.hasNextInt())
                startTimeMN = input.nextInt();
            break;
        }
        System.out.println("Does this event has an end time ? enter [Y]es or [N]o");
        while (input.hasNext()) {
            String in = input.nextLine().toUpperCase();
            if (in.equals("Y")) {
                endTimeFlag = true;
                break;
            } else if (in.equals("N")) {
                endTimeFlag = false;
                canCreateEvent = true;
                break;
            }
        }
        if (endTimeFlag) {
            System.out.println("Enter an ending time \"HH MM\" [HH and MM separated by spaces");
            endTimeHR = 0;
            while (endTimeHR <= startTimeHR) {
                if (input.hasNext()) {
                    if (input.hasNextInt())
                        endTimeHR = input.nextInt();
                    if (input.hasNextInt())
                        endTimeMN = input.nextInt();
                    if (endTimeHR < startTimeHR) {
                        System.out.println("Invalid end time. Enter a end time \"HH MM\" [separated by spaces]");
                         canCreateEvent = false;
                    }
                }
                break;
            }
        }
        if(canCreateEvent){
           return new Event(eventTitle, date, startTimeHR, startTimeMN, endTimeFlag, endTimeHR, endTimeMN);
        } else return null;
    }

    public void addEventToMap(Event newEvent) {
        sampleCal.addEventToMap(newEvent);
    }

    public void printEventList() {
        sampleCal.printEventList();
    }

    public String deleteOption() {
        return optionSelection("[S]elected or [A]ll ?");
    }

    public void deleteSelectedEvent(String s) {
        sampleCal.deletEventByKey(s);
    }

    public void deleteAllEvents() {
        sampleCal.deletAll();
    }

}
