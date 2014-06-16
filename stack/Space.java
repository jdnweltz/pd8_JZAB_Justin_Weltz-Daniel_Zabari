import java.io.*;
    import java.util.*;
public class Space{
    private boolean visited=false;
    private boolean backed=false;
    private int _r;
    private int _c;
    private Space[][] maze;
    
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
	//System.out.println(size);
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
	//System.out.println(Arrays.toString(ret));
	return ret;
    }
    public Space Move(){
	Space[] options = returnUnvisitedNeighbors();
	if ( options.length == 0){
	    return null;
	}
	int size = 0;
	//System.out.println("options" + options.length);
	for (int i = 0; i < options.length; i++){
	    if ( options[i].numVisitedNeighbors()<=1)
		size++;
	}
	if (size == 0)
	    return null;
	System.out.println("size" + size);
	int j = 0;
	Space [] goodOptions = new Space[size];
	for (int i = 0; i < options.length; i++){
	    if (options[i].numVisitedNeighbors()<=1 ){
		System.out.println("hello");
		goodOptions[j] = options[i];
		j++;
	    }
	}
	System.out.println(Arrays.toString(goodOptions));
	int rand =(int)( Math.random()*size);
	System.out.println("rand" + rand);
	System.out.println(goodOptions[rand]);
	return goodOptions[rand];
	    
    }
    
    public String toString(){
	return "" + _r + _c;
    }
	    
    public boolean isBacked(){
	return backed;
    }
}
    
    
