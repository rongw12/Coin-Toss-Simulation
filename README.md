# Coin-Toss-Simulation

A graphics-based program to simulate tossing a pair of coins some number of times, and display the results.

Initially the program will prompt for the number of trials to simulate (a trial is two coin tosses) on the console, error checking that a positive value is entered. 
Then it will run the simulation and display a 500 tall by 800 wide pixel window with the results of that simulation. 
The results will consist of three labeled bars, each a different color, to show how many trials had the specified outcome. 
The placement of each of the bars evenly across the window. And resizing the window does not change the results of the simulation.


CoinSimViewer.java

Contains the main method. Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent.
Besides CoinSimComponent, this class does not depend on any of the other classes mentioned here.


CoinSimComponent.java

Extends JComponent. Constructor initializes any necessary data and runs the simulation. 
Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 
This class uses the CoinTossSimulator and Bar class.


CoinTossSimulator.java

This is the class responsible for doing the simulation. It has no graphical output, does no I/O to the console either. 
It has a run method to run a simulation of tossing a pair of coins for some number of trials. It has accessors to get the results of the simulation. 
Subsequent calls to run add trials to the current simulation. To reset the CoinTossSimulator to start a new simulation, call the reset method. 
CoinTossSimulator does not depend on any of the other of our classes or the graphics library. It does use Random ). 


Bar.java

For drawing a bar in a bar graph. You specify the location, dimensions and color of the bar in the constructor. 
The only other method is draw which draws the bar given. 
Bar does not depend on any of the other of our classes, but does use the graphics library.


CoinTossSimulatorTester.

A program to test the CoinTossSimulator class independently from its use in the CoinSimViewer program. It has its own main method. 
