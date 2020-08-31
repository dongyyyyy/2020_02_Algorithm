package ArrayList;

public class List {
	private Object ArrayList[] = new Object[100];
	private int size = 0;
	
	public void addLast(Object data) 
	// List 마지막에 새로운 값 추가 ( 마지막에 추가되기 때문에 추가적인 index를 변경해주는 작업이 필요 없다. )
	{
		ArrayList[size] = data;
		size++;
	}
	
	public void add(int index, Object data)
	/* index 위치에 새로운 값을 추가하는 메소드
	 * 따라서 입력 index 이후의 인덱스의 값들의 위치를 재조정이 필요함 ( ArrayList의 단점 )
	 */
	{
		if(index > size)
		{
			System.out.println("List보다 큰 인덱스를 입력하여 추가할 수 없습니다.");
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
	 * 입력 인덱스의 값을 제거하는 메소드
	 */
	{
		if(index > size-1 || index < 0)//ArrayList크기보다 큰 경우 (삭제 불가) 또는 음수가 입력되었을 경우
		{
			System.out.println("잘못된 인덱스가 입력되었습니다.");
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
	// 리스트의 모든 값을 출력하는 메소드
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
