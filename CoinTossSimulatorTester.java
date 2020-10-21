/**
 *Note for CoinSimViewer.list
 *
 *A list of the .java files for compiling the CoinSimViewer program.
 *For the larger program we are doing for this assignment (for that one main is in CoinSimViewer.java), 
 *you can either list all of the files it uses on the command line; but the following is a convenient shorthand:

   javac @CoinSimViewer.list
   java CoinSimViewer

 *The CoinSimViewer.list file just consists of the list of files to compile for the program. 
 *The @ on the command line tells java to look in the file that follows it find out what java files to compile. 
 *An alternate is to use *.java instead in the compile command, although that one would also attempt to compile CoinTossSimulatorTester.java.
 */

import java.util.Scanner;
// import java.awt.Color;

   /**
    *CoinTossSimulatorTester
    *A program to test the CoinTossSimulator class independently from its use in the CoinSimViewer program. 
    *
    *Because of the random nature of the program, we can't predict the exact results of calls to run, 
    *So test if the sum of (the number of two-head tosses, two-tail tosses, and head-tail tosses) equal to the total number of trials. 
    *Display true or false for this result by just printing out the result of a boolean expression.
    */

public class CoinTossSimulatorTester
{
   public static void main(String[] args)
   {
      CoinTossSimulator test = new CoinTossSimulator();
/* int to string
1.String str = String.ValueOf(i);
 
2.String str = Intager.toString(i);
 
3.String str = ""+i; // so don't need to make the int from getNumTrials() to string to print it out, just use +
*/      
      System.out.println("After constructor:");
      System.out.println("Number of trials [exp:0]: " + test.getNumTrials());
      System.out.println("Two-head tosses: " + test.getTwoHeads());
      System.out.println("Two-tail tosses: " + test.getTwoTails());
      System.out.println("One-head one-tail tosses: " + test.getHeadTails());
      System.out.println("Tosses add up correctly? " + (test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()));
      System.out.println();
      
      test.run(1);
	  System.out.println("After run(1):");
	  System.out.println("Number of trials [exp:1]: " + test.getNumTrials());
	  System.out.println("Two-head tosses: " + test.getTwoHeads());
      System.out.println("Two-tail tosses: " + test.getTwoTails());
	  System.out.println("One-head one-tail tosses:" + test.getHeadTails());
	  System.out.println("Tosses add up correcttly? " + (test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()));
      System.out.println();

	  test.run(10);
	  System.out.println("After run(10):");
	  System.out.println("Number of trials [exp:11]: " + test.getNumTrials());
	  System.out.println("Two-head tosses: " + test.getTwoHeads());
      System.out.println("Two-tail tosses: " + test.getTwoTails());
	  System.out.println("One-head one-tail tosses: " + test.getHeadTails());
	  System.out.println("Tosses add up correcttly? " + (test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()));
      System.out.println();
      
	  test.run(100);
	  System.out.println("After run(100):");
	  System.out.println("Number of trials [exp:111]: " + test.getNumTrials());
	  System.out.println("Two-head tosses: " + test.getTwoHeads());
      System.out.println("Two-tail tosses: " + test.getTwoTails());
	  System.out.println("One-head one-tail tosses: " + test.getHeadTails());
	  System.out.println("Tosses add up correcttly? " + (test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()));
      System.out.println();

      System.out.println("[ . . . output for tests with different number of trials were here . . .]");
      System.out.println();
                         
	  test.reset(); // reset the test, all trials set to 0
	  System.out.println("After reset:");
	  System.out.println("Number of trials [exp:0]: " + test.getNumTrials());
	  System.out.println("Two-head tosses: " + test.getTwoHeads());
      System.out.println("Two-tail tosses: " + test.getTwoTails());
	  System.out.println("One-head one-tail tosses: " + test.getHeadTails());
      System.out.println("Tosses add up correcttly? " + (test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()));
      System.out.println();

	  test.run(1000);
	  System.out.println("After run(1000):");
	  System.out.println("Number of trials [exp:1000]: " + test.getNumTrials());
	  System.out.println("Two-head tosses: " + test.getTwoHeads());
      System.out.println("Two-tail tosses: " + test.getTwoTails());
	  System.out.println("One-head one-tail tosses: " + test.getHeadTails());
	  System.out.println("Tosses add up correcttly? " + (test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()));
      System.out.println();
      
      System.out.println("[ . . . output for tests with different number of trials were here . . .]");

   }
}
