package Graph;

public class Vertex_graph {
	private Node[] header;
	private int size;

	public Vertex_graph(int size) {
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
}
