import java.awt.*;
import java.awt.Graphics;

/**
 * Implements the functionality needed to draw
 * filled circles with a given color.
 * @author Chelsea Hanson
 *
 */
public class Circle extends Figure{
    public int x;
    public int y;
    public int radius;

    public Circle(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Draws filled circles with a given color and placement.
     *
     * @param graphics the Graphics object for drawing the figure.
     */
    public void draw(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillOval(x, y, radius, radius);
    }

    /**
     * Overrides the toString method to print nicely on the screen.
     * @return String representation of shape.
     */
    public String toString(){
        return ("Circle [x=" + x + ", y=" + y + ", radius=" + radius
                                     + ", color=" + color.toString() + "]\n");
    }
}