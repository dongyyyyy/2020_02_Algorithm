package WGraph;
import java.util.*;

public class Graph_recursion {
	
	public static void main(String args[])
	{
		Graph graph = new Graph(7);
		
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(0, 3);
		graph.add(1, 4);
		graph.add(2, 4);
		graph.add(2, 5);
		graph.add(3, 5);
		graph.add(4, 6);
		graph.add(5, 6);
		
		graph.show();
		System.out.println("DFS");
		graph.DFS(0);
		System.out.println();
		System.out.println("BFS");
		graph.BFS(0);
	}
}


