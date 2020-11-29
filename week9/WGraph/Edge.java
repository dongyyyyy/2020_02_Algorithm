package WGraph;

public class Edge {
	
	private int start,end,weight;
	
	public Edge(int start,int end,int weight)
	{
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge value)
	{
		return this.weight - value.weight;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}


