package WGraph;
import java.util.*;

public class Graph{
	
	private Node[] header;
	private int size;

	public Graph(int size) {
		this.header = new Node[size];
		this.size = size;

		for (int i = 0; i < size; i++) {
			this.header[i] = null;
		}
	}

	public void add(int i, int k) {
		Node temp = header[i];
		if (temp == null) {
			header[i] = new Node(k);
		} else {
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(new Node(k));
		}

		temp = header[k];
		if (temp == null) {
			header[k] = new Node(i);
		} else {
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(new Node(i));
		}
	}

	public void delete(int i, int k) {
		if (header[i] == null || header[k] == null) {
			System.out.println("This is fault delete");
			return;
		}

		if (header[i].getVertex() == k) {
			header[i] = header[i].getLink();
		} else {
			Node pre = header[i];
			Node cur = header[i].getLink();
			while (cur != null) {
				if (cur.getVertex() == k) {
					pre.setLink(cur.getLink());
					break;
				}
				pre = cur;
				cur = cur.getLink();
			}
		}

		if (header[k].getVertex() == i) {
			header[k] = header[k].getLink();
		} else {
			Node pre = header[k];
			Node cur = header[k].getLink();
			while (cur != null) {
				if (cur.getVertex() == i) {
					pre.setLink(cur.getLink());
					break;
				}
				pre = cur;
				cur = cur.getLink();
			}
		}

	}

	public void show() {
		if (this.size == 0) {
			System.out.println("No Vertex");
		}

		for (int i = 0; i < size; i++) {
			Node temp = header[i];

			System.out.print(i + " : ");

			while (temp != null) {
				System.out.print(temp.getVertex() + " ");
				temp = temp.getLink();
			}
			System.out.println();
		}
	}
	
	public void DFS(int i)
	{
		boolean[] visit = new boolean[header.length];
		int j;
		
		for(j = 0 ; j < header.length ; j++)
		{
			visit[j] = false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(i);
		
		while(!stack.isEmpty())
		{
			j = stack.pop();
			Node node = header[j];
			
			if(visit[j] == false)
			{
				System.out.print(j + " ");
				visit[j] = true;
				while(node != null)
				{
					if(visit[node.getVertex()] == false) 
						stack.push(node.getVertex());
					node = node.getLink();
				}
			}
		}
	}
	
	public void BFS(int i)
	{
		boolean[] visit = new boolean[header.length];
		int idx;
		
		for(int j = 0 ; j < header.length;j++)
		{
			visit[j] = false;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		while(!queue.isEmpty())
		{
			idx = queue.remove();
			Node node = header[idx];
			
			if(visit[idx] == false)
			{
				System.out.print(idx + " ");
				visit[idx] = true;
			}
			while(node != null)
			{
				if(visit[node.getVertex()] == false)
					queue.add(node.getVertex());
				node = node.getLink();
			}
		}
	}
	
	
}
