/**
 * Created by aniquedavla on 3/11/17.
 */
import java.util.*;

enum DAYS
{
    Sun, Mon, Tue, Wed, Thur, Fri, Sat ;
}
enum MONTHS
{
    Jan, Feb, March, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec;
}


public class CalendarExample
{
    private MONTHS[] arrayOfMonths;
    private DAYS[] arrayOfDays;
    private GregorianCalendar cal;
    private HashMap<String, ArrayList<Event>> eventsOnDay = new HashMap<>();

    public CalendarExample(){
        cal = new GregorianCalendar(); // capture today
         arrayOfMonths = MONTHS.values();
         arrayOfDays = DAYS.values();
    }

    public void printDayView(){
        int currentM = cal.get(Calendar.MONTH);
        int currentY = cal.get(Calendar.YEAR);
        int currentD = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(
            arrayOfDays[cal.get(Calendar.DAY_OF_WEEK)-1]+", "
                + arrayOfMonths[currentM] + " "
                + cal.get(Calendar.DAY_OF_MONTH)+", "
                + currentY
        );
    }

    public void printCalendar()
    {
        GregorianCalendar temp = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        int currentM = cal.get(Calendar.MONTH);
        int currentY = cal.get(Calendar.YEAR);
        int currentD = cal.get(Calendar.DAY_OF_MONTH);

        // prints the calendar header
        System.out.println("   " + arrayOfMonths[cal.get(Calendar.MONTH)] + " " + cal.get(Calendar.YEAR));
        System.out.println("Su Mo Tu We Th Fr Sa");

        // days[i] = number of days in month i
        int[] days = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        if(currentM == 2 && temp.isLeapYear(currentY)){
            days[currentM] = 29;
        }

        // starting day of the month
        int startDay = startDayOfM(cal.get(Calendar.MONTH),1,cal.get(Calendar.YEAR));


        // print the calendar
        for (int i = 0; i < startDay; i++)
            System.out.print("   ");
        for (int i = 1 ; i <= days[cal.get(Calendar.MONTH)]; i++) {
            if(i == currentD){
                System.out.print("[" + i + "]");
            } else {
                System.out.printf("%2d ", i);
            }
            if (((i + startDay) % 7 == 0) || (i == days[cal.get(Calendar.MONTH)])) System.out.println();
        }

    }

    public static int startDayOfM(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    public void load(){

    }

    public void addEventToMap(Event newEvent) {
        ArrayList<Event> tempList;
        String dateString = newEvent.getDate();
        tempList = eventsOnDay.get(dateString);
        if (tempList == null) {
            tempList = new ArrayList<Event>();
            tempList.add(newEvent);
            eventsOnDay.put(dateString, tempList); //adds newly created list to the Map.
        } else {
            //ArrayList for the date exists, add to it
            eventsOnDay.get(dateString).add(newEvent);
        }
    }
    public void printEventsFromMap(String dateKey){
//        if(hm.get(dateKey)==null){
//            System.out.println("no event this day "+dateKey);
//        }else {
//            for (int i = 0; i < hm.get(dateKey).size(); i++) {
//                MONTHS[] arrayOfMonths = MONTHS.values();
//                DAYS[] arrayOfDays = DAYS.values();
//                //to get the day name
//                Calendar mycal = new GregorianCalendar(2017, hm.get(dateKey).get(i).getMm(),
//                        hm.get(dateKey).get(i).getDd());
//                System.out.println(arrayOfDays[mycal.get(Calendar.DAY_OF_WEEK)] +", " +
//                        arrayOfMonths[mycal.get(Calendar.MONTH)]+" "+
//                        hm.get(dateKey).get(i).getDd()+", "+
//                        hm.get(dateKey).get(i).getYyyy());
//                System.out.print(    hm.get(dateKey).get(i).getTitle()+" "+
//                        hm.get(dateKey).get(i).getStartingTimeHR() + ":" +
//                        hm.get(dateKey).get(i).getStartingTimeMN() + " - " +
//                        hm.get(dateKey).get(i).getEndingTimeHR() + ":" +
//                        hm.get(dateKey).get(i).getEndingTimeMN() + " " + "\n");
//            }
//        }
    }
}