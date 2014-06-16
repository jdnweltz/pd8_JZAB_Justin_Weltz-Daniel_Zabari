/*This Driver file uses a brute force to ensure that the maze is solvable.*/
import java.io.*;
import java.util.*;
public class Driver2{
    public static void main(String[] args){
	try{
	Radius r=new Radius(70);
	try{
	    FileWriter f = new FileWriter("mazeENT.txt");
	    f.write(r.toENTString());
	    f.close();
	    FileWriter g=new FileWriter("maze.txt");
	    g.write(g.toString());
	    g.close();
	}
	catch (Exception E){}
	
	MazeSolver2 ms=new MazeSolver2("mazeENT.txt",70,70);

	Scanner sc = new Scanner(new File("mazeENT.txt"));
	ms.solve(sc.nextInt(),sc.nextInt());
	boolean solved=ms.solv();
	for(int i=0;i<1000;i++){
	//while (!solved){
	    r=new Radius(50);
	    try{
		FileWriter f = new FileWriter("mazeENT.txt");
		f.write(r.toString());
		f.close();
	    }
	    catch (Exception E){}

	    sc = new Scanner(new File("mazeENT.txt"));
	    ms.solve(sc.nextInt(),sc.nextInt());
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
}
	    
