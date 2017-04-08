package Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

/**
 * A class for testing a clock icon by updating it each second
 * @author MD ISLAM
 */
public class ClockIconTester {

    /**
     * Creates a clock and a timer to update the clock every second.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        ClockIcon icon = new ClockIcon(100);
        final JLabel label = new JLabel(icon);

        final int FIELD_WIDTH = 20;
        final JTextField textField = new JTextField(FIELD_WIDTH);

        frame.setLayout(new FlowLayout());

        frame.add(label);
        frame.add(textField);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                label.repaint();
                Date now = new Date();
                textField.setText(now.toString());
            }
        };

        final int DELAY = 1000;
        // milliseconds between timer ticks
        Timer t = new Timer(DELAY, listener);
        t.start();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
