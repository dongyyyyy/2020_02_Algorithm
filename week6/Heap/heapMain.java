package Heap;

public class heapMain {
	public static void main(String args[])
	{
		Heap h = new Heap();
		
		System.out.println("==Insert==");
		h.insert(18);
		h.insert(13);
		h.insert(5);
		h.insert(12);
		h.insert(8);
		h.insert(3);
		h.insert(19);
		h.show();
		
		System.out.println("===Delete===");
		h.delete();
		h.show();
		h.delete();
		h.show();
		
		System.out.println("===MakeHeap===");
		int[] tree = {0,20,40,50,70,30,100,80,10,90,60};
		
		Heap nh = new Heap(tree);
		
		nh.makeTreeHeap();
		nh.show();
	}
}
