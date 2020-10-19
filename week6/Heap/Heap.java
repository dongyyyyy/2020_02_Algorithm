package Heap;

public class Heap {
	private int nNode;
	private int maxSize;
	private int heap[];
	
	public Heap()
	{
		nNode = 0;
		maxSize = 0;
		heap = new int[maxSize];
	}
	
	public Heap(int[] tree)
	{
		nNode= tree.length;
		maxSize = tree.length;
		heap = tree;
	}
	
	private void heapFull(){
		maxSize++;
		int tempHeap[] = new int[maxSize];
		
		for(int i = 0 ; i < maxSize-1; i++)
		{
			tempHeap[i] = heap[i];
		}
		heap = tempHeap;
	}
	
	public void insert(int item)
	{
		if(nNode == maxSize) heapFull();
		
		int i;
		for(i=nNode;;) // 1. 해당 반복문에 대해서 설명하시오.
		{
			if(i == 0)
				break;
			if(item <= heap[(i-1)/2])
				break;
			heap[i] = heap[(i-1)/2];
			i = (i-1)/2;
		}
		heap[i] = item;
		
		nNode++;
	}
	
	public int delete()
	{
		if(nNode == 0) 
			return -1;
		
		int item = heap[0];
		int temp = heap[nNode-1];
		nNode--;
		int i = 0;
		int j = 1;
		while(j <= nNode)// 2. 해당 반복문에 대해서 설명하시오
		{
			if(j < nNode)
			{
				if(heap[j] < heap[j+1])
					j +=1;
			}
			if (temp >= heap[j])
				break;
			
			heap[i] = heap[j];
			i = j;
			j = j*2+1;
		}
		heap[i] = temp;
		maxSize--;
		return item;
	}
	
	public void makeTreeHeap()
	{
		int p,temp;
		for(int i = (nNode-1)/2 ; i >= 0 ; i--)
		{
			p = i;
			for(int j = 2 *p+1; j <= nNode; j = j*2+1)
			{
				if(j <nNode)
				{
					if(heap[j] < heap[j+1])
						j++;
					if(heap[p] >= heap[j])
						break;
					temp = heap[p];
					heap[p] = heap[j];
					heap[j] = temp;
					p = j;
				}
			}
		}
	}
	
	public void show()
	{
		for(int i = 0 ; i < maxSize; i++)
		{
			System.out.print(heap[i] + " | ");
		}
		System.out.println();
	}
}
