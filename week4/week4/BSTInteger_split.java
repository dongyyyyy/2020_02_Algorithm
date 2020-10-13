package week4;

public class BSTInteger_split {
	public static void main(String args[])
	{
		BinarySearchTree aBST = new BinarySearchTree();
		
		System.out.println("[INFO] Insert ");
		
		aBST.insert(11);
		aBST.insert(9);
		aBST.insert(14);
		aBST.insert(22);
		aBST.insert(18);
		aBST.insert(16);
		aBST.insert(17);
		aBST.insert(15);
		
		System.out.println("===aBST print===");
		aBST.print();
		
		
		BinarySearchTree bBST = new BinarySearchTree();
		BinarySearchTree cBST = new BinarySearchTree();
		
		
		
		System.out.println("[INFO] Split 16");
		aBST.split(bBST,cBST,16);
		
		System.out.println("Left Tree");
		bBST.print();
		
		System.out.println("Right Tree");
		cBST.print();
		
		bBST = new BinarySearchTree();
		cBST = new BinarySearchTree();
		
		aBST = new BinarySearchTree();
		
		System.out.println("===aBST print===");
		
		aBST.insert(11);
		aBST.insert(9);
		aBST.insert(14);
		aBST.insert(22);
		aBST.insert(18);
		aBST.insert(16);
		aBST.insert(17);
		aBST.insert(15);
		
		aBST.print();
		
		System.out.println("[INFO] Split 19");
		aBST.split(bBST,cBST,19);
		
		System.out.println("Left Tree");
		bBST.print();
		
		System.out.println("Right Tree");
		cBST.print();
	}
}
