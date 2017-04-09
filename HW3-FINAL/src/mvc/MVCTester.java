package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * MVCTester tests the Model/View/Controller architecture
 *
 * Created by aniquedavla on 4/8/17.
 */
public class MVCTester {

    public static void main(String[] args) {

        final Model stringLines = new Model();

        /**
         * View
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
         * Controller that takes in user input.
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
