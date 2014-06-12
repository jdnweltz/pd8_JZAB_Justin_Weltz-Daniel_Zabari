/*======================================
class MazeSolver
Implements a blind depth-first exit-finding algorithm.
======================================*/

import java.io.*;
import java.util.*;


class MazeSolver {

    private char[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;

    //initialize constants
    final private char HERO = '@';
    final private char PATH = '#';
    final private char WALL1 = '[';
    final private char WALL2 = ']';
    final private char EXIT = '$';
    final private char START = 'S';
    final private char VISITED_PATH = '.';


    public MazeSolver( String inputFile, int height, int width ) {

	//init 2D array to represent maze
	// ...same dimensions as default terminal window
	maze = new char[height][width];
	w = witdth;
	h = height;

	try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {
    
		String line = sc.nextLine();
    
		for( int i=0; i<w; i++ )
		    maze[i][row] = line.charAt( i );
		row++;
	    }

	    catch( Exception e ) { System.out.println( "Error reading file" ); }


	    solved = false;
	}
    }//end constructor


    public String toString() {
//send ANSI code "ESC[0;0H" to place cursor in upper left
String retStr = "[0;0H";
//emacs shortcut: C-q, then press ESC
//emacs shortcut: M-x quoted-insert, then press ESC

int i, j;
for( i=0; i<h; i++ ) {
for( j=0; j<w; j++ )
retStr = retStr + maze[j][i];
retStr = retStr + "\n";
}
return retStr;
    }


    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) {
try {
Thread.sleep(n);
}
catch( InterruptedException e ) {
System.exit(0);
}
    }


    /*********************************************
* void solve(int x,int y) -- recursively finds maze exit (depth-first)
* @param x starting x-coord, measured from left
* @param y starting y-coord, measured from top
*********************************************/
    public void solve( int x, int y ) {

delay(50); //slow it down enough to be followable

//primary base case
if ( maze[x][y] == EXIT ) {
    solved = true;
    System.out.println( this ); //refresh screen
    return;
}
//other base cases
else if ( maze[x][y] == WALL1 || maze[x][y] == WALL2 ||
	  maze[x][y] == HERO ||
	  maze[x][y] == VISITED_PATH ) {
    return;
}
//otherwise, recursively solve maze from next pos over,
//after marking current location
else {
maze[x][y] = HERO;
System.out.println( this ); //refresh screen

if ( !solved )
solve( x, y-1 ); //solve from 1 pos up
if ( !solved )
solve( x+1, y ); //solve from 1 pos to right
if ( !solved )
solve( x, y+1 ); //solve from 1 pos down
if ( !solved )
solve( x-1, y ); //solve from 1 pos to left

maze[x][y] = VISITED_PATH;
System.out.println( this ); //refresh screen
}
    }

    //accessor method to help with randomized drop-in location
    public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

}//end class MazeSolver


public class Maze {

    public static void main( String[] args ) {

try {
MazeSolver ms = new MazeSolver( "maze.txt" );
//clear screen
System.out.println( "[2J" );

//display maze
System.out.println( ms );
//ms.solve( 4, 3 );


}
catch( Exception e ) {
System.out.println( "Error reading input file." );
System.out.println( "Usage: java Maze <filename>" );
}
    }

}//end class Maze