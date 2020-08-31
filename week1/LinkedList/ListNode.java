package LinkedList;

public class ListNode {
	private Object data;
	private ListNode link;
	
	// Default ������
	public ListNode()
	{
		this.data = null;
		this.link = null;
	}
	
	// �Ű������� 1���� ������
	public ListNode(Object data)
	{
		this.data = data;
		this.link = null;
	}
	
	// �Ű������� 2���� ������
	public ListNode(Object data, ListNode link)
	{
		this.data = data;
		this.link = link;
	}
	
	// Getter Setter
	public Object getData()
	{
		return this.data;
	}
	
	public void setData(Object data)
	{
		this.data = data;
	}
	
	public ListNode getLink()
	{
		return this.link;
	}
	
	public void setLink(ListNode link)
	{
		this.link = link;
	}
	
}


