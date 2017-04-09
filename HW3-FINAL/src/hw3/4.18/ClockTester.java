import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by aniquedavla on 4/8/17.
 */
public class ClockTester{
    public static void main(String[]args){
        JFrame frame = new JFrame();
        JPanel clockPanel = new JPanel(new FlowLayout());
        JPanel clockTextPanel = new JPanel(new FlowLayout());
        frame.setLayout(new FlowLayout());

        ClockIcon clock = new ClockIcon(250,250);
        JLabel clockInLabel = new JLabel(clock);

        final int FIELD_WIDTH = 25;
        JTextField dateText = new JTextField(FIELD_WIDTH);
        Date currentDate = new Date();
        dateText.setText(currentDate.toString());

        frame.add(clockPanel);
        clockPanel.add(clockInLabel);
        frame.add(clockTextPanel);
        clockTextPanel.add(dateText);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
