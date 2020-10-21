// Name: Rong Wang
// USC NetID: rwang424
// CS 455 PA1
// Fall 2020

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar { 

   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   
   private int bottom, left, width, barHeight; // same as the name in the Bar constructor 
   private double scale;
   private Color color;
   private String label;
   
   
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
      this.bottom = bottom;
      this.left = left;
      this.width = width;
      this.barHeight = barHeight;
      this.scale = scale;
      this.color = color;
      this.label = label;
   }
   
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */ 
   public void draw(Graphics2D g2) {
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label, context);
      // The JComponent methods, getWidth() and getHeight(), which get the width and height of the component
      int widthOfLabel = (int) labelBounds.getWidth(); 
      int heightOfLabel = (int) labelBounds.getHeight();
      
      // draw the bar
      int scaledBarHeight = (int)(this.barHeight * this.scale);
      int barTop = this.bottom - heightOfLabel - scaledBarHeight;
      // make a rectangle with the top-left corner, width, height.
      Rectangle bar = new Rectangle(this.left, barTop, this.width, scaledBarHeight); 
      g2.setColor(this.color);
      g2.fill(bar);
      
      // draw the lable
      int basePointX = (int)(this.left + this.width/2 - widthOfLabel/2); // x-coordinate of the basepoint of the first character in the string.
      g2.setColor(Color.BLACK); // The text will always be black
      g2.drawString(this.label, basePointX, this.bottom);
   }
}
