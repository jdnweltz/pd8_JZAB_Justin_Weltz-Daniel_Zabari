import java.util.*;
import java.io.*;
public class Backtrack{
    private Space[][] maze;
    private int _r;
    private int _c;
    private Stack<Space> s;
    public Backtrack(int r, int c){
	_r=r;
	_c=c;
	maze=new String[_r][_c];
	s=new Stack<Space>();
    }
    private void move(int r, int c){
	if (maze[r][c].visit()==0)
	    s.push(maze[r][c]);
	if (maze[r][c].returnUnvisitedNeighbor()==0){
	    move(r-1,c);
	}
	if (maze[r][c].returnUnvisitedNeighbor()==1){
	    move(r,c+1);
	}
	if (maze[r][c].returnUnvisitedNeighbor()==2){
	    move(r+1,c);
	}
	if (maze[r][c].returnUnvisitedNeighbor()==3){
	    move(r,c-1);
	}
	if (maze[r][c].returnUnvisitedNeighbor()==-1){
	    off();
	}
    }

    private void off(){
	if (s.peek()!=null){
	    Space y=s.pop();
	    y.visit();
	    move(y.rR(),y.rC());
	}
    }
	
	    
	
}
