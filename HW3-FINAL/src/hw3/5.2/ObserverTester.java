
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ObserverTester {

    public static void main(String[] args) {
        ArrayList<Double> data = new ArrayList<Double>();
        data.add(new Double(33.0));
        data.add(new Double(44.0));
        data.add(new Double(22.0));
        data.add(new Double(22.0));
        DataModel model = new DataModel(data);
        TextFrame frame = new TextFrame(model);
        BarFrame barFrame = new BarFrame(model);
        model.attach(barFrame);
        model.attach(frame);
        MouseListener graphMouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

            }

            public void mousePressed(MouseEvent event) {
                model.update(getLocation(event), event.getX());
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }

            public int getLocation(MouseEvent event) {
                int number = event.getY();
                int location = (int) Math.floor(number / 50);
                return location;
            }
        };
        barFrame.addMouseListener(graphMouseListener);
    }
}
