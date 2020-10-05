package week4;

public class BSTMain {
	public static void main(String args[]) {
		BinarySearchTree t = new BinarySearchTree();
		t.BSTinsert("S");
		t.BSTinsert("J");
		t.BSTinsert("B");
		t.BSTinsert("D");
		t.BSTinsert("U");
		t.BSTinsert("M");
		t.BSTinsert("R");
		t.BSTinsert("Q");
		t.BSTinsert("A");
		t.BSTinsert("G");
		t.BSTinsert("E");

		t.print();
		System.out.println("=======================R=====================");
		TreeNode n = t.BSTsearch("R");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("R");

		n = t.BSTsearch("R");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();
		System.out.println("=======================E=====================");
		n = t.BSTsearch("E");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("E");

		n = t.BSTsearch("E");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=======================J=====================");

		n = t.BSTsearch("J");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("J");

		n = t.BSTsearch("J");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=======================S=====================");

		n = t.BSTsearch("S");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("S");

		n = t.BSTsearch("S");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=======================B=====================");

		n = t.BSTsearch("B");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("B");

		n = t.BSTsearch("B");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();
	}
}
