package Four22;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * AnimationTester implements an animation that moves a car shape.
 * @author aniquedavla
 */
public class AnimationTester {

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final MoveableShape shape1 = new CarShape(0, 0, CAR_WIDTH);

        ShapeIcon icon1 = new ShapeIcon(shape1, ICON_WIDTH, ICON_HEIGHT);

        final JLabel label1 = new JLabel(icon1);

        final MoveableShape shape2 = new CarShape(0, 0, CAR_WIDTH);

        ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);

        final JLabel label2 = new JLabel(icon2);

        final MoveableShape shape3 = new CarShape(0, 0, CAR_WIDTH);

        ShapeIcon icon3 = new ShapeIcon(shape3, ICON_WIDTH, ICON_HEIGHT);

        final JLabel label3 = new JLabel(icon3);

        frame.add(label1, BorderLayout.NORTH);
        frame.add(label2, BorderLayout.CENTER);
        frame.add(label3, BorderLayout.SOUTH);

        final int DELAY1 = 300;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY1, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                shape1.translate(1, 0);
                label1.repaint();
            }
        });
        t.start();
        final int DELAY2 = 50;
        Timer t2 = new Timer(DELAY2, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                shape2.translate(1, 0);
                label2.repaint();
            }
        });
        t2.start();
        final int DELAY3 = 30;
        Timer t3 = new Timer(DELAY3, new ActionListener() {
            int x = 1;
            public void actionPerformed(ActionEvent event) {
                //if(frame.getWidth()){
                   // x = 0-label3.getWidth();
                //}
                shape3.translate(x, 0);
                label3.repaint();

            }});

        t3.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
