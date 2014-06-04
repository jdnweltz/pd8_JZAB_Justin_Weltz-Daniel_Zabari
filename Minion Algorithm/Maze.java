public class Maze{
    private char[][] arr;
    private int r;
    private int c;
    public Maze(int rows, int cols){
	r=rows;
	c=cols;
	arr=new char[r][c];
    }