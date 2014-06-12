public class Radius{
    char[][] maze;
    int _r;
    int _c;
    public Radius(int r, int c){
	maze=new char[r][c];
	r=_r;
	c=_c;
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
	    for (int i=rStart;i<=rMax;i++){
		for (int j=cStart;i<=cMax;j++)
		    