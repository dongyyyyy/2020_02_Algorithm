package LinkedList;

public class LinkedList {
private ListNode head;
	
	public void addLastNode(Object data) // (1) ������ ��ġ�� ��带 �����ϴ� �޼ҵ�
	{
		ListNode newNode = new ListNode(); // �߰��� ���ο� ���
		
		newNode.setData(data); // private �����̱� ������ setter�� ���� ���� ����
		newNode.setLink(null); // ������ ����̱� ������ ���� ����� ��ġ�� ����Ű�� ���� null = ���� �˸�
		
		if(head == null) // ����ִ� LinkedList�� ���
		{
			head = newNode;
			return;
		}
		
		ListNode temp = head;
		while(temp.getLink() != null) // ������ ������ �̵�
		{
			temp = temp.getLink(); // ���� ���� �̵� ( ������ ��� ���������� �ش� ��� ���� )
		}
		temp.setLink(newNode); // ������ �־��� ������ ��忡 ���ο� ��带 ���� setLink�� ListNode�� ����Ű�� ����
	}
	
	public void deleteLastNode() // (2) ������ ��带 �����ϴ� �޼ҵ�
	{
		ListNode preNode, curNode; // ���� ���� ���� ��带 ����ؾ� ���� ��忡 ���� �� ���� ����� Link�� null�� ������ �� �ִ�.
		
		if(head == null) // �ش� List�� ����ִ� ���
		{
			System.out.println("LinkedList�� ����ֽ��ϴ�.");
			return;
		}
		if(head.getLink() == null)  // �ϳ��� ��常 �ִ� ��� List�� ����.
		{
			head = null;
			return;
		}
		
		preNode = head; 
		curNode = head.getLink();
		while(curNode.getLink() != null) // ������ ������ �̵��ϴ� ���
		{
			preNode = curNode; // ���� ����� ���� ����
			curNode = curNode.getLink(); // ���� ����� ���� ����
		}
		preNode.setLink(null); // ������ ��忡 �����ϸ� ���� ����� Link null�� �����ν� ������ ��� ����
	}
	
	public void delete(Object data) // (3)���ϴ� ������ �����ϴ� �޼ҵ�
	{
		ListNode preNode, curNode;
		
		if(head == null) 
		{
			System.out.println("LinkedList�� ����ֽ��ϴ�.");
			return;
		}
		
		preNode = head;
		curNode = head.getLink();
		if(data.equals(preNode.getData())) // ó�� ��尡 ������� �ϴ� ����� ���
		{
			head = curNode; // ���� ��带 ���� ���� ����
			preNode.setLink(null); // ���� ��� ����
			return;
		}
		
		while(curNode !=null) // ������ ������ �̵� �ϴ� �ݺ���
		{
			if(data.equals(curNode.getData())) // ���� ���� �Է� ���� ��
			{
				if(curNode.getLink() == null)  //������ ����� ��� �ش� ��常 ����
				{
					preNode.setLink(null); 
				} 
				else // ������ ��尡 �ƴ� �߰��� �ִ� ����� ���
				{
					preNode.setLink(curNode.getLink()); // ���� ��带 ���� ����� Link�� ����
					curNode.setLink(null); // ���� ��� ����
				}
				return;
			}
			// ��� �̵�
			preNode = curNode; 
			curNode = curNode.getLink();
		}
		System.out.println("������ ��尡 �������� �ʽ��ϴ�.");
	}
	
	public ListNode search(Object data) // (4) ��带 �˻��ϴ� �޼ҵ�
	{
		ListNode temp = head;
		
		while(temp != null) // ������ ������ �̵��ϴ� �ݺ���
		{
			if(data.equals(temp.getData())) // ��带 ã�� ��� �ش� ��尪 ��ȯ
			{
				return temp;
			}
			temp = temp.getLink(); // ���� ���� �̵�
		}
		
		System.out.println("�ش� data�� List�� �������� �ʽ��ϴ�.");
		return null;
	}
	
	public void insert(ListNode preNode, Object data) // (5) ��带 �߰��� �����ϴ� �޼ҵ�
	{
		ListNode newNode = new ListNode(data); // ������ ��� ����
		
		if(head == null) // ����Ʈ�� ��� �ִ� ���
		{
			System.out.println("List�� ����ֽ��ϴ�.");
			return;
		}
		else if(preNode == null) // ��ġ ���� ���� ���� ���
		{
			System.out.println("�����ϱ� �� ����� ���� Ȯ���� �� �����ϴ�.");
			return;
		}
		
		newNode.setLink(preNode.getLink()); // ���� ����� ��ũ�� �߰��ϴ� ����� ��ũ�� ����
		preNode.setLink(newNode); // ���� ����� ��ũ�� �߰��ϴ� ��带 ����Ű���� ����
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
