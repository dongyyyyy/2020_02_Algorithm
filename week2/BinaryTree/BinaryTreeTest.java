package BinaryTree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree root;
		BinaryTree LeftTemp;
		BinaryTree RightTemp;
		
		BinaryTree LeftSubroot;
		BinaryTree RightSubroot;
		
		BinaryTree empty = new BinaryTree();
		
		LeftTemp    = new BinaryTree("2");
		RightTemp   = new BinaryTree("3");
		
		LeftSubroot = new BinaryTree(LeftTemp,'+',RightTemp);
		
		LeftTemp    = new BinaryTree("2");
		
		RightTemp   = new BinaryTree(empty,"1",empty);
				
		RightSubroot = new BinaryTree(LeftTemp,'/',RightTemp);
		
		root = new BinaryTree(LeftSubroot,'*',RightSubroot);
		
		root.leftSubTree().getRoot().getLeft().setItem('-');
		root.getRoot().getLeft().getLeft().setLeft(new TreeNode("4"));
		root.getRoot().getLeft().getLeft().setRight(new TreeNode(1));
		System.out.println("calcul : "+root.calculate());
		System.out.println("=====root=====");
		root.show();
		
		System.out.println("=====root's right subTree=====");
		root.rightSubTree().show();
		System.out.println("aa : "+root.leftSubTree().leftSubTree().getRoot().getLeft().getItem());
	
		
		System.out.println("=====root's left subTree=====");
		root.leftSubTree().show();
		
		
		System.out.println("[INFO] 순환 중위 순회(inorder) ");
		root.inOrder_recursion();
		System.out.println("\n[INFO] 순환 전위 순회(preorder) ");
		root.preOrder_recursion();
		System.out.println("\n[INFO] 순환 후위 순회(postorder) ");
		root.postOrder_recursion();
		
		
	}

}


