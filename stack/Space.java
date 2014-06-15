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
    private int rR(){return _r;}
    private int rC(){return _c;}
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
	visited=t;
    }
    public void setBack(boolean b){
	backed=b;
    }
    public Space[] returnUnvisitedNeighbor(){
	/* where 0 is the top one, 1 is the one to the right, and proceed clockwise*/
	int size=0;
	Space[] n=getNeighbors();
	for (int i=0;i<n.length;i++){
	    if (!n[i]==null){
		if (!n[i].isVisited()&&n[i].returnUnvisitedNeighbor().length()>=3)
		    size++;
	    }
	}
	Space[] ret=new Space[size]; 
	int j=0;
	for (int i=0;i<n.length;i++){
	    if (!n[i]==null){
		if (!n[i].isVisited()&&n[i].returnUnvisitedNeighbor().length()>=3)
		    ret[j++]=n[i];
	    }
	}
	return ret;
    }
	
    public boolean isBacked(){
	return backed;
    }
}
    
    
