/**
 * Created by aniquedavla on 3/11/17.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarExample
{
    private MONTHS[] arrayOfMonths;
    private DAYS[] arrayOfDays;
    private GregorianCalendar cal;
    public CalendarExample(){
        cal = new GregorianCalendar(); // capture today
         arrayOfMonths = MONTHS.values();
         arrayOfDays = DAYS.values();
    }
    public CalendarExample(int year, int month, int day){

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

}