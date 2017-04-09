package Four22;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * A car that can be moved around.
 */
public class CarShape implements MoveableShape {
    private int x;
    private int y;
    private int width;

    /**
     * Initializes a CarShape.
     *
     * @param x the left point of the rectangle
     * @param y the top point of the rectangle
     * @param width the width of the rectangle
     */
    public CarShape(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    /**
     * Moves car by incrementing x and y coordinates
     *
     * @param dx move car in the x direction
     * @param dy move car in the y direction
     * @param frameWidth the width of the frame.
     */
    public void translate(int dx, int dy, int frameWidth) {
        //make the animation reapper once it goes out of the frame.
        if(x > frameWidth)
        {
            x = x - (frameWidth);
        } else{
            x += dx;
            y += dy;
        }
    }

    /**
     * Draws the car on the graphics context
     *
     * @param g2 the graphics
     */
    public void draw(Graphics2D g2) {

        Rectangle2D.Double carBody = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3, width / 6, width / 6);

        // The windshield
        Point2D.Double w1 = new Point2D.Double(x + width / 6, y + width / 6);
        // The roof
        Point2D.Double w2 = new Point2D.Double(x + width / 3, y);
        Point2D.Double w3 = new Point2D.Double(x + width * 2 / 3, y);
        //rear windshield
        Point2D.Double w4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield = new Line2D.Double(w1, w2);
        Line2D.Double roofTop = new Line2D.Double(w2, w3);
        Line2D.Double rearWindshield = new Line2D.Double(w3, w4);

        g2.draw(carBody);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }
}
