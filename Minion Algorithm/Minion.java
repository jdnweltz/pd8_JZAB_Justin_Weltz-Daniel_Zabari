public class Minion{
    private int r;
    private int c;
    private Maze m;
    private int rD;
    private int cD;
    private float p;
    private boolean planted=false;
    public Minion(int row, int col, Maze maze, int rDirection,int cDirection, float percentage){
	r=row;
	c=col;
	m=maze;
	rD=rDirection;
	cD=cDirection;
	p=percentage;
    }
    private char val(){return m[r][c];}
    private void act{


    }

    private void forward(){
	int d=(int)(Math.random()*4)+1;
	while (d>0){
	    r+=rD;
	    c+=cD;
    }