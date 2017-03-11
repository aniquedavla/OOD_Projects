import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by aniquedavla on 3/11/17.
 */
public class Console {
    private Scanner input;
    private PrintWriter output;

    public Console(Scanner input, PrintWriter output){
        this.input = input;
        this.output = output;
    }
    
    String optionSelection(String options){
        while(true){
            output.println(options + ":");
            String selection = input.nextLine().toUpperCase();
            if (options.contains("[" + input + "]"))
                return selection;

        }
    }
}
