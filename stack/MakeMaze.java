import java.util.*;
import java.io.*;
public class MakeMaze{
    private Space[][] maze;
    private int _r;
    private int _c;
    private Stack<Space> s;
    public MakeMaze(int r, int c){
	_r = r;
	_c = c;
	Space[][]mazeArray = new Space [r][c];
	for (int row = 0; row < r; row++){
	    for ( int col =0; col < c; col++){
		mazeArray[row][col] = new Space (r,c,mazeArray);
	    }
	}
	/*for (int row = 0; row < r; row++){
	    for ( int col =0; col < c; col++){
		System.out.println(mazeArray[row][col].getMaze());
	    }
	}
	*/
	
	move(mazeArray[0][0]);
    
    }
    private void move(Space current){
	current.setVisit(true);
	Space next = current.Move();
	move(next);
    }
    public static void main (String[] args){
	MakeMaze maze = new MakeMaze(20,20);
	
}
 
	
	    
	
}
