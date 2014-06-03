import java.util.*;
import java.io.*;
public class MazeBuilder{
    private int[][] _mazeArray;
    private int _caseNumFinal;
    private int _caseNum;
    private int pathNum;
    private int _c;
    private int _r;
    private int rE;
    private int cE;
    public MazeBuilder(int h, int w){
	_r=h;
	_c=w;
	_mazeArray = new int[h][w];
	for (int r = 0;r<_r;r++){
	    for (int c=0;c<_c;c++){
		_mazeArray[r][c] = -1;
	    }
	}
	_caseNum=(int)(Math.random()*1);
	_caseNumFinal=_caseNum;
	if (_caseNumFinal==0){
	    makeExitPath(0,0,0);
	    System.out.println("Case1");
	}
	if (_caseNumFinal==1){
	    makeExitPath(0,w-1,0);
	    System.out.println("Case2");
	}
	if (_caseNumFinal==2){
	    makeExitPath(h-1,w-1,0);
	    System.out.println("Case3");
	}
	if (_caseNumFinal==3){
	    makeExitPath(h-1,0,0);
	    System.out.println("Case4");
	}
	//transform();
    }
    private void makeExitPath(int r, int c, int path){
	System.out.println(r);
		System.out.println(c);
	System.out.println(path);

    
	/*if ( r >= _r||r<0 ||c<0||c>=_c){
	    return;
	
	}
	*/
	/*startCount = startCount + 1;
	if (startCount > 10){
	    if (c==0||c==(_c-1)){
		if (_caseNum==0)
		_caseNum=1;
		else if(_caseNum==1)
		    _caseNum=0;
		else if(_caseNum==2)
		    _caseNum=3;
		else if (_caseNum==3)
		    _caseNum=2;
	*/
		/*
		if (c==0)
		    makeExitPath(r,++c,path,startCount);
		if (c==_c-1)
		    makeExitPath(r,--c,path,startCount);
		//return;
		
	    }
	}
		*/
	//System.out.println(countUnlike(r,c,path));
	//	if (countNeighbors(r,c) >= 2)
	// return;
	ArrayList<Integer> randomSet= new ArrayList();
	for (int i = 0; i  < 4; i++)
	    randomSet.add(i);
	for (int i = 0; i < count.length; i++){
	    cF += count[i];
	}
	boolean exitPathPlaced = falsep;
	for (int i = 0; i < 3; i++){
	    int randomInt = (int) (Math.random() * randomSet.size());
	
	    int randomNum = randomSet.remove(randomInt);
		
	    if (count[0] == 0 && randomNum == 0){
		if(exitPathPlaced){
			    
		    _mazeArray[r-1][c] = 1;
		}
		else{
		    _mazeArray[r-1][c] = 0;
		    exitPathPlaced = true;
		}
	    }
	    if (count[1] == 0 && randomNum == 1){
		if (exitPathPlaced){
		    _mazeArray[r][c+1] = 1;
		}
		else{
		    _mazeArray[r][c+1] = 0;
		    exitPathPlaced = true;
		}
	    }
	    if (count[2] == 0 && randomNum == 2){
		if (exitPathPlaced){
		    _mazeArray[r+1][c] = 1;
		}
		else{
		    _mazeArray[r+1][c] = 0;
		    exitPathPlaced = true;
		}
	    }
	    if (count[3] == 0 && randomNum == 3){
		if (exitPathPlaced){
		    _mazeArray[r][c-1] = 1;
		}
		else{
		    _mazeArray[r][c-1] = 0;
		    exitPathPlaced = true;
		}
	    }
	}
      
	       
	/*_mazeArray[r][c]= path;
	  int Switch=((int)(Math.random()*2));
	  double Dummy = Math.random();
	  int moveOver = (int)(Math.random()*3);
	  double percentage = .9 ;
	  if (_caseNum== 0){
	  //random Switch check
	  if (Switch==0){
	  /*
	  for (int i = 0; i < moveOver; i ++)
	  _mazeArray[++c][r] = path;
	*/
	//if I am part of the exit path
	/*	if (_mazeArray[r][c] == 0){
	// rE=r;
	//cE=c;
	//create one exit path, and one dummy path
	makeExitPath(++r,c,0, startCount);
	makeExitPath(r,--c,pathNum++,startCount);
	}
	//if I am not part of the exit path (dummy path)
	else {
	//Dummy, a random number, less than a constant percentage
	if (Dummy < percentage){
	//create two dummy paths
	makeExitPath(--r,c,pathNum,startCount);
	makeExitPath(r,++c, pathNum,startCount);
       
		    }
		    //same check as above, with reduced percentage, will create paths in all 4 directions.
		    if (Dummy < percentage - .30){
			makeExitPath(++r,c,pathNum, startCount);
			makeExitPath(r,--c,pathNum, startCount);
		    }
		}
	    }
	    //If Switch!=0 make the same checks, but draw t5he exit and dummy paths in other directions.
	    else{
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(r,++c,0,startCount);
		    makeExitPath(--r,c,pathNum++,startCount);
			
		}
		else{
	
		    if (Dummy < percentage){
			makeExitPath(r,--c,pathNum,startCount);
			makeExitPath(++r, c, pathNum,startCount);
		    }
		    if(Dummy < percentage- 30){
			makeExitPath(r, ++c, pathNum, startCount);
			makeExitPath(--r,c, pathNum,startCount);
		    }
		    

		}
	    }
	}
	/*	else if (_caseNum== 1){
	    //for (int i = 0; i < moveOver; i ++)
	    //	    _mazeArray[--c][r] = path;
	    if (Switch==0){
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(++r,c,0,startCount);
		    makeExitPath(r,++c,DUMMYPATH,startCount);
		}
		else {
		   if (Dummy < percentage)	
		    makeExitPath(--r,c,DUMMYPATH,startCount);
		   
		   
		}
	    }
	    else{
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(r,--c,0,startCount);

			makeExitPath(--r,c,DUMMYPATH,startCount);
		}
		else{
		    if (Dummy < percentage){
			makeExitPath(r,++c,DUMMYPATH,startCount);
			makeExitPath(++r, c, DUMMYPATH, startCount); 
		    }
		}
	    }
	}
 
	else if (_caseNum== 2){
	    //for (int i = 0; i < moveOver; i ++)
	    //	    _mazeArray[--c][r] = path;
	    if (Switch==0){
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(--r,c,0,startCount);

			makeExitPath(r,++c,DUMMYPATH,startCount);
		}
		else {
		    if (Dummy < percentage)	 
			makeExitPath(++r,c,DUMMYPATH,startCount);
		    
		   
		}
	    }
	    else{
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(r,--c,0,startCount);

			makeExitPath(++r,c,DUMMYPATH,startCount);
		}
		else{
		    if (Dummy < percentage)
		    makeExitPath(r,++c,DUMMYPATH,startCount);
		    
		}
	    }
	}
	else if (_caseNum== 3){
	    //for (int i = 0; i < moveOver; i ++)
	    //	    _mazeArray[++c][r] = path;
	    if (Switch==0){
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(--r,c,0,startCount);
		    makeExitPath(r,--c,DUMMYPATH,startCount);
		}
		else {
		    if (Dummy < percentage)
		    makeExitPath(++r,c,DUMMYPATH,startCount);
		   
		   
		}
	    }
	    else{
		if (_mazeArray[r][c] == 0){
		    //rE=r;
		    //cE=c;
		    makeExitPath(r,++c,0,startCount);

			makeExitPath(++r,c,DUMMYPATH,startCount);
		}
		else{
		  
		    if (Dummy < percentage)
		    makeExitPath(r,--c,DUMMYPATH,startCount);
		}
	    }
	}
		
	if (_caseNum== 1){
	    if (Switch==0)
		makeExitPath(++r,c);
	    else
		makeExitPath(r,--c);
	}
	if (_caseNum== 2){
	    if (Switch==0)
		makeExitPath(--r,c);
	    else
		makeExitPath(r,--c);
	}
	if (_caseNum== 3){
	    if (Switch==0)
		makeExitPath(--r,c);
	    else
		makeExitPath(r,++c);
	}
	*/

	
    }
    private boolean isValid(int r, int c){
	return !(c >= _c || r >= _r || c <0 || r<0 );
    }
    
