package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Program to test the Model/View/Controller architecture
 *
 * @author MD ISLAM
 */
public class MVCTester {

    public static void main(String[] args) {

        final Model stringLines = new Model();

        /**
         * This is the view part.
         * Here is where the view takes place.
         */
        JFrame frame = new JFrame();
        final JTextField userInput = new JTextField();
        final JTextArea displayArea = new JTextArea(25, 25);

        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                displayArea.setText(stringLines.format());
            }
        };
        stringLines.addChangeListener(listener);

        /**
         * This is the controller part. This part takes user input.
         */
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String text = userInput.getText();
                stringLines.addString(text);
            }
        });

        frame.add(addButton, BorderLayout.NORTH);
        frame.add(displayArea, BorderLayout.CENTER);
        frame.add(userInput, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
