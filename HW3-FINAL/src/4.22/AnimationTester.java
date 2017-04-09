import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * AnimationTester implements an animation that moves a car shape.
 * Created by aniquedavla on 4/8/17.
 */
public class AnimationTester {

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;

    /**
     * main tester for reapearing Animation.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final MoveableShape carShape = new CarShape(0, 0, CAR_WIDTH);

        ShapeIcon carIcon = new ShapeIcon(carShape, ICON_WIDTH, ICON_HEIGHT);

        final JLabel label = new JLabel(carIcon);

        frame.add(label, BorderLayout.NORTH);

        final int DELAY = 10;
        Timer timer = new Timer(DELAY, new ActionListener() {
            int frameChecker = 1;
            int x = 1;
            public void actionPerformed(ActionEvent event) {
               carShape.translate(3, 0, frame.getWidth());
                label.repaint();
            }});

        timer.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
