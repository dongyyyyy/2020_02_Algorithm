package WGraph;

public class MinHeap {
	
	private int nNode;
	private int maxSize;
	private Edge[] heap;
	
	public MinHeap()
	{
		this.nNode = 1;
		this.maxSize = 6;
		this.heap = new Edge[maxSize];
	}
	
	private void heapFull()
	{
		maxSize++;
		Edge[] temp = new Edge[maxSize];
		for(int i = 1 ; i < maxSize-1 ; i++)
		{
			temp[i] = heap[i];
		}
		heap = temp;
	}
	
	public void insert(Edge item)
	{
		int i;
		
		if(nNode == maxSize) heapFull();
		
		
		
		for(i=nNode;;)
		{
			if(i==1)break;
			if(item.compareTo(heap[i/2]) >= 0)break;
			heap[i] = heap[i/2];
			i = i/2;
		}
		heap[i] = item;
		nNode++;
	}
	
	public Edge delete()
	{
		if(nNode == 0) return null;
		
		Edge item = heap[1];
		Edge temp = heap[nNode-1];
		nNode--;
		
		int i = 1;
		int j = 2;
		
		while(j <= nNode)
		{
			if(j < nNode)
			{
				if(heap[j+1].compareTo(heap[j]) < 0) j++;
			}
			
			if(temp.compareTo(heap[j])<=0) break;
			
			heap[i] = heap[j];
			i = j;
			j = j * 2;
		}
		heap[i] = temp;
		heap[nNode] = null;
		return item;
	}
	
	public int numberElements()
	{
		return nNode;
	}
}


