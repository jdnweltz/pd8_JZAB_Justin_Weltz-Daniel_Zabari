import java.util.*;
import java.io.*;
public class MakeMaze{
    private String[][] maze;
    private int _r;
    private int _c;
    private Stack<Space> s;
    private Space[][]mazeArray;
    private String[][] _case;
    public MakeMaze(int r, int c){
	_r = r;
	_c = c;
	maze = new String [r+2][c+2];
	mazeArray = new Space [r][c];
	for (int row = 0; row < r; row++){
	    for ( int col =0; col < c; col++){
		mazeArray[row][col] = new Space (row,col,mazeArray);
	    }
	}
	for (int row = 0; row < r+2; row++){
	    for ( int col =0; col < c+2; col++){
		maze[row][col] = "[]";
	    }
	}
	for (int row = 0; row < r; row++){
	    for ( int col =0; col < c; col++){
		System.out.println(mazeArray[row][col].rR());
	    }
	}
	
	
	move(mazeArray[0][0]);
    
    }
    private void move(Space current){
	System.out.println(toString());
	current.setVisit(true);
	Space next = current.Move();
	System.out.println(next);
	if (next == null)
	    move(s.pop());	
	else{
	    s.add(current);
	    move(next);
	}    
    }
    public String  toString(){
	for (int row = 0; row < _r; row++){
	    for ( int col =0; col < _c; col++){
		if (mazeArray[row][col].isVisited()){
		    maze[row+1][col+1] = "  ";
		}
	    }
	}
	String ret = "";
	for (int row = 0; row < _r; row++){
	    for ( int col =0; col < _c; col++){
		ret+= maze[row][col];
	    }
	    ret+= "\n";
	}
	return ret;
    }

	
	
    public static void main (String[] args){
	MakeMaze maze = new MakeMaze(20,20);
	
}
 
	
	    
	
}
