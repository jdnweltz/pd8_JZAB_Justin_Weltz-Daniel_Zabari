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
	/*
	for (int row = 0; row < r+2; row++){
	    for ( int col =0; col < c+2; col++){
		maze[row][col] = "[]";
	    }
	    }*/
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
	if (current==null)
	    return;
	s.push(current);
	current.visit();
	Space next=current.Move();
	if (next==null){
	    s.pop().visit();
	    if (!s.empty()){
		Space temp=s.pop();
		temp.visit();
		move(temp);
	    }
	    return;
	}
	else{
	    move(next);
	    return;
	}
    }
	
    public String toString(){
	String ret="";
	for (int col=0;col<_c;col++){
	    ret+="-1";
	}
	ret+="-1-1\n";
	for (int row = 0; row < _r; row++){
	    for ( int col =0; col < _c; col++){
		if (col==0){
		    ret+="-1";
		}
		if (mazeArray[row][col].isVisited()){
		    ret+="  ";
		}
		else{
		    ret+="[]";	
		}
		if (col==_c-1){
		    ret+="-1";
		    }
	    }
	    ret+="\n";
	}
	    /*
	for (int row = 0; row < _r; row++){
	    for ( int col =0; col < _c; col++){
		ret+= maze[row][col];
	    }
	    ret+= "\n";
	    }*/
	for (int col=0;col<_c;col++){
	    ret+="-1";
	}
	ret+="-1-1";
	return ret;
    }

	
	
    public static void main (String[] args){
	MakeMaze maze = new MakeMaze(20,20);
	System.out.println(maze);
	
}
 
	
	    
	
}
