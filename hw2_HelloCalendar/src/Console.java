import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by aniquedavla on 3/11/17.
 */
public class Console {
    private Scanner input;
    private CalendarExample sampleCal;

    public Console(Scanner input){
        this.sampleCal = new CalendarExample();
        this.input = input;
    }
    public String mainMenu(){
        System.out.println("");
        System.out.println("Select one of the following options:");
        return optionSelection("[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
    }
    String optionSelection(String options){
        //? can remove, handle corner cases.
        while(true){
            System.out.println(options + ":");
            String selection = input.nextLine().toUpperCase();
            if (options.contains("[" + selection + "]"))
                return selection;

        }
    }

    public String viewChooser() {
        return optionSelection("[D]ay view or [M]view ?");
    }

    public void getCurrentDateAndEvents() {
        sampleCal.printDayView();
    }
    public void printMainCalender(){
        sampleCal.printCalendar();
    }
}
