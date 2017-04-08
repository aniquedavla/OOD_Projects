import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * An icon that is a clock
 */
public class ClockIcon implements Icon {

    /**
     * Constructs a clock of a given width.
     *
     *      */
    public ClockIcon(int aWidth) {
        width = aWidth;
    }

    public int getIconWidth() {
        return width;
    }

    public int getIconHeight() {
        return width;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        center = new Point2D.Double(x + width / 2, y + width / 2);
        radius = width / 2;

        // Proportion of radius for length of hands
        final double TEXT = 0.9;
        final double SECOND = 0.75;
        final double MINUTE = 0.65;
        final double HOUR = 0.55;

        Ellipse2D.Double face = new Ellipse2D.Double(x, y, width, width);
        g2.setColor(Color.YELLOW);
        g2.fill(face);

        // Hour numeral locations
        Point2D.Double noon = endPoint(TEXT, 0);
        Point2D.Double three = endPoint(TEXT, 15);
        Point2D.Double six = endPoint(TEXT, 30);
        Point2D.Double nine = endPoint(TEXT, 45);

        g2.setColor(Color.black);
        g2.drawString("12", (float) noon.x - 3, (float) noon.y + 5);
        g2.drawString("3", (float) three.x - 1, (float) three.y);
        g2.drawString("6", (float) six.x, (float) six.y + 2);
        g2.drawString("9", (float) nine.x - 1, (float) nine.y);

        GregorianCalendar now = new GregorianCalendar();

        int minutes = now.get(Calendar.MINUTE);
        int seconds = now.get(Calendar.SECOND);

        int hours = now.get(Calendar.HOUR);
        hours = hours % 12; // Change 12 to 0
        hours = hours * 5;  // Change to ticks on clock

        // Add in the fraction of the hour, as ticks
        hours = hours + (int) (5 * minutes / 60.0);

        Line2D.Double hourLine
                = new Line2D.Double(center, endPoint(HOUR, hours));

        Line2D.Double minuteLine
                = new Line2D.Double(center, endPoint(MINUTE, minutes));

        Line2D.Double secondLine
                = new Line2D.Double(center, endPoint(SECOND, seconds));

        g2.draw(hourLine);
        g2.draw(minuteLine);

        g2.setColor(Color.BLUE);
        g2.draw(secondLine);

    }

    private Point2D.Double endPoint(double proportion, int ticks) {
        double length = proportion * radius;
        double radians = Math.PI * 6 * ticks / 180;
        double xEnd = center.x + length * Math.sin(radians);
        double yEnd = center.y - length * Math.cos(radians);

        return new Point2D.Double(xEnd, yEnd);
    }

    private int width;
    private int radius;
    // The center of the clock
    private Point2D.Double center;
}
