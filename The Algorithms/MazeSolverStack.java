

import java.io.*;
import java.util.*;

//This implements the mazeSolver class for the stack algorithm.
public class MazeSolverStack {

    private String[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;

    //initialize constants
    final private String HERO = "@";
    final private String PATH = "#";
    final private String WALL1 = "[";
    final private String WALL2 = "]";
    final private String EXIT1 = "E";
    final private String EXIT2 = "N";
    final private String START1 = "S";
    final private String START2 = "R";
    
    final private String VISITED_PATH = ".";


    public MazeSolverStack( String inputFile, int height, int width ) {
	maze = new String[height+5][width*2+5];
	h = height+2;
	
	try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    //System.out.println( "reading in file..." );

	    //System.out.println(h);
	    //System.out.println(w);
	 
	    for (int row = 0; row < h; row++){
		String line = sc.nextLine();
		w = line.length()+1;
		for( int i=0; i<line.length(); i++ )
		    maze[row][i] = line.substring( i,i+1 );	    }
	}

	catch( Exception e ) { System.out.println( e); }

	solved = false;
	
    
    }//end constructor


    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	//String retStr = "[0;0H";
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC
	String retStr = "";
	int i, j;
	for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
		if (maze[i][j] == null)
		    retStr+= " ";
		else
		    retStr = retStr + maze[i][j];
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



	//primary base case
	if ( maze[x][y] .equals( EXIT1 )|| maze[x][y] .equals( EXIT2 )  ){
	    solved = true;
	    for (int i=0; i<h;i++){
		for(int j=0;j<w;j++){
		    if (maze[i][j]=="."){
			maze[i][j]=" ";
		    }
		}
	    }
	    System.out.println(this);
		try {
		    FileWriter f = new FileWriter("mazeSolution.txt");
		    f.write(toString());
		    f.close();
		}
		 catch(Exception e){}
	    System.exit(0);
	}
	//other base cases
	else if ( maze[x][y].equals(WALL1) || maze[x][y] .equals( WALL2) ||
		  maze[x][y] .equals( HERO) ||
		  maze[x][y] .equals( VISITED_PATH) ||  maze[x][y] .equals( START1 ) ||  maze[x][y] .equals( START2 )  ) {
	    return;
	}
	//otherwise, recursively solve maze from next pos over,
	//after marking current location
	else {
	    maze[x][y] = HERO;
	    //System.out.println( this ); //refresh screen

	    if ( !solved )
		solve( x, y-1 ); //solve from 1 pos up
	    if ( !solved )
		solve( x+1, y ); //solve from 1 pos to right
	    if ( !solved )
		solve( x, y+1 ); //solve from 1 pos down
	    if ( !solved )
		solve( x-1, y ); //solve from 1 pos to left

	    maze[x][y] = VISITED_PATH;
	    //System.out.println( this ); //refresh screen
	}
    }

    //accessor method to help with randomized drop-in location
    public boolean onPath( int x, int y) { return maze[x][y] .equals(PATH); }

}//end class MazeSolver


/*public class Maze {

    public static void main( String[] args ) {

       try {
	MazeSolver ms = new MazeSolver( "maze.txt",30,30 );
	//clear screen
	//System.out.println( "[2J" );

	//display maze
	System.out.println( ms );
	ms.solve( 1, 3 );


	}
	catch( Exception e ) {
	    System.out.println(e);
	  }
    }

}//end class Maze
*/
