package WGraph;

public class WGraph {
	
	private int vertex_size;
	private int e;
	private int[][] weights;
	
	public WGraph(int vertex_size)
	{
		this.weights = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;
		e = 0;
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
		if(weights[i][k] == 999 && weights[k][i] == 999)
		{
			weights[i][k] = w;
			weights[k][i] = w;
			e++;
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
	
	public Edge[] kruskal()
	{
		
		Edge[] T = new Edge[(vertex_size - 1)];
		MinHeap edgeList = new MinHeap();
		
		for(int i = 0 ; i < vertex_size ; i++)
		{
			for(int j = i+1; j < vertex_size; j++)
			{
				if(weights[i][j] != 999)
				{
					Edge item = new Edge(i,j,weights[i][j]);
					edgeList.insert(item);
				}
			}
		}
		
		UnionFind u = new UnionFind(vertex_size);
		int p = -1;
		
		while(p < vertex_size -2 && edgeList.numberElements() > 0)
		{
			Edge e = edgeList.delete(); // weight가 가장 작은 값을 제거
			if(!u.find(e.getStart(), e.getEnd())) // 제거한 값의 start와 end값을 가지는 값이 있는지 확인 없을 경우 제어문 진입
			{
				p++; // 추가
				T[p] = e; 
				u.union(e.getStart(), e.getEnd());
			}
		}
		
		return T;
	}
	
	public Edge[] prim(int i) { // Prim
        Edge[] T = new Edge[vertex_size-1];
        int Tptr = -1;

        MinHeap edgeList = new MinHeap();

        UnionFind uf = new UnionFind(vertex_size);

        for (int j = 0; j < vertex_size; j++) {
            if (weights[i][j] != 999)
                edgeList.insert(new Edge(i, j, weights[i][j]));
        } // for

        while (Tptr < vertex_size-2) {
            Edge edge = (Edge)(edgeList.delete());

            if (!uf.find(edge.getStart(), edge.getEnd())) {
                Tptr++;
                T[Tptr] = edge;

                uf.union(i, edge.getEnd());
                for (int j = 0; j < vertex_size; j++) {
                    if (weights[edge.getEnd()][j] != 999)
                        edgeList.insert(new Edge(edge.getEnd(), j, weights[edge.getEnd()][j]));
                } // for
            } //  if
        } // while
        return T;
    }
	
	
	
}

