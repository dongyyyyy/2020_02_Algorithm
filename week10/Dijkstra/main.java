package Dijkstra;

public class main {
	public static void main(String args[])
	{
		WGraph graph = new WGraph(5);
		
		graph.insertEdge(0,1,2);
		graph.insertEdge(0,2,5);
		graph.insertEdge(0,4,3);
		
		graph.insertEdge(1, 3, 4);
		graph.insertEdge(1, 4, 10);
		
		graph.insertEdge(2, 3, 6);
		graph.insertEdge(2, 4, 2);
		
		graph.insertEdge(4, 2, 1);
		graph.insertEdge(4, 3, 2);
		
		graph.print();
		
		graph.shortestPath(0);
	}
}

