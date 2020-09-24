package BinaryTree;

public class BinaryTree {
	private TreeNode root = new TreeNode();

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(Object item) {
		this.root.setItem(item);
		this.root.setLeft(null);
		this.root.setRight(null);
	}

	public BinaryTree(BinaryTree left, Object item, BinaryTree right) {
		this.root.setItem(item);
		this.root.setLeft(left.root);
		this.root.setRight(right.root);
	}

	public boolean isEmpty() {
		if (this.root == null)
			return true;
		else
			return false;
	}

	public Object rootData() {
		if (this.isEmpty()) {
			System.out.println("Tree is Empty!!!");
			return null;
		} else
			return root.getItem();
	}

	public BinaryTree leftSubTree() {
		if (this.root.getLeft() == null) {
			return null;
		} else {
			BinaryTree left = new BinaryTree();
			left.root = this.root.getLeft();
			return left;
		}
	}

	public BinaryTree rightSubTree() {
		if (this.root.getRight() == null) {
			return null;
		} else {
			BinaryTree right = new BinaryTree();
			right.root = this.root.getRight();
			return right;
		}
	}

	public int calculate() {
		return theCalculate(this.root);
	}

	private int theCalculate(TreeNode p) {
		if (p.getLeft() == null && p.getRight() == null) {
			if (p.getItem() instanceof String) {
				return Integer.parseInt((String) p.getItem());
			} else if (p.getItem() instanceof Integer) {
				return (int) p.getItem();
			} else if (p.getItem() instanceof Character) {
				return (int) ((char) p.getItem() - '0');
			} else {
				return 0;
			}
		} else if (p.getItem().equals('+') || p.getItem().equals('-') || p.getItem().equals('*')
				|| p.getItem().equals('/')) {
			if (p.getItem().equals('+')) {
				return theCalculate(p.getLeft()) + theCalculate(p.getRight());
			} else if (p.getItem().equals('-')) {
				return theCalculate(p.getLeft()) - theCalculate(p.getRight());
			} else if (p.getItem().equals('*')) {
				return theCalculate(p.getLeft()) * theCalculate(p.getRight());
			} else {
				return theCalculate(p.getLeft()) / theCalculate(p.getRight());
			}
		} else {
			System.out.println("This Binary Tree is Fault!!!");
			return -1;
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void setRight(BinaryTree rigth) {
		this.root.setRight(rigth.root);

	}

	/* pre-order (전위) root-left-right */
	public void preOrder_recursion() {
		preOrder_recursion_methods(this.root);
	}

	private void preOrder_recursion_methods(TreeNode T) {
		if (T != null) {
			System.out.print(T.getItem() + " ");
			preOrder_recursion_methods(T.getLeft());
			preOrder_recursion_methods(T.getRight());
		}
	}

	/* in-order (중위) left-root-right */
	public void inOrder_recursion() {
		inOrder_recursion_methods(this.root);
	}

	private void inOrder_recursion_methods(TreeNode T) {
		if (T != null) {
			inOrder_recursion_methods(T.getLeft());
			System.out.print(T.getItem() + " ");
			inOrder_recursion_methods(T.getRight());
		}
	}

	/* post-order (후위) left-right-root */
	public void postOrder_recursion() {
		postOrder_recursion_methods(this.root);
	}

	private void postOrder_recursion_methods(TreeNode T) {
		if (T != null) {
			postOrder_recursion_methods(T.getLeft());
			postOrder_recursion_methods(T.getRight());
			System.out.print(T.getItem() + " ");
		}
	}

	public BinaryTree copy() {
		BinaryTree newTree = new BinaryTree();
		newTree.root = theCopy(root);
		return newTree;
	}

	private TreeNode theCopy(TreeNode t) {
		if (t == null)
			return null;
		else {
			TreeNode l = theCopy(t.getLeft());
			TreeNode r = theCopy(t.getRight());
			TreeNode newNode = new TreeNode(l, t.getItem(), r);
			return newNode;
		}
	}

	public boolean equals(BinaryTree tr) {
		return theEqual(this.root, tr.root);
	}

	private boolean theEqual(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		} else if (s != null && t != null) {
			if (s.getItem().equals(t.getItem())) {
				if (theEqual(s.getLeft(), t.getLeft())) {
					return theEqual(s.getRight(), t.getRight());
				} else
					return false;
			} else
				return false;
		} else {
			return false;
		}
	}

	public void show() {
		BinaryTree right = this.rightSubTree();
		BinaryTree left = this.leftSubTree();

		System.out.println("root item : " + this.rootData());
		if (left.getRoot().getLeft() == null)
			System.out.println("left item : " + left.getRoot().getItem());
		else
			return;
		if (right.getRoot().getRight() == null)
			System.out.println("right item : " + right.getRoot().getItem()); // this.rightSubTree().root.getItem();
		else
			return;
	}

}
