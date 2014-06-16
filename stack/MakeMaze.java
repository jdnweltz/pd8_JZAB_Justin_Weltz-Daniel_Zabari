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
	s=new Stack<Space>();
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
	/*
	for (int row = 0; row < r; row++){
	    for ( int col =0; col < c; col++){
		System.out.println(mazeArray[row][col].rR());
		}
	}*/
    
	
	
	move(mazeArray[0][0]);
	
    }
    /*
    private void move(Space current){
	//System.out.println(toString());
	System.out.println(current.rR()+","+current.rC());
	if (current==null){return;}
	    
	current.visit();
	Space next = current.Move();
	System.out.println(next);
	if (next == null){
	    if (!s.empty()){
		Space temp=s.pop();
		temp.visit();
		move(temp);
	    }
	    else{return;}
	}
	
	else{
	    s.push(current);
	    move(next);
	    if (!s.empty()){
		Space temp2=s.pop();
		temp2.visit();
	    }
	    return;
	}    
	if (s.empty())
	    return;
    }
    */
    private void move(Space current){
	/*if (current==null)
	    return;
	*/
	s.push(current);
	current.visit();
	Space next=current.Move();
	//System.out.println(next);
	if (next==null){
	    s.pop().visit();
	    if (!s.empty()){
		//System.out.println("I popped");
		//System.out.println(current.rR());
		//System.out.println(current.rC());
		Space temp=s.pop();
		temp.visit();
		move(temp);
	    }
	    else
		return;
	    //return;
	}
	else{
	    move(next);
	    //return;
	}
    }
	
    public String toString(){
	String ret="";
	for (int row = 0; row < _r; row++){
	    for ( int col =0; col < _c; col++){
		if (mazeArray[row][col].isVisited()){
		    maze[row+1][col+1] = "  ";
		}
	    }
	}
	maze[0][1] = "SS";
	maze[_r+1][_c] = "EE";
	int l = _r;
	int m = _c;
	while (maze[l][m].equals("[]")){
	    maze[l][m] = "  ";
	    l-= 1;
	}//to make sure the exit is accessible
	   
	for (int row = 0; row < _r+2; row++){
	    for ( int col =0; col < _c+2; col++){
		ret+= maze[row][col];
	    }
	    ret+= "\n";
	}
	return ret;
    }

	
	
    public static void main (String[] args){
	MakeMaze JDawG= new MakeMaze(20,20);
	try {
	    FileWriter f = new FileWriter("maze.txt");
	    f.write(JDawG.toString());
	    f.close();
	}
	catch(Exception e){}
	System.out.println(JDawG);
	MazeSolverStack ms = new MazeSolverStack( "maze.txt",20,20 );
	ms.solve(1,3);
	System.out.println(ms);
    }
	
}
 
	
	    
	

