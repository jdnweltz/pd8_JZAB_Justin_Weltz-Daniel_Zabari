import java.util.*;
import java.io.*;
public class Radius{
    String[][] maze;
    int _r;
    int _c;
    int pe1;
    int pe2;
    public Radius(int r){
	maze=new String[r][r];
	_r=r;
	_c=r;
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
	int p=_r*2+_c*2-4;
	int level =1;
	while (cMax>cStart&&rMax>rStart){
	    //System.out.println(level);
	    e1=((int)(Math.random()*p))+1;
	    e2=((int)(Math.random()*p))+1;
	    //System.out.println(e1+","+e2);
	    if (p==4){e1=e2=4;}
	    if (p==20){
		//	System.out.println(p);
		e1=3;
		e2=7;
	    }
	    if (p>4){
		if (Math.abs(e1-e2)<1)
		    e1+=3;
		if (e1>p)
		    e1%=p;
	    }
	    /*	    
	    if (p>4){

		if (e1==1||e1==(1+p/4)||e1==(1+p/2)||e1==(1+(3*p)/4))
		    e1=3;
		if (e2==1||e2==(1+p/4)||e2==(1+p/2)||e2==(1+(3*p)/4))
		    e2=7;
		
		if (e1>p){e1%=p;}
		if (e2>p){e2%=p;}
		if (e1==1||e1==(1+p/4)||e1==(1+p/2)||e1==(1+(3*p)/4))
		    e1=3;
		if (e2==1||e2==(1+p/4)||e2==(1+p/2)||e2==(1+(3*p)/4))
		    e2=7;
		if ((e1-e2)<2&&e2==3){
		    e1=3;
		}
		else if ((e1-e2)<2){
		    e1=7;
		}
	    
	    } */
	    ctr=1;
	    for (int j=cStart;j<=cMax;j++){
		maze[rStart][j]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[rStart][j]=null;
		ctr++;

	    }
	    for (int i=rStart;i<=rMax;i++){
		maze[i][cMax]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[i][cMax]=null;
		ctr++;
	    }
	    for (int j=cMax;j>=cStart;j--){
		maze[rMax][j]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[rMax][j]=null;
		ctr++;
	    }
	    for (int i=rMax;i>rStart;i--){
		maze[i][cStart]=String.valueOf(ctr);
		if (ctr==e1||ctr==e2)
		    maze[i][cStart]=null;
		ctr++;
	    }
	    if(p==4){
		maze[rStart][cStart]=null;}
	    if (p>4){
		int c=0;
		if (maze[rStart][cStart]==null){
		    maze[rStart][cStart]="1";
		    maze[rStart][cStart+1]=null;
		    c++;
		}
		if (maze[rStart][cMax]==null){
		    maze[rStart][cMax]=""+(1+p/4);
		    maze[rStart+1][cMax]=null;
		    c++;
		}
		if (maze[rMax][cMax]==null){
		    c++;
		    maze[rMax][cMax]=""+(p/2+1);
		    maze[rMax][cMax-1]=null;
		}
		if (maze[rMax][cStart]==null){
		    c++;
		    maze[rMax][cStart]=""+(1+(3*p)/4);
		    maze[rMax-1][cStart]=null;
		}

	    }/*
	    if (p==20){
		System.out.println(p);
		maze[_r/2-2][_c/2-2]=null;
		System.out.println(maze[_r/2-2][_c/2]);
		}*/
	    if (level>1){
		//block(e1,e2);
	    }
	    pe1=e1;
	    pe2=e2;
	    rStart+=2;
	    cStart+=2;
	    cMax-=2;
	    rMax-=2;
	    p-=16;
	    level++;
	}
    }
    private void block(){
	
    }
    public String toString(){
	String str="";
	for (int i=0;i<_r;i++){
	    for (int j=0;j<_c;j++){
		if (maze[i][j]==null||maze[i][j].equals("  ")) 
		    str+="  ";
		else
		    str+="[]";
				   
		    //str+=maze[i][j]+" ";
	    }
	    str+="\n";
	}
	return str;
    }
    public static void main(String[] args){
	Radius Maze=new Radius(50);
	System.out.println(Maze);
    }
}
		    
