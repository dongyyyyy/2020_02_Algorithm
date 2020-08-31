package ArrayList;

public class ListTest {
	public static void main(String args[])
	{
		List ArrayList = new List();
		int i;
		for(i = 1; i <= 6; i++)
			ArrayList.addLast(i*10);

		ArrayList.showList();
		
		ArrayList.add(3,11);
		
		ArrayList.showList();
		
		ArrayList.delete(5);
		
		ArrayList.showList();
	}
}

