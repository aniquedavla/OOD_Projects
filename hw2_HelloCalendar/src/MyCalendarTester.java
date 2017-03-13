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
     * main method to run console and handle serialization
     * @param args
     * @throws Exception to support the exception at the serializer
     */
     public static void main(String [] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Console calendarConsole = new Console(in);
        int serilizeIndex;
        while(true){
            serilizeIndex = calendarConsole.mainMenu(calendarConsole,in);
            try {
                calendarConsole = serializer(calendarConsole,serilizeIndex);
            }
            catch (FileNotFoundException e){
                System.out.println("First run, events.txt not found.");
            }
            if(serilizeIndex ==6){
                try {
                    serializer(calendarConsole,serilizeIndex);
                } catch (NotSerializableException e){
                    System.out.println("Serialization FAILED!!!");
                }
                System.out.print("Calendar Exited!");
                break;
            }
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
        try {
            FileOutputStream file = new FileOutputStream("events.txt");
            ObjectOutput output = new ObjectOutputStream(file);
            output.writeObject(consoleCal);
            output.close();
        } catch (NotSerializableException e){
            System.out.println("Serialization Failed");
        }
        }else if(index == 1){
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

}