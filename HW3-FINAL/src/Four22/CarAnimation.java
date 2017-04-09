package Four22;

/**
 * Created by aniquedavla on 4/8/17.
 */
        import java.awt.Container;
        import java.awt.Graphics;
        import java.awt.Image;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.io.File;
        import java.io.IOException;

        import javax.imageio.ImageIO;
        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.Timer;

public class CarAnimation extends JFrame
{
    //inner Class
    public class MyJPanel extends JPanel
    {
        public int x    = 10;   //Start Drawing from X=10
        //change the delay for change the car speed
        public int delay    = 10;    //milliseconds
        MyJPanel()
        {
            Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint();
                x++;
            }});
            timer.start();
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            Image img=null;
            try {
                img =ImageIO.read(new File("car.jpg"));
                g.drawImage(img, x, 200, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(x==getWidth())
            {
                x=0 - img.getWidth(null);
            }

        }

    }

    public static void main(String args [])
    {
        new CarAnimation ();
    }

    CarAnimation ()
    {
        Container container = getContentPane();
        MyJPanel panel = new MyJPanel();
        container.add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,400); // here change size according to your requirements
        setTitle("Car Animation");
        setVisible(true);
        setResizable(true);
    }
}
