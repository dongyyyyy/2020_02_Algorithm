package week4;

public class TreeNode {
	private Object key;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode()
	{
		this.key = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(Object key)
	{
		this.left = null;
		this.key = key;
		this.right = null;
	}
	
	public TreeNode(TreeNode left, Object key, TreeNode right)
	{
		this.left = left;
		this.key = key;
		this.right = right;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	
	
}
