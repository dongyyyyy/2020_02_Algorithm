package week4;

public class BSTIntegerMain {
	public static void main(String args[])
	{
		BinarySearchTree t = new BinarySearchTree();
		t.BSTinsert(10);
		t.BSTinsert(5);
		t.BSTinsert(9);
		t.BSTinsert(11);
		t.BSTinsert(15);
		t.BSTinsert(14);
		t.BSTinsert(7);
		t.BSTinsert(3);
		t.BSTinsert(20);
		t.BSTinsert(22);
		t.BSTinsert(1);

		t.print();

		TreeNode n = t.BSTsearch(1);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}
		System.out.println("=======================1=====================");
		t.BSTdelete(1);

		n = t.BSTsearch(1);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();
		System.out.println("=======================11=====================");
		n = t.BSTsearch(11);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(11);

		n = t.BSTsearch(11);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=======================15=====================");

		n = t.BSTsearch(15);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(15);

		n = t.BSTsearch(15);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=======================9=====================");

		n = t.BSTsearch(9);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(9);

		n = t.BSTsearch(9);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=======================20=====================");

		n = t.BSTsearch(20);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(20);

		n = t.BSTsearch(20);
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("============================================");
	}
}
