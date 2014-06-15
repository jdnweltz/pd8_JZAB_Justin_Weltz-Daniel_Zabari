import java.util.*;
import java.io.*;
public class Backtrack{
    private Space[][] maze;
    private int _r;
    private int _c;
    private final String VISITED=".";
    private final String BACKTRACK="F";
    private final String HERO="@";
    public Backtrack(int r, int c){
	_r=r;
	_c=c;
	maze=new String[_r][_c];
    }
    
}
