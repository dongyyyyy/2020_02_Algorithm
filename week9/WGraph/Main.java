package WGraph;

public class Main {
	public static void main(String args[])
	{
		WGraph graph = new WGraph(6);
		
//		graph.insertEdge(0, 1, 5);
//		graph.insertEdge(0, 2, 4);
//		graph.insertEdge(1, 2, 2);
//		graph.insertEdge(1, 3, 7);
//		graph.insertEdge(2, 3, 6);
//		graph.insertEdge(2, 4, 9);
//		graph.insertEdge(3, 4, 3);
//		graph.insertEdge(3, 5, 8);
//		graph.insertEdge(4, 5, 8);
		graph.insertEdge(0, 1, 4);
		graph.insertEdge(0, 2, 4);
		graph.insertEdge(1, 2, 4);
		graph.insertEdge(2, 3, 6);
		graph.insertEdge(3, 5, 6);
		
		System.out.println("Print Graph");
		graph.print();
		
//		System.out.println("\nKruskal (start - weight - end)");
//		Edge[] kruskal = graph.kruskal();
//		for(int i = 0 ; i < kruskal.length; i++)
//		{
//			System.out.printf("(%d-%d-%d) ",kruskal[i].getStart(),kruskal[i].getWeight(),kruskal[i].getEnd());
//			
//		}
		
		System.out.println("\nPrim (start - weight - end)");
		Edge[] prim = graph.prim(0);
		System.out.println(prim.length);
		for(int i = 0 ; i < prim.length; i++)
		{
			System.out.printf("(%d-%d-%d) ",prim[i].getStart(),prim[i].getWeight(),prim[i].getEnd());
			
		}
		
	}
}

