import java.io.*;
import java.util.*;
public class Driver{
    public static void main (String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Please pick the algorithm you wish to create your maze with:");
	System.out.println("Justin's algorithm: Type j");  
	System.out.println("Daniel's algorithm: Type d (optimal height, 70)");  
	System.out.println("Stack algorithm: Type s");  
	String s = sc.next();
	if(!(s.equals("j")||s.equals("d")||s.equals("s"))){
	    System.out.println("Enter what we say to! Try again.");
	    System.exit(0);
	}
	System.out.println("now input the height of your maze:");
	int h=70;
	try{
	     h = sc.nextInt();
	}catch (Exception e){
	    System.out.println("Please enter an int.");
	    System.exit(0);
	}
	if (s.equals("j")){
	    int w = 40;
	    System.out.println("now input the width of your maze:");
	    try{
		w = sc.nextInt();}
	    catch(Exception e){System.out.println("Please enter an int."); System.exit(0);}
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
	    System.out.println("When you are ready to see the solution, type in 'sol'");  
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
	    }else{System.out.println("No solution for you.");}
		
	    
	}
	else if (s.equals("d")){
	    System.out.println("If code runs successfully, your maze is in maze.txt and your solution is in mazeSolution.txt.");
	    	try{
	Radius r=new Radius(h);
	try{
	    FileWriter f = new FileWriter("mazeENT.txt");
	    f.write(r.toENTString());
	    f.close();
	    FileWriter g=new FileWriter("maze.txt");
	    g.write(g.toString());
	    g.close();
	}
	catch (Exception E){}
	
	MazeSolver2 ms=new MazeSolver2("mazeENT.txt",h,h);

	Scanner sa = new Scanner(new File("mazeENT.txt"));
	ms.solve(sa.nextInt(),sa.nextInt());
	boolean solved=ms.solv();
	for(int i=0;i<1000;i++){
	//while (!solved){
	    r=new Radius(h);
	    try{
		FileWriter f = new FileWriter("mazeENT.txt");
		f.write(r.toString());
		f.close();
	    }
	    catch (Exception E){}

	    sa = new Scanner(new File("mazeENT.txt"));
	    ms.solve(sa.nextInt(),sa.nextInt());
	    solved=ms.solv();
	    if (solved){
		System.out.println(r.toString());
		break;
	    }
	}
	if(!solved){
	    System.out.println("An error occured, please try again.");
	    }
	}
	catch(Exception e){}

	
	}
	else {
	    int w = 40;
	    System.out.println("now input the width of your maze:");
	    try{
		w = sc.nextInt();}
	    catch(Exception e){System.out.println("Please enter an int."); System.exit(0);}
	    MakeMaze JDawG= new MakeMaze(h,w);
	try {
	    FileWriter f = new FileWriter("maze.txt");
	    f.write(JDawG.toString());
	    f.close();
	}
	catch(Exception e){}
	System.out.println(JDawG);
	System.out.println("When you are ready to see the solution, type in 'sol'");  
	String sl = sc.next();
	//System.out.println("**************************");
	if (sl.equals("sol")){
	    System.out.println("**************************");
	    MazeSolverStack ms = new MazeSolverStack( "maze.txt",h,w );
	    ms.solve(1,3);
		System.out.println(ms);
		try {
		    FileWriter f = new FileWriter("mazeSolution.txt");
		    f.write(ms.toString());
		    f.close();
		}
		catch(Exception e){}
	}else{System.out.println("No solution for you.");}
	
	
	}
    }
}
	    
