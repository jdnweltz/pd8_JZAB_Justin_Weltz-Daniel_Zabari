import java.util.*;
import java.io.*;
public class Radius{
    String[][] maze;
    int _r;
    int _c;
    int eR1;
    int eR2;
    int eC1;
    int eC2;
    int pER1;
    int pER2;
    int pEC1;
    int pEC2;
    public Radius(int r){
	maze=new String[r][r];
	_r=r;
	_c=r;
	populate();
    }
    
    private void populate(){
	int ctr=0;
	int rMax=_r-1;
	int cMax=_c-1;
	int rStart=0;
	int cStart=0;
	int p=_r*2+_c*2-4;
	int e1=0;
	int e2=0;
	int level=1;
	while (cMax>cStart&&rMax>rStart){
	    //System.out.println(level);
	    if ((int)(Math.random()*2)==0){
		if ((int)(Math.random()*2)==0){
		    eR1=rMax;
		}
		else{
		    eR1=rStart;
		}
		eC1=((int)(Math.random()*(cMax-cStart)))+cStart;
	    }
	    else{
		if ((int)(Math.random()*2)==0){
		    eC1=cMax;
		}
		else{
		    eC1=cStart;
		}
		eR1=((int)(Math.random()*(rMax-rStart)))+rStart;
	    }
	    if ((int)(Math.random()*2)==0){
		if ((int)(Math.random()*2)==0){
		    eR2=rMax;
		}
		else{
		    eR2=rStart;
		}
		eC2=((int)(Math.random()*(cMax-cStart)))+cStart;
	    }
	    else{
		if ((int)(Math.random()*2)==0){
		    eC2=cMax;
		}
		else{
		    eC2=cStart;
		}
		eR2=((int)(Math.random()*(rMax-rStart)))+rStart;
	    }
	    if (p>4){
		if (eR1==rMax&&(eC1==cMax||eC1==cStart))
		    eR1--;
		if (eR1==rStart&&(eC1==cMax||eC1==cStart))
		    eR1++;
		if (eR2==rMax&&(eC2==cMax||eC2==cStart))
		    eR2--;
		if (eR2==rStart&&(eC2==cMax||eC2==cStart))
		    eR2++;
		if (eC1==cMax&&(eR1==rMax||eR1==rStart))
		    eC1--;
		if (eC1==cStart&&(eR1==rMax||eR1==rStart))
		    eC1++;
		if (eC2==cMax&&(eR2==rMax||eR2==rStart))
		    eC2--;
		if (eC2==cStart&&(eR2==rMax||eR2==rStart))
		    eC2++;
	    }
		
		    
	    if (Math.abs(eR1-eR2)<2){
		if (eR1==rMax)
		    eR1=rStart;
		else if (eR2==rMax){
		    eR2=rStart;    
		}
		else if (eR1==rStart){
		    eR1=rMax;
		}
		else if (eR2==rStart){
		    eR2=rMax;
		}
	    }
	    if (Math.abs(eC1-eC2)<2){
		if (eC1==rMax)
		    eC1=rStart;
		else if (eC2==rMax){
		    eC2=rStart;    
		}
		else if (eC1==rStart){
		    eC1=rMax;
		}
		else if (eC2==rStart){
		    eC2=rMax;
		}
	    }
	    
		
	    //eR1=((int)(Math.random()*(rMax+1)))+rStart;
	    //eC1=((int)(Math.random()*(cMax+1)))+cStart;
	    //eR2=((int)(Math.random()*(rMax+1)))+rStart;
	    //eC2=((int)(Math.random()*(cMax+1)))+cStart;
	    
	    
	    //System.out.println(e1+","+e2);
	    /*
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
	    }*/
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
		maze[rStart][j]="0";
		ctr++;

	    }
	    for (int i=rStart;i<=rMax;i++){
		maze[i][cMax]=String.valueOf(ctr);
		maze[i][cMax]="0";
		ctr++;
	    }
	    for (int j=cMax;j>=cStart;j--){
		maze[rMax][j]=String.valueOf(ctr);
		maze[rMax][j]="0";
		ctr++;
	    }
	    for (int i=rMax;i>rStart;i--){
		maze[i][cStart]=String.valueOf(ctr);
		maze[i][cStart]="0";
		ctr++;
	    }/*
	    if(p==4){
	    maze[rStart][cStart]=null;}
	     */
	    if (level>1){
		if (p==4)
		    maze[eR1][eC1]="!";
		if (p>4){
		    maze[eR1][eC1]=null;
		    maze[eR2][eC2]=null;
		    block(rMax,rStart,cMax,cStart);
		}
	    }
	    if (level==1){
		maze[eR1][eC1]=null;
		maze[eR2][eC2]=null;
	    }
	    /*
	    if (p>4){
		int c=0;
		if (maze[rStart][cStart]==null){
		    maze[rStart][cStart]="0";
		    maze[rStart][cStart+1]=null;
		    c++;
		}
		if (maze[rStart][cMax]==null){
		    maze[rStart][cMax]="0";
		    maze[rStart+1][cMax]=null;
		    c++;
		}
		if (maze[rMax][cMax]==null){
		    c++;
		    maze[rMax][cMax]="0";
		    maze[rMax][cMax-1]=null;
		}
		if (maze[rMax][cStart]==null){
		    maze[rMax][cStart]="0";
		    maze[rMax-1][cStart]=null;
		}

	    }/*
	    if (p==20){
		System.out.println(p);
		maze[_r/2-2][_c/2-2]=null;
		System.out.println(maze[_r/2-2][_c/2]);
		}*/

	    System.out.println(eR1+","+eC1+"\n"+eR2+","+eC2);
	    pER1=eR1;
	    pER2=eR2;
	    pEC1=eC1;
	    pEC2=eC2;
	    rStart+=2;
	    cStart+=2;
	    cMax-=2;
	    rMax-=2;
	    p-=16;
	    level++;
	}
    }
    
    private void block(int rMax, int rStart, int cMax, int cStart){/*
	double d1=Math.sqrt(Math.pow((pEC1-eC1),2)+Math.pow((pER1-eR1),2));
	double d2=Math.sqrt(Math.pow((pEC2-eC1),2)+Math.pow((pER2-eR1),2));
	double d3=Math.sqrt(Math.pow((pEC1-eC2),2)+Math.pow((pER1-eR2),2));
	double d4=Math.sqrt(Math.pow((pEC2-eC2),2)+Math.pow((pER2-eR2),2));
	if (Math.min(Math.min(d1,d2),Math.min(d3,d4))==d1){
	    
	}
	}*/
	
	int c=0;
	int r=0;
	int c2=0;
	int r2=0;
	if (eR1==rMax&&eR2==rMax){
	    r=eR1-1;
	    r2=rStart+1;
	    c=c2=(Math.abs(eC1-eC2)/2)+cStart;
	}
	if (eR1==rStart&&eR2==rStart){
	    r=eR1+1;
	    r2=rMax-1;
	    c=c2=(Math.abs(eC1-eC2)/2)+cStart;
	}
	if (eC1==cMax&&eC2==cMax){
	    c=eC1-1;
	    c2=cStart+1;
	    r=r2=(Math.abs(eR1-eR2)/2)+rStart;
	}
	if (eC1==cStart&&eC2==cStart){
	    c=eC1+1;
	    c2=cMax-1;
	    r=r2=(Math.abs(eR1-eR2)/2)+rStart;
	}
	else if ((eC1==cStart&&eC2==cMax)||(eC1==cMax&&eC2==cStart)){
	    r=(int)(Math.random()*(rMax-rStart))+rStart;
	    r2=(int)(Math.random()*(rMax-rStart))+rStart;
	    c=cStart+1;
	    c2=cMax-1;
	}
	else if ((eR1==rStart&&eR2==rMax)||(eR1==rMax&&eR2==rStart)){
	    c=(int)(Math.random()*(cMax-cStart))+cStart;
	    c2=(int)(Math.random()*(cMax-cStart))+cStart;
	    r=rStart+1;
	    r2=rMax-1;
	}
	//else if ((eR1==rStart||eR1==rMax)
	
	maze[r][c]="0";
	maze[r2][c2]="0";
	    
	}
    public String toString(){
	String str="";
	for (int i=0;i<_r;i++){
	    for (int j=0;j<_c;j++){
		if (maze[i][j]==null||maze[i][j].equals("  ")) 
		    str+="  ";
		else if (maze[i][j].equals("!"))
		    str+="!!";
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
		    
