import java.util.*;
import java.io.*;
public class Radius{
    String[][] maze;
    int _r;
    int _c;
    public Radius(int r, int c){
	maze=new String[r][c];
	_r=r;
	_c=c;
	populate();
    }
    
    private void populate(){
	int ctr=0;
	int e1;
	int e2;
	int rMax=_r-1;
	int cMax=_c-1;
	int rStart=0;
	int cStart=0;
	int p=_r*2+_c*2-2;
	while (cMax>cStart){
	    e1=(int)(Math.random()*p)+1;
	    e2=(int)(Math.random()*p)+1;
	    if (p==4){e1=e2;}
	    ctr=1;
	    for (int j=cStart;j<=cMax;j++){
		maze[rStart][j]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[rStart][j]="  ";
		ctr++;
	    }
	    for (int i=rStart;i<=rMax;i++){
		maze[i][cMax]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[i][cMax]="  ";
		ctr++;
	    }
	    for (int j=cMax;j>=cStart;j--){
		maze[rMax][j]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[rMax][j]="  ";
		ctr++;
	    }
	    for (int i=rMax;i>=rStart;i--){
		maze[i][cStart]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[i][cStart]="  ";
		ctr++;
	    }
	    rStart+=2;
	    cStart+=2;
	    cMax-=2;
	    rMax-=2;
	    p-=16;
	}
    }
    public String toString(){
	String str="";
	for (int i=0;i<_r;i++){
	    for (int j=0;j<_c;j++){
		if (maze[i][j]==null||maze[i][j].equals("  ")) 
		    str+="  ";
		else
		    str+="[]";
	    }
	    str+="\n";
	}
	return str;
    }
    public static void main(String[] args){
	Radius Maze=new Radius(50, 50);
	System.out.println(Maze);
    }
}
		    
