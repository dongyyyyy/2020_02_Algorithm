package LinkedList;

public class LinkedList {
private ListNode head;
	
	public void addLastNode(Object data) // (1) 마지막 위치에 노드를 연결하는 메소드
	{
		ListNode newNode = new ListNode(); // 추가할 새로운 노드
		
		newNode.setData(data); // private 변수이기 때문에 setter를 통해 변수 접근
		newNode.setLink(null); // 마지막 노드이기 때문에 다음 노드의 위치를 가르키지 않음 null = 끝을 알림
		
		if(head == null) // 비어있는 LinkedList인 경우
		{
			head = newNode;
			return;
		}
		
		ListNode temp = head;
		while(temp.getLink() != null) // 마지막 노드까지 이동
		{
			temp = temp.getLink(); // 다음 노드로 이동 ( 마지막 노드 도착전까지 해당 제어문 동작 )
		}
		temp.setLink(newNode); // 기존에 있었던 마지막 노드에 새로운 노드를 연결 setLink는 ListNode를 가르키기 때문
	}
	
	public void deleteLastNode() // (2) 마지막 노드를 제거하는 메소드
	{
		ListNode preNode, curNode; // 이전 노드와 현재 노드를 기억해야 현재 노드에 도착 시 이전 노드의 Link를 null로 수정할 수 있다.
		
		if(head == null) // 해당 List가 비어있는 경우
		{
			System.out.println("LinkedList가 비어있습니다.");
			return;
		}
		if(head.getLink() == null)  // 하나의 노드만 있는 경우 List를 비운다.
		{
			head = null;
			return;
		}
		
		preNode = head; 
		curNode = head.getLink();
		while(curNode.getLink() != null) // 마지막 노드까지 이동하는 제어문
		{
			preNode = curNode; // 이전 노드의 값을 저장
			curNode = curNode.getLink(); // 현재 노드의 값을 저장
		}
		preNode.setLink(null); // 마지막 노드에 도착하면 이전 노드의 Link null로 함으로써 마지막 노드 제거
	}
	
	public void delete(Object data) // (3)원하는 데이터 제거하는 메소드
	{
		ListNode preNode, curNode;
		
		if(head == null) 
		{
			System.out.println("LinkedList가 비어있습니다.");
			return;
		}
		
		preNode = head;
		curNode = head.getLink();
		if(data.equals(preNode.getData())) // 처음 노드가 지우려고 하는 대상인 경우
		{
			head = curNode; // 시작 노드를 다음 노드로 설정
			preNode.setLink(null); // 이전 노드 제거
			return;
		}
		
		while(curNode !=null) // 마지막 노드까지 이동 하는 반복문
		{
			if(data.equals(curNode.getData())) // 현재 노드와 입력 값과 비교
			{
				if(curNode.getLink() == null)  //마지막 노드일 경우 해당 노드만 제거
				{
					preNode.setLink(null); 
				} 
				else // 마지막 노드가 아닌 중간에 있는 노드일 경우
				{
					preNode.setLink(curNode.getLink()); // 이전 노드를 현재 노드의 Link로 연결
					curNode.setLink(null); // 현재 노드 제거
				}
				return;
			}
			// 노드 이동
			preNode = curNode; 
			curNode = curNode.getLink();
		}
		System.out.println("삭제할 노드가 존재하지 않습니다.");
	}
	
	public ListNode search(Object data) // (4) 노드를 검색하는 메소드
	{
		ListNode temp = head;
		
		while(temp != null) // 마지막 노드까지 이동하는 반복문
		{
			if(data.equals(temp.getData())) // 노드를 찾은 경우 해당 노드값 반환
			{
				return temp;
			}
			temp = temp.getLink(); // 다음 노드로 이동
		}
		
		System.out.println("해당 data가 List에 존재하지 않습니다.");
		return null;
	}
	
	public void insert(ListNode preNode, Object data) // (5) 노드를 중간에 삽입하는 메소드
	{
		ListNode newNode = new ListNode(data); // 삽입할 노드 생성
		
		if(head == null) // 리스트가 비어 있는 경우
		{
			System.out.println("List가 비어있습니다.");
			return;
		}
		else if(preNode == null) // 위치 값을 넣지 않은 경우
		{
			System.out.println("삽입하기 전 노드의 값을 확인할 수 없습니다.");
			return;
		}
		
		newNode.setLink(preNode.getLink()); // 이전 노드의 링크를 추가하는 노드의 링크로 연결
		preNode.setLink(newNode); // 이전 노드의 링크는 추가하는 노드를 가르키도록 설정
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
