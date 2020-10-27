package Graph;

public class Vertext_graph_main {
	public static void main(String args[])
	{
		Vertex_graph graph = new Vertex_graph(7);
		
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(0, 3);
		graph.add(0, 4);
		
		graph.add(1, 4);
		
		graph.add(2, 4);
		graph.add(2, 5);
		
		graph.add(3, 5);
		
		graph.add(5, 6);
		
		System.out.println("Graph");
		graph.show();
		
		System.out.println("\n0-1 Delete");
		graph.delete(0, 1);
		graph.show();
	}
}


