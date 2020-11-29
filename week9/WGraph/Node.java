package WGraph;

public class Node {
	
	private int vertex;
	private Node link;
	
	public Node(int vertex)
	{
		this.vertex = vertex;
		this.link = null;
	}
	
	public Node(int vertex, Node link)
	{
		this.vertex = vertex;
		this.link = link;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
}



