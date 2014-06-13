import java.util.*;
import java.io.*;
public class MazeBuilder{
    private int[][] _mazeArray;
    private int pathNum;
    private int _c;
    private int _r;
    private String[][] _maze; 
    private int _path = 0;
    private int[][] _case;
    private boolean _rowMajor = false;
    public MazeBuilder(int h, int w){
	_r=h;
	_c=w;
	_mazeArray = new int[h][w];
	_maze = new String[h+4][w+2];
	_case = new int[h+2][w+2];
	for (int r = 0;r<_r;r++){
	    for (int c=0;c<_c;c++){
		_mazeArray[r][c] = -1;
	    }
	}
	for (int r = 0;r<_r+4;r++){
	    for (int c=0;c<_c+2;c++){
		_maze[r][c] = "  ";
	    }
	}
	for (int r = 0;r<_r+2;r++){
	    for (int c=0;c<_c+2;c++){
		_case[r][c] = -1;
	    }
	}
	makeExitPath(0,0,0);
	placeInCase();
	openingAndEnding();
	transform();
    }
    private void makeExitPath(int r, int c, int path){
	_path = path;

	int []count = countAround(r,c);
	int cF = 0;
	for (int i = 0; i < count.length; i++){
	    if (count[i] == 1 || count[i] ==2 )
		cF++;
	}
	if (cF == 4)
	    return;
	else 
	    _mazeArray[r][c] = path;
		
	ArrayList<Integer> randomSet= new ArrayList();
	for (int i = 0; i  < 4; i++)
	    randomSet.add(i);
       

	
	boolean exitPathPlaced = false;
	for (int i = 0; i < 4; i++){
	    int randomInt = (int) (Math.random() * randomSet.size());
	
	    int randomNum = randomSet.remove(randomInt);
	    //System.out.println(randomSet.size());
		
	    if (count[0] == 0 && randomNum == 0){

		    int total = 0;
		    int [] neighbors= countAround(r-1,c);
		    for (int k = 0; k < 4; k++)
			if ( neighbors[k] ==1)
			    total++;
		    if (total < 2){

        
			    makeExitPath(r-1,c,path++);
        
			
		    }
	    }
	  
	    if (count[1] == 0 && randomNum == 1){
		int total = 0;
		int [] neighbors= countAround(r,c+1);
		for (int k = 0; k < 4; k++)
		    if ( neighbors[k] ==1)
			total++;
		if (total < 2){
		
		    	makeExitPath(r,c+1,path++);

		    }
	    }
	   
	     if (count[2] == 0 && randomNum == 2){
			    int total = 0;
		    int [] neighbors= countAround(r+1,c);
		    for (int k = 0; k < 4; k++)
			if ( neighbors[k] ==1)
			    total++;
		    if (total < 2){
        
			    makeExitPath(r+1,c,path++);
	        
		    }
	    }
	    
	    if (count[3] == 0 && randomNum == 3){
		    int total = 0;
		    int [] neighbors= countAround(r,c-1);
		    for (int k = 0; k < 4; k++)
			if ( neighbors[k] ==1)
			    total++;
		    if (total < 2){
			    makeExitPath(r,c-1,path++);

		    }
	    }
	    
	}
      
	       


	
    }
    private boolean isValid(int r, int c){
	return !(c >= _c || r >= _r || c <0 || r<0 );
    }
    
    private void openingAndEnding (){
	_case[0][1] = 0;
	int max = 0;
	int maxR = 0;
	int maxC = 0;
	/*for (int c = 1; c < _c+1; c++){
	    if (_case[1][c] > max){
		max = _case[1][c];
		maxR = 0;
		maxC = c;
	    }
	}
	*/
	for (int c = 1; c < _c+1; c++){
	    if (_case[_r-2][c] > max){
		max = _case[_r][c];
		maxR = _r+1;
		maxC = c;
	    }
	}
	/*for (int r = 1; r < _r+1; r++){
	    if (_case[r][1] > max){
		max = _case[r][1];
		maxR = r;
		maxC = 0;
	    }
	}
	*/
	for (int r = 1; r < _r+1; r++){
	    if (_case[r][_c-1] > max){
		max = _case[r][_c];
		maxR = r;
		maxC = _c+1;
	    }
	}
	//System.out.println(maxR);
	//System.out.println(maxC);
	_case[maxR][maxC] = -3;
	
	if (maxR == _r + 1){
	    System.out.println("yes");
	    _rowMajor = true;
	}
	  
    }  

    private int [] countAround(int r, int c){
	int [] ret = new int [4];
	if (isValid(r-1,c)){
	    if ( _mazeArray[r-1][c] != -1)
		ret[0] = 1;
	}
	else
	    ret[0] = 2;
	if (isValid(r,c+1)){
	    if (_mazeArray[r][c+1] != -1)
		ret[1] = 1;
	}
	else
	    ret[1] = 2;
	if (isValid(r+1,c)){
	    if (_mazeArray[r+1][c] != -1)
	    ret[2] = 1;
	}
	else
	    ret[2] = 2;
	if (isValid(r,c-1)){
	    if( _mazeArray[r][c-1] != -1)
	    ret[3]= 1;
	} 
	else
	    ret[3] = 2;
	return ret;
    }

	
    public String toString(){
	String ret = "";
	for (int r = 0;r<_r+4;r++){
	    for (int c=0;c<_c+2;c++){
		ret+=_maze[r][c];
	    }
	    ret+="\n";
	}
	return ret;
    }
    public void placeInCase(){
	for (int r = 0;r<_r;r++){
	    for (int c=0;c<_c;c++){
		_case[r+1][c+1] =_mazeArray[r][c];
	    }
	}
    }
		 
    public void transform(){
	String s = "START";
	for (int i =0; i<5; i++)
	    _maze[0][i] = s.substring(i,i+1);
	for (int r = 0;r<_r+2;r++){
	    for (int c=0;c<_c+2;c++){
		if (_case[r][c] == -1)
		    _maze[r+1][c] = "[]";
		else if (_case[r][c] ==-2)
		    _maze[r+1][c] = "SS";
		else if (_case[r][c] ==-3){
		    if (_rowMajor)
			_maze[r+2][c] = "END";	
		    else
			_maze[r+1][c] = "END";
		}
		else
		    _maze[r+1][c] = "  ";
			
	    }
	}
    }
    public static void main(String[] args){
	int h = Integer.parseInt(args[0]);
	int w = Integer.parseInt(args[1]);
	MazeBuilder JDawG=new MazeBuilder(h,w);
	try {
	    FileWriter f = new FileWriter("maze.txt");
	    f.write(JDawG.toString());
	    f.close();
	}
	catch(Exception e){}
	System.out.println(JDawG);
    }
}
	    
    
	
    
