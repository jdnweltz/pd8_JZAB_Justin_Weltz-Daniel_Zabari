import java.util.*;
import java.io.*;
public class MazeBuilder{
    private final char EXITPATH = '#';
    private final char DUMMYPATH  = '*';
    private char[][] _mazeArray;
    private int _caseNumFinal;
    private int _caseNum;
    private int _c;
    private int _r;
    private int rE;
    private int cE;
    public MazeBuilder(int h, int w){
	_r=h;
	_c=w;
	_mazeArray = new char[h][w];
	for (int r = 0;r<_r;r++){
	    for (int c=0;c<_c;c++){
		_mazeArray[r][c] = ' ';
	    }
	}
	_caseNum=(int)(Math.random()*4);
	_caseNumFinal=_caseNum;
	if (_caseNumFinal==0){
	    makeExitPath(0,0,EXITPATH,0);
	    System.out.println("Case1");
	}
	if (_caseNumFinal==1){
	    makeExitPath(0,w-1,EXITPATH,0);
	    System.out.println("Case2");
	}
	if (_caseNumFinal==2){
	    makeExitPath(h-1,w-1,EXITPATH,0);
	    System.out.println("Case3");
	}
	if (_caseNumFinal==3){
	    makeExitPath(h-1,0,EXITPATH,0);
	    System.out.println("Case4");
	}
	transform();
    }
    private void makeExitPath(int r, int c, char path , int startCount){
	if ( r >= _r||r<0 ||c<0||c>=_c){
	    return;
	
	}
	startCount = startCount + 1;
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
	    }
	}
	if (_mazeArray[r][c] == EXITPATH)
	    return;
        if (_mazeArray[r][c] == DUMMYPATH)
	    return;
	if (countNeighbors(r,c) >= 2)
	    return;
	_mazeArray[r][c]= path;
	int Switch=((int)(Math.random()*2));
	double Dummy = Math.random();
	int moveOver = (int)(Math.random()*3);
	double percentage = 1;
	if (_caseNum== 0){
	    if (Switch==0){
		/*
		for (int i = 0; i < moveOver; i ++)
		    _mazeArray[++c][r] = path;
		*/
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(++r,c,EXITPATH, startCount);
			makeExitPath(r,--c,DUMMYPATH,startCount);
		}
		else {
		    if (Dummy < percentage){
		    makeExitPath(--r,c,DUMMYPATH,startCount);
		    }
		}
	    }
	    
	    else{
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(r,++c,EXITPATH,startCount);
		     makeExitPath(--r,c,DUMMYPATH,startCount);
			
		}
		else{
	
		    if (Dummy < percentage){
			makeExitPath(--r,c,DUMMYPATH,startCount);
		    }
		    

		}
	    }
	}
	if (_caseNum== 1){
	    //for (int i = 0; i < moveOver; i ++)
	    //	    _mazeArray[--c][r] = path;
	    if (Switch==0){
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(++r,c,EXITPATH,startCount);
		    makeExitPath(r,++c,DUMMYPATH,startCount);
		}
		else {
		   if (Dummy < percentage)	
		    makeExitPath(--r,c,DUMMYPATH,startCount);
		   
		}
	    }
	    else{
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(r,--c,EXITPATH,startCount);

			makeExitPath(--r,c,DUMMYPATH,startCount);
		}
		else{
		    if (Dummy < percentage)
		    makeExitPath(r,++c,DUMMYPATH,startCount);
		   
		}
	    }
	}
	if (_caseNum== 2){
	    //for (int i = 0; i < moveOver; i ++)
	    //	    _mazeArray[--c][r] = path;
	    if (Switch==0){
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(--r,c,EXITPATH,startCount);

			makeExitPath(r,++c,DUMMYPATH,startCount);
		}
		else {
		    if (Dummy < percentage)	 
			makeExitPath(++r,c,DUMMYPATH,startCount);
		    
		   
		}
	    }
	    else{
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(r,--c,EXITPATH,startCount);

			makeExitPath(++r,c,DUMMYPATH,startCount);
		}
		else{
		    if (Dummy < percentage)
		    makeExitPath(r,++c,DUMMYPATH,startCount);
		    
		}
	    }
	}
	if (_caseNum== 3){
	    //for (int i = 0; i < moveOver; i ++)
	    //	    _mazeArray[++c][r] = path;
	    if (Switch==0){
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(--r,c,EXITPATH,startCount);
		    makeExitPath(r,--c,DUMMYPATH,startCount);
		}
		else {
		    if (Dummy < percentage)
		    makeExitPath(++r,c,DUMMYPATH,startCount);
		   
		   
		}
	    }
	    else{
		if (_mazeArray[r][c] == EXITPATH){
		    rE=r;
		    cE=c;
		    makeExitPath(r,++c,EXITPATH,startCount);

			makeExitPath(++r,c,DUMMYPATH,startCount);
		}
		else{
		  
		    if (Dummy < percentage)
		    makeExitPath(r,--c,DUMMYPATH,startCount);
		}
	    }
	}
		
	/*if (_caseNum== 1){
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
    
    private int countNeighbors(int r, int c){
	int ret = 0;
	if (isValid(r+1,c) && _mazeArray[r+1][c] != ' ')
	    ret++;
	if (isValid(r,c+1) && _mazeArray[r][c+1] != ' ')
	    ret++;
	if (isValid(r-1,c) && _mazeArray[r-1][c] != ' ')
	    ret++;
	if (isValid(r,c-1) && _mazeArray[r][c-1] != ' ')
	    ret++; 
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
		if ((( r==0 || c==_c-1 || r==_r-1 || c==0) && _mazeArray[r][c] != '#') || _mazeArray[r][c] == ' ')
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
	    
    
	
    
