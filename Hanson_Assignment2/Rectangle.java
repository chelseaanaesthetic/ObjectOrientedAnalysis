import java.awt.Color;
import java.awt.Graphics;

/**
 * Implements the functionality needed to draw
 * filled rectangles with a given color.
 * @author Chelsea Hanson
 *
 */
public class Rectangle extends Figure{
    public int x;
    public int y;
    public int width;
    public int height;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Draws filled rectangles with a given color and placement.
     *
     * @param graphics the Graphics object for drawing the figure.
     */
    public void draw(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillRect(x, y, width, height);
    }

    /**
     * Overrides the toString method to print nicely on the screen.
     * @return String representation of shape.
     */
    public String toString(){
        return ("Rectangle [x=" + x + ", y=" + y + ", width=" + width
                + ", height=" + height + ", color=" + color.toString() + "]\n");
    }
}