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
			System.out.println("LinkedList�� ����ֽ��ϴ�.");
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
			System.out.println("LinkedList�� ����ֽ��ϴ�.");
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
		System.out.println("������ ��尡 �������� �ʽ��ϴ�.");
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
		
		System.out.println("�ش� data�� List�� �������� �ʽ��ϴ�.");
		return null;
	}
	
	public void insert(ListNode preNode, Object data) // (5)
	{
		ListNode newNode = new ListNode(data);
		
		if(head == null)
		{
			System.out.println("List�� ����ֽ��ϴ�.");
			return;
		}
		else if(preNode == null)
		{
			System.out.println("�����ϱ� �� ����� ���� Ȯ���� �� �����ϴ�.");
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
			System.out.println("List�� ����ֽ��ϴ�.");
			return;
		}
		ListNode temp = head;
		
		System.out.println("List show ����");
		
		while(temp != null)
		{
			System.out.println("List ["+ (i++) +"] : "+ temp.getData());
			temp = temp.getLink();
		}
		
		System.out.println("List show ����");
	}
}
