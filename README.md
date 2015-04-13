pd8_JZAB_Justin_Weltz-Daniel_Zabari
===================================
This final project implements three different algorithms for generating mazes. 

In order to use this program, compile and run the driver. 

From terminal:


<code> git clone https://github.com/jdnweltz/pd8_JZAB_Justin_Weltz-Daniel_Zabari.git 

cd "The Algorithms"

javac Driver.java

java Driver
</code>

This will give you three different options:

Justin’s Algorithm: (which works by expanding in every direction possible - possible meaning not off the board or into another path) 

Daniel’s Algorithm: (which works by creating a square shape.  It mathematically plants the exits, and ensures that they are not near each other.  Then it randomly chooses one of the four center tiles to serve as an exit, denoted by two exclamation points, 

Stack Algorithm: (which works by expanding in one possible direction - possible defined as before and then back-tracking using a stack when the pathway is blocked). 


After you choose the algorithm you would like to implement, you will be allowed to specify dimensions and then view the maze in the terminal - the maze will also be available for printout and easy viewing through the text file maze.txt. After you have attempted to solve the maze, you can then view the solution in the terminal by typing “sol” and in the text file mazeSolution.txt. Have Fun!!!

