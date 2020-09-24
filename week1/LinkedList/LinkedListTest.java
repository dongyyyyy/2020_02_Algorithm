package LinkedList;

public class LinkedListTest {
	public static void main(String args[])
	{
		LinkedList list = new LinkedList();
		ListNode temp = new ListNode();
		
		for(int i = 0; i <= 6 ; i++)
		{
			list.addLastNode(Character.toString((char)(i+65)));
		}

		list.showList();
		
		temp = list.search("A"); // search methods
		list.insert(temp, "D");
		list.showList();
		
		list.delete("A");
		list.delete("G");
		list.showList();
		
		list.deleteLastNode();
		list.deleteLastNode();
		list.deleteLastNode();
		list.showList();
		
	}
}

