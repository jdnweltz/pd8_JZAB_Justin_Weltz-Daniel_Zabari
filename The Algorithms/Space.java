import java.io.*;
    import java.util.*;
public class Space{
    private boolean visited=false;
    private boolean backed=false;
    private int _r;
    private int _c;
    private Space[][] maze;
    //this element acts as a piece of the array that can be stacked and marked for the toString method.
    //its returnUnvisitedNeighbor method performs the same kind of check as the Unoccupied Algorithm neighbor check does - the main difference lies in the fact that the stack method expands in one direction at a time - then pops of and expands in a different direction.
    
    public Space(int r,int c, Space[][] maze1){
	_r=r;
	_c=c;
	maze = maze1;  
    }
    public Space[][] getMaze(){
	return maze;
    }

    private Space[] getNeighbors(){
	Space[] ret=new Space[4];
	for (int i=0; i<ret.length;i++){
	    if (i==0){
		if (!(_r==0)){
		    ret[i]=maze[_r-1][_c];
		}
	    }
	    if (i==1){
		if (!(_c==maze[0].length-1)){
		    ret[i]=maze[_r][_c+1];
		}
	    }
	    if (i==2){
		if (!(_r==maze.length-1)){
		    ret[i]=maze[_r+1][_c];
		}
	    }
	    if (i==3){
		if (!(_c==0)){
		    ret[i]=maze[_r][_c-1];
		}
	    }
	}
	return ret;
    }
    public boolean isVisited(){
	return visited;
    }
    public int rR(){return _r;}
    public int rC(){return _c;}
    public int visit(){
	if (isVisited()){
	    setBack(true);
	    return 1;
	}
	if (!isVisited()) {
	    setVisit(true);
	    return 0;
	}
	else
	    return 2;
    }
    public void setVisit(boolean b){
	visited=b;
    }
    public void setBack(boolean b){
	backed=b;
    }
    public int numVisitedNeighbors(){
	Space[] a=getNeighbors();
	int ret=0;
	for (int i=0;i<a.length;i++){
	    if (a[i]!=null){
		if (a[i].isVisited())
		    ret++;
	    }
	}
	return ret;
    }
			   
    public Space[] returnUnvisitedNeighbors(){
	/* where 0 is the top one, 1 is the one to the right, and proceed clockwise*/
	int size=0;
	Space[] n=getNeighbors();
	for (int i=0;i<n.length;i++){
	    if (!(n[i]==null)){
		if (!(n[i].isVisited()))
		    size++;
	    }
	}

	Space[] ret=new Space[size]; 
	int j=0;
	for (int i=0;i<n.length;i++){
	    if (!(n[i]==null)){
		if (!(n[i].isVisited())){
		    ret[j]=n[i];
		    j++;
		}
	    }
	}
	return ret;
    }
    public Space Move(){
	Space[] options = returnUnvisitedNeighbors();
	if ( options.length == 0){
	    return null;
	}
	int size = 0;
	for (int i = 0; i < options.length; i++){
	    if ( options[i].numVisitedNeighbors()<=1)
		size++;
	}
	if (size == 0)
	    return null;
	int j = 0;
	Space [] goodOptions = new Space[size];
	for (int i = 0; i < options.length; i++){
	    if (options[i].numVisitedNeighbors()<=1 ){
		goodOptions[j] = options[i];
		j++;
	    }
	}
	int rand =(int)( Math.random()*size);
	return goodOptions[rand];
	    
    }
    
    public String toString(){
	return "" + _r + _c;
    }
	    
    public boolean isBacked(){
	return backed;
    }
}
    
    
