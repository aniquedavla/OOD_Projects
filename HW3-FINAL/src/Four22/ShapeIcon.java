package Four22;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * An icon that contains a moveable shape.
 */
public class ShapeIcon implements Icon {

    /**
     * constructs the Car Icon
     *
     * @param shape the moveable car
     * @param width the width of car
     * @param height the height of car
     */
    public ShapeIcon(MoveableShape shape, int width, int height) {
        this.shape = shape;
        this.width = width;
        this.height = height;
    }

    /**
     * returns the width of car
     *
     * @return width of car
     */
    public int getIconWidth() {
        return width;
    }

    /**
     * returns the height of car
     *
     * @return height of car
     */
    public int getIconHeight() {
        return height;
    }

    /**
     * paint Component to draw the shape using delegation
     *
     * @param c the component
     * @param g the graphics object
     * @param x the x-coordinate of car
     * @param y the y-coordinate of car
     */
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        shape.draw(g2);
    }
//instance variables
    private int width;
    private int height;
    private MoveableShape shape;
}
