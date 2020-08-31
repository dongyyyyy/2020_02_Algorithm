package LinkedList;

public class LinkedList {
private ListNode head;
	
	public void addLastNode(Object data) // (1)
	{
		ListNode newNode = new ListNode();
		
		newNode.setData(data);
		newNode.setLink(null); // 
		
		if(head == null)
		{
			head = newNode;
			return;
		}
		
		ListNode temp = head;
		while(temp.getLink() != null)
		{
			temp = temp.getLink();
		}
		temp.setLink(newNode);
	}
	
	public void deleteLastNode() // (2)
	{
		ListNode preNode, curNode;
		
		if(head == null)
		{
			System.out.println("LinkedList가 비어있습니다.");
			return;
		}
		if(head.getLink() == null) 
		{
			head = null;
			return;
		}
		
		preNode = head;
		curNode = head.getLink();
		while(curNode.getLink() != null)
		{
			preNode = curNode;
			curNode = curNode.getLink();
		}
		preNode.setLink(null);
	}
	
	public void delete(Object data) // (3)
	{
		ListNode preNode, curNode;
		
		if(head == null)
		{
			System.out.println("LinkedList가 비어있습니다.");
			return;
		}
		if(head.getLink() == null)
		{
			head = null;
			return;
		}
		preNode = head;
		curNode = head.getLink();
		if(data.equals(preNode.getData()))
		{
			head = curNode;
			preNode.setLink(null);
			return;
		}
		
		while(curNode !=null)
		{
			if(data.equals(curNode.getData()))
			{
				if(curNode.getLink() == null) 
				{
					preNode.setLink(null); 
				}
				else 
				{
					preNode.setLink(curNode.getLink()); 
					curNode.setLink(null);
				}
				return;
			}
			preNode = curNode;
			curNode = curNode.getLink();
		}
		System.out.println("삭제할 노드가 존재하지 않습니다.");
	}
	
	public ListNode search(Object data) // (4)
	{
		ListNode temp = head;
		
		while(temp != null)
		{
			if(data.equals(temp.getData()))
			{
				return temp;
			}
			temp = temp.getLink();
		}
		
		System.out.println("해당 data가 List에 존재하지 않습니다.");
		return null;
	}
	
	public void insert(ListNode preNode, Object data) // (5)
	{
		ListNode newNode = new ListNode(data);
		
		if(head == null)
		{
			System.out.println("List가 비어있습니다.");
			return;
		}
		else if(preNode == null)
		{
			System.out.println("삽입하기 전 노드의 값을 확인할 수 없습니다.");
			return;
		}
		
		newNode.setLink(preNode.getLink());
		preNode.setLink(newNode);
	}
	
	public void showList()
	{
		int i=0;
		if(head == null)
		{
			System.out.println("List가 비어있습니다.");
			return;
		}
		ListNode temp = head;
		
		System.out.println("List show 시작");
		
		while(temp != null)
		{
			System.out.println("List ["+ (i++) +"] : "+ temp.getData());
			temp = temp.getLink();
		}
		
		System.out.println("List show 종료");
	}
}