	/*   private int countNeighbors(int r, int c){
	int ret = 0;
	if (isValid(r+1,c) && _mazeArray[r+1][c] != 0)
	    ret++;
	if (isValid(r,c+1) && _mazeArray[r][c+1] != 0)
	    ret++;
	if (isValid(r-1,c) && _mazeArray[r-1][c] != 0)
	    ret++;
	if (isValid(r,c-1) && _mazeArray[r][c-1] != 0)
	    ret++; 
	return ret;
    }
	*/

    private int [] countAround(int r, int c){
	int [] ret = new int [4];
	if (isValid(r-1,c)){
	    if ( _mazeArray[r-1][c] != -1)
		ret[0] = 1;
	}
	else
	    ret[0] = 1;
	if (isValid(r,c+1)){
	    if (_mazeArray[r][c+1] != -1 )
		ret[1] = 1;
	}
	else
	    ret[1] = 1;
	if (isValid(r+1,c)){
	    if (_mazeArray[r+1][c] != -1)
	    ret[2] = 1;
	}
	else
	    ret[2] = 1;
	if (isValid(r,c-1)){
	    if( _mazeArray[r][c-1] != -1)
	    ret[3]= 1;
	} 
	else
	    ret[3] = 1;
	return ret;
    }

	
    public String toString(){
	String ret = "";
	for (int r = 0;r<_r;r++){
	    for (int c=0;c<_c;c++){
		ret+=_mazeArray[r][c];
	    }
	    ret+="\n";
	}
	//ret=ret.replace("|",Character.toString((char)10));
	return ret;
    }
    public void transform(){
	for (int r = 0;r<_r;r++){
	    for (int c=0;c<_c;c++){
		if ((( r==0 || c==_c-1 || r==_r-1 || c==0) && (_mazeArray[r][c]!= 0)) || _mazeArray[r][c] == ' ')
		    _mazeArray[r][c]='D';
		else  
		    _mazeArray[r][c]=' ';
	    }
	}
    }
    public static void main(String[] args){
	MazeBuilder JDawG=new MazeBuilder(100,100);
	try {
	    FileWriter f=new FileWriter("maze.txt");
	    f.write(JDawG.toString());
	}
	catch(Exception e){}
		System.out.println(JDawG);
    }
}
	    
    
	
    
