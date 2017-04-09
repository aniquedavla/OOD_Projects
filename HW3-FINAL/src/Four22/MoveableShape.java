package Four22;

import java.awt.*;

/**
   MoveableShape can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape on the graphics context.
      @param g2 the graphics
   */
   void draw(Graphics2D g2);
   /**
      Moves the shape in x and y direction.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
   */
   void translate(int dx, int dy, int frameWidth);
}
