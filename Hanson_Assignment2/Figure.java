import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
	
/**
 * Serves as a type for all figures in the simple
 * drawing program. Some implementation might be added 
 * at a future date.
 * @author Chelsea Hanson
 *
 */
public abstract class Figure implements Serializable{
	protected Color color;
	/**
	 * Draws the figure using the given Graphics parameter
	 * @param graphics the Graphics object for drawing the figure
	 */
	public void draw(Graphics graphics){
		graphics.setColor(color);
	}
}
