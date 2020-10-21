import javax.swing.JFrame;
import java.util.Scanner;

   /** CoinSimViewer. Contains the main method. 
    *Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent. 
    *Besides CoinSimComponent, this class does not depend on any of the other classes mentioned here 
    *(e.g., if one of those other classes changed, CoinSimViewer would not have to change.) 
    *The later section on communicating information between objects will be useful when developing this and the next class listed.
    */

public class CoinSimViewer
{
   public static final int FRAMEWIDTH = 800; // the width of frame
   public static final int FRAMEHEIGHT = 500; // the height of frame
   
   public static void main(String[] args)
   {
      System.out.print("Enter number of trials:");
      Scanner in = new Scanner(System.in);
      int trialCount = in.nextInt();
      
      while (trialCount < 1) // error checking
      {
         System.out.println("ERROR: Number entered must be greater than 0.");
         System.out.print("Enter number of trials: ");
         trialCount = in.nextInt();
      }
      
      // A more detailed explanation of the following codes can be found from the textboook.
      JFrame frame = new JFrame();

      frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Displaying a component in the frame
      // we need to frame to show the application, also need a somponent to draw
      // following is how to combine the two.
      CoinSimComponent component = new CoinSimComponent(trialCount); //construct an object of the component class
      frame.add(component); // add the comonent to the frame

      frame.setVisible(true); // make the frame visible
   }
}
