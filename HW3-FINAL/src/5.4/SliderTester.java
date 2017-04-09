/**
 * Program with a slider that adjusts size of car
 * @author aniquedavla
 */
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTester {
/**
 * Method that starts the program
 * @param args not used
 */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Slider");
        //car size slider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 300, 50);
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(50);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        Car car = new Car(0, 0, 100);
        ShapeIcon icon = new ShapeIcon(car, 300, 300);
        JLabel label = new JLabel(icon);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int size = slider.getValue();
                car.setWidth(size);
                label.repaint();
            }
        });

        frame.add(slider, BorderLayout.SOUTH);
        frame.add(label, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}
