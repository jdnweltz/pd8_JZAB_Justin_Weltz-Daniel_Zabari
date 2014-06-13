import java.io.*;
import java.util.*;
public class Driver{
    public static void main (String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Please pick the algorithm you wish to create your maze with:");
	System.out.println("Justin's algorithm: Type j");  
	System.out.println("Daniel's algorithm: Type d");  
	System.out.println("Stack algorithm: Type s");  
	String s = sc.next();
	System.out.println("now input the height of your maze:");
	int h = sc.nextInt();
	System.out.println("now input the width of your maze:");
	int w = sc.nextInt();
	if (s.equals("j")){
	    MazeBuilder JDawG = new MazeBuilder(h,w);
	    try {
		FileWriter f = new FileWriter("maze.txt");
		f.write(JDawG.toString());
	    f.close();
	    }
	    catch(Exception e){}

	    System.out.println("                          ");

	    System.out.println("**************************");
	    System.out.println(JDawG.toString());

	    System.out.println("                           ");
	    System.out.println("Whe you are ready to see the solution, type in 'sol'");  
	    String sl = sc.next();
	    //System.out.println("**************************");
	    if (sl.equals("sol")){
		System.out.println("**************************");
		MazeSolver ms = new MazeSolver( "maze.txt",h,w );
		ms.solve(1,3);
		System.out.println(ms);
		try {
		    FileWriter f = new FileWriter("mazeSolution.txt");
		    f.write(ms.toString());
		    f.close();
		}
		 catch(Exception e){}
	    }
		
	    
	}
    }
} 
	    
