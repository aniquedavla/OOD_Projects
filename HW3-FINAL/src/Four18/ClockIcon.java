package Four18;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.Clock;
import java.util.*;

/**
 * Created by aniquedavla on 4/8/17.
 * ClockIcon is an Icon that is a Clock that represents current time.
 */
public class ClockIcon implements Icon {
    private int width;
    private int height;
    private int radius;
    private Point2D.Double centerPoint;

    /**
     * Initalize clock with the right width and height
     * @param width the width of the clock
     * @param height the height of the clock
     */
    public ClockIcon(int width, int height){
        this.width = width;
        this.height = height;
        this.radius = width / 2;

    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        GregorianCalendar currentDate = new GregorianCalendar();
        this.centerPoint = new Point2D.Double((x + width) / 2, (y + width) / 2);

        //draw clock body
        Ellipse2D.Double clockCircle = new Ellipse2D.Double(x,y,width,height);

        //Length propotions for heading.
        final double HOUR = 0.45;
        final double MINUTE = 0.65;
        final double SECOND = 0.75;
        final double TEXT = 0.9;

        int hour = currentDate.get(Calendar.HOUR);
        int minute = currentDate.get(Calendar.MINUTE);
        int second = currentDate.get(Calendar.SECOND);

        hour = hour % 12; // Change 12 to 0
        hour = hour * 5;  // Change to ticks on clock

        // Add in the fraction of the hour, as ticks
        hour = hour + (int) (5 * minute / 60.0);


        Line2D.Double hourHead = new Line2D.Double(centerPoint, endPoint(HOUR, hour));
        Line2D.Double minuteHead = new Line2D.Double(centerPoint, endPoint(MINUTE, minute));
        Line2D.Double secondHead = new Line2D.Double(centerPoint, endPoint(SECOND, second));

        // hour text numerics
        Point2D.Double noonText = endPoint(TEXT, 0);
        Point2D.Double threeText = endPoint(TEXT, 15);
        Point2D.Double sixText = endPoint(TEXT, 30);
        Point2D.Double nineText = endPoint(TEXT, 45);


        g2D.setColor(Color.BLUE);
        g2D.fill(clockCircle);

        g2D.setColor(Color.YELLOW);
        g2D.drawString("12", (float) noonText.x - 3, (float) noonText.y + 5);
        g2D.drawString("3", (float) threeText.x - 1, (float) threeText.y);
        g2D.drawString("6", (float) sixText.x, (float) sixText.y + 2);
        g2D.drawString("9", (float) nineText.x - 1, (float) nineText.y);

        g2D.setColor(Color.RED);
        g2D.draw(hourHead);
        g2D.setColor(Color.BLACK);
        g2D.draw(minuteHead);
        g2D.setColor(Color.GREEN);
        g2D.draw(secondHead);

    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    private Point2D.Double endPoint(double prop, int tick) {
        double lengthOfArrow = prop * radius;
        double radians = Math.PI * 6 * tick / 180;
        double xEndPoint = centerPoint.x + lengthOfArrow * Math.sin(radians);
        double yEndPoint = centerPoint.y - lengthOfArrow * Math.cos(radians);

        return new Point2D.Double(xEndPoint, yEndPoint);
    }

}
