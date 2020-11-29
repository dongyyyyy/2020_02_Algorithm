package WGraph;

public class UnionFind {
	
	int[] parent;
	
	public UnionFind(int n)
	{
		parent = new int[n];
		for(int i = 0 ; i < n ; i++) 
			parent[i] = i;
	}
	
	private int root(int i)
	{
		while( i != parent[i]) 
		{
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		return i;
	}
	
	public boolean find(int p , int q)
	{
		return root(p) == root(q);
	}
	

	public void union(int p , int q)
	{
		int i = root(p);
		int j = root(q);
		parent[i] = j;
	}
}

