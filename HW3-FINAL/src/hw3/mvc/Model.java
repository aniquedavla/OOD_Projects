
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Model class consists of data and corresponding listeners
 */
public class Model {

    private ArrayList<String> data;
    private ArrayList<ChangeListener> listeners;

    /**
     * Constructor to initialize stringData and listeners
     */
    public Model() {
        data = new ArrayList<String>();
        listeners = new ArrayList<ChangeListener>();
    }

    /**
     * Adds a change listener to the string data
     *
     * @param listener the change listener to add
     */
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * to format string in the view area
     *
     * @return returns the formatted string
     */
    public String format() {
        String string = "";
        String newLine = "\n";
        for (String s : data) {
            string += s + newLine;
        }
        return string;
    }

    /**
     * Adds item to the string data
     *
     * @param string the string to add
     */
    public void addString(String string) {
        data.add(string);
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(event);
        }
    }

}
