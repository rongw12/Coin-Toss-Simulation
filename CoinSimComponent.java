import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
// import java.lang.Math; // to use max in the Math

   /**
    *CoinSimComponent Class
    *It would draw three bars in the frame with their corresponding lables.
    *
    *Extends JComponent. Constructor initializes any necessary data and runs the simulation. 
    *Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 
    *This class uses the CoinTossSimulator and Bar class.
    */

public class CoinSimComponent extends JComponent
{  

/**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param frameWidth     the width of the frame
      @param frameHeight    the height of the frame
      @param BARWIDTH       the width of each bar
      @param segment        the distance between the center of two bars
      @param verticalBuffer height of the bar in application units. The vertical buffer vb in the image, the distance from the top of frame to the top of bar, also the distance from the bottom of the label to the bottom of the frame.
      
      @param numTrials      the number of trials
      @param numTwoHeads    the number of two heads
      @param numHeadTails   the number of one head and one tail
      @param numTwoTails    the number of two tails
      @param test           a CoinTossSimulator 
      @param percentTwoHeads   the percentage of two heads
      @param percentHeadTails  the percentage of one head and one tail
      @param percentTwoTails   the percentage of two tails
      @param scale  how many pixels per application unit
      @param label1         the lable for the most left bar
      @param label2         the lable for the middle bar
      @param label3         the lable for the most right bar
      @param left           the x-coordinate of the upper left point of the bar
      @param bottom         the bottom y-coordinate of the label   
   */
   
   /* public static final int FRAMEWIDTH = 800; // frame size
   public static final int FRAMEHEIGHT = 600;
   public static final int SEGMENT = (int)(FRAMEWIDTH/4); // x in the picture, the distance from the left of the frame to the center of the first bar. 
   */
   
   private static final int BARWIDTH = 50; // bw in the picture 
   private static final int VERTICALBUFFER = 30; // vb in the picture, the vertical buffer
   
   private int frameWidth; // frame size, using getWidth() to get the width from the viewer.
   private int frameHeight;
   private int segment; // x in the picture, the distance from the left of the frame to the center of the first bar. 
   // private int verticalBuffer;
   
   private int numTrials, numTwoHeads, numTwoTails, numHeadTails; 
   private CoinTossSimulator test;
   private int percentTwoHeads, percentTwoTails, percentHeadTails;
   private double scale;
   private String label1, label2, label3; // String the "S" need to be capitalized.
   private int left, bottom;
           
   /**
    *make a CoinTossSimulator and run it for trails tims.
    *get the number of two heads, one head and one tail, two tails, and  calculate the percantage of each one.
    *get the label of each bar
    */ 
   public CoinSimComponent(int trials){ // constructor
      numTrials = trials;
      test = new CoinTossSimulator();
      test.run(trials);
      
      numTrials = test.getNumTrials();
      numTwoHeads = test.getTwoHeads();
      numHeadTails = test.getHeadTails();
      numTwoTails = test.getTwoTails(); 
      percentTwoHeads = (int)Math.round(numTwoHeads * 100.0/ numTrials);
      percentHeadTails = (int)Math.round(numHeadTails * 100.0/ numTrials);
      percentTwoTails = (int)Math.round(numTwoTails * 100.0/ numTrials);
      label1 = "Two Heads: " + numTwoHeads + "(" + percentTwoHeads + "%)";
      label2 = "A head and a Tail: " + numHeadTails + "(" + percentHeadTails + "%)";
      label3 = "Two Tails: " + numTwoTails + "(" + percentTwoTails + "%)";
   }
   
   /**
    *Bar graph will get resized appropriately if the window gets resized. 
    *As mentioned in the textbook, every time a window gets resized or iconified and de-iconified paintComponent gets called again.
    
    *Your program may use a fixed size for the width of each bar, 
    *and for the buffer-space between the tallest possible bar plus its label and the top and bottom of the window.
    */  
   public void paintComponent(Graphics g)
   {    
      int frameWidth = getWidth(); // frame size
      int frameHeight = getHeight();
      // if use getWidth() in the upper constructor, then the bar won't show in the frame.
      int segment = (int)(frameWidth/4); // x in the picture, the distance from the left of the frame to the center of the first bar. 
      // int verticalBuffer = (int)(frameHeight*0.05); // do it with the percentage of the frame
      
      Graphics2D g2 = (Graphics2D) g; // recover the graphoics 2D

      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label1, context);
      // The JComponent methods, getWidth() and getHeight(), which get the width and height of the component
      int widthOfLabel = (int) labelBounds.getWidth(); 
      int heightOfLabel = (int) labelBounds.getHeight();
      
      // int biggestPercent = Math.max(Math.max(percentTwoHeads, percentTwoTails), percentHeadTails);
      int tallestBar = frameHeight - heightOfLabel - 2 * VERTICALBUFFER; // the longest bar we can have, which is for the biggest percentage.
      // in the Bar.java: int scaledBarHeight = (int)(this.barHeight * this.scale);
      // scale = (double)( tallestBar / biggestPercent);
      scale = (double)( tallestBar / 100.0);
      
      // public Bar(int bottom, int left, int width, int barHeight, double scale, Color color, String label) 
      bottom = frameHeight - VERTICALBUFFER;
      left = segment - (int)(BARWIDTH / 2);
      Bar bar1 = new Bar(bottom, left, BARWIDTH, percentTwoHeads, scale, Color.RED, label1);

      left = segment * 2 - (int)(BARWIDTH / 2);
      Bar bar2 = new Bar(bottom, left, BARWIDTH, percentHeadTails, scale, Color.GREEN, label2);
      
      left = segment * 3 - (int)(BARWIDTH / 2);
      Bar bar3 = new Bar(bottom, left, BARWIDTH, percentTwoTails, scale, Color.BLUE, label3);

      bar1.draw(g2);
      bar2.draw(g2); 
      bar3.draw(g2);
   }
}
