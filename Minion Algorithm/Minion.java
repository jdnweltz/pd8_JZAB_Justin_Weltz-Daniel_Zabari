public class Minion{
    private int r;
    private int c;
    private Maze m;
    public Minion(int row, int col, Maze maze){
	r=row;
	c=col;
	m=maze;
    }
    private char val(){return m[r][c];}
    private void act{


    }

    private void forward(){
	int d=(int)(Math.random()*4)+1;
	