/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;
//The java random number generator. 
//One thing to note about Random: it's a class that through a sequence of method calls generates a sequence of values that 
//depend on the internal state of the object (in this way it is similar to Scanner). 
//Create one Random object in the program, and make another call to nextInt on that same object whenever want a new random number. 
//(creating a Random object every time is not generating a pseudo-random sequence, although it will appear that it is.)

public class CoinTossSimulator {
   private int trials, twoHead, twoTail, headTail;
   private Random coin1, coin2; // two coins that will be tossed in one trial.

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      trials = 0; // number of trials for simulation
      twoHead = 0; // number of two heads
      twoTail = 0; // number of two tails
      headTail = 0; // number of one head and one tail
      coin1 = new Random();
      coin2 = new Random();
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      trials = trials + numTrials; // this time only run numTrials time, but need to get the total number of trials.
      for (int i = 1; i <= numTrials; i++)
      {
         int result1 = coin1.nextInt(2); // The output will be 0 or 1
         int result2 = coin2.nextInt(2);
         // 0 is head, 1 is tail
         if (result1 == 0 && result2 == 0){twoHead++;}
         else if (result1 == 1 && result2 == 1){twoTail++;}
         else{headTail++;}
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return trials; // total number of trials
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHead; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTail; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTail; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      trials = 0;
      twoHead = 0; // number of two heads
      twoTail = 0; // number of two tails
      headTail = 0; // number of one head and one tail
   }

}
