public class Space{
    private boolean visited=false;
    private boolean backed=false;
    private _r;
    private _c;
    private Space[][] maze;
    
    public Space(int r,int c, Space[][] maz){
	_r=r;
	_c=c;
	maze=maz;
    }

    private Space[] getNeighbors(){
	Space[] ret=new Space[4];
	for (int i=0; i<ret.length;i++){
	    if (i==0){
		if (!_r==0){
		    ret[i]=maze[_r-1][_c];
		}
	    }
	    if (i==1){
		if (!_c==maze[0].length-1){
		    ret[i]=maze[_r][_c+1];
		}
	    }
	    if (i==2){
		if (!_r==maze.length){
		    ret[i]=maze[_r+1][_c];
		}
	    }
	    if (i==3){
		if (!_c==0){
		    ret[i]=maze[_r][_c-1];
		}
	    }
	}
    }
    public boolean isVisited(){
	return visited;
    }
    public void setVisit(boolean b){
	visited=t;
    }
    public void setBack(boolean b){
	backed=b;
    }
    public int returnUnvisitedNeighbor(){
	/* where 0 is the top one, 1 is the one to the right, and proceed clockwise*/
	Space[] n=getNeighbors();
	for (int i=0;i<n.length;i++){
	    if (!n[i]==null){
		if (!n[i].isVisited())
		    return i;
	    }
	}
	return -1;
    }
	
    public boolean isBacked(){
	return backed;
    }
}
    
    
