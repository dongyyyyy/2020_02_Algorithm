package ArrayList;

public class List {
	private Object ArrayList[] = new Object[100];
	private int size = 0;
	
	public void addLast(Object data) 
	// List �������� ���ο� �� �߰� ( �������� �߰��Ǳ� ������ �߰����� index�� �������ִ� �۾��� �ʿ� ����. )
	{
		ArrayList[size] = data;
		size++;
	}
	
	public void add(int index, Object data)
	/* index ��ġ�� ���ο� ���� �߰��ϴ� �޼ҵ�
	 * ���� �Է� index ������ �ε����� ������ ��ġ�� �������� �ʿ��� ( ArrayList�� ���� )
	 */
	{
		if(index > size)
		{
			System.out.println("List���� ū �ε����� �Է��Ͽ� �߰��� �� �����ϴ�.");
			return;
		}
		for(int i = size - 1 ; i >= index ; i--)
		{
			ArrayList[i+1] = ArrayList[i];
		}
		ArrayList[index] = data;
		size++;
	}
	
	public void delete(int index)
	/*
	 * �Է� �ε����� ���� �����ϴ� �޼ҵ�
	 */
	{
		if(index > size-1 || index < 0)//ArrayListũ�⺸�� ū ��� (���� �Ұ�) �Ǵ� ������ �ԷµǾ��� ���
		{
			System.out.println("�߸��� �ε����� �ԷµǾ����ϴ�.");
			return;
		}
		
		for(int i = index+1; i < size;i++)
		{
			ArrayList[i-1] = ArrayList[i];
		}
		ArrayList[size-1] = null;
		size--;
	}
	
	public void showList()
	// ����Ʈ�� ��� ���� ����ϴ� �޼ҵ�
	{
		int i;
		for(i=0;i<20;i++)
		{
			System.out.print("=");
		}
		System.out.println();
		
		for(i = 0 ; i < size ; i++)
		{
			System.out.println("Array List ["+i+"] : "+ArrayList[i]);
		}
		
		for(i=0;i<20;i++)
		{
			System.out.print("=");
		}
		System.out.println();
	}
}
