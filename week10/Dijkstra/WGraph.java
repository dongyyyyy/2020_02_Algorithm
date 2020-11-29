package Dijkstra;


public class WGraph {
	
	private int vertex_size;
	private int[][] weights;
	
	public WGraph(int vertex_size)
	{
		this.weights = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;
		for(int i = 0 ; i < this.vertex_size ; i++)
		{
			for(int j = 0 ; j < this.vertex_size ; j++)
			{
				if(i==j) weights[i][j] = 0;
				else weights[i][j] = 999;
			}
		}
	}
	
	public void insertEdge(int i, int k , int w)
	{
		if(weights[i][k] == 999)
		{
			weights[i][k] = w;
		}
	}
	
	public void print()
	{
		for(int i = 0 ; i < vertex_size; i++)
		{
			for(int j = 0 ; j < vertex_size; j++)
			{
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public void shortestPath(int v)
	{
		boolean[] s = new boolean[vertex_size];
		int[] dist = new int[vertex_size];
		
		for(int i = 0 ; i < vertex_size; i++)
		{
			s[i] = false;
			dist[i] = weights[v][i];
		}
		
		s[v] = true;
		dist[v] = 0;
		
		for(int i = 0  ; i < vertex_size-2; i++)
		{
			int maximum = Integer.MAX_VALUE;
			int u = -1;
			for(int j = 0 ; j < vertex_size ; j++)
			{
				if(s[j] == false && dist[j] < maximum && dist[j] > 0)
				{
					maximum = dist[j];
					u = j;
					dist[u] = dist[j];
					//s[u] = true;
				}
			}
			s[u] = true;
			for(int w = 0 ; w < vertex_size ; w++)
			{
				if(dist[w] > dist[u]+weights[u][w])
				{
					
					dist[w] = dist[u]+weights[u][w];
				}
			}
			System.out.printf("===== STAGE %d =====", (i+1));
			System.out.println("\nselect vertex : " + u);
			
			for(int k = 0 ; k < vertex_size ; k++)
			{
				System.out.print(dist[k]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
}

