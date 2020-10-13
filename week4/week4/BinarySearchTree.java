package week4;

public class BinarySearchTree {
	private TreeNode rootNode;
	
	private TreeNode insertKey(TreeNode t, Object k)
	{ // start insertKey method!
		if(t == null)
		{
			TreeNode newNode = new TreeNode();
			newNode.setKey(k);
			return newNode;
		}
		else {
			
			if(objectCompareTo(k,t.getKey()) < 0) // k < t
			{
				t.setLeft(insertKey(t.getLeft(),k));
				return t;
			}
			else if(objectCompareTo(k,t.getKey()) > 0) // k > t
			{
				t.setRight(insertKey(t.getRight(),k));
				return t;
			}
			else
			{
				return t;
			}
		}

	} // end insertKey method!
	
	public void insert(Object k) { // main에서 호출되는 insert method
		this.rootNode = insertKey(this.rootNode,k);
	}
	
	public TreeNode BSTsearch(Object k)
	{
		TreeNode t = rootNode;
		while(t != null)
		{

			if(objectCompareTo(k,t.getKey())<0)
			{
				t = t.getLeft();
			}
			else if(objectCompareTo(k,t.getKey())>0)
			{
				t = t.getRight();
			}
			else
				return t;
			
		}
		return null;
	}
	
	public void BSTinsert(Object k)
	{
		TreeNode p = rootNode;
		TreeNode q = p;
		
		while(p != null)
		{

			if(objectCompareTo(k,p.getKey()) == 0)
				return;
			q = p;
			if(objectCompareTo(k,p.getKey()) < 0) // k < p 
				p = p.getLeft();
			else // k > p 
				p = p.getRight();
		}
		TreeNode newNode = new TreeNode(k);;
		if(rootNode == null)
			rootNode = newNode;
		else
		{

			if(objectCompareTo(k,q.getKey()) < 0) // k < p 
				q.setLeft(newNode);
			else
				q.setRight(newNode);

		}
	}
	
	private TreeNode maxNode(TreeNode root)
	{
		TreeNode p = root;
		if(p.getRight() == null)
			return p;
		else
			return maxNode(p.getRight());
	}
	
	private TreeNode delete(TreeNode root, Object k)
	{
		TreeNode p = root;
		TreeNode q = p;
		while(p != null)
		{
			if(objectCompareTo(k,p.getKey()) == 0)
				break;
			q = p;
			if(objectCompareTo(k,p.getKey()) < 0) // k < p 
				p = p.getLeft();
			else // k > p 
				p = p.getRight();

		}
		
		if(p == null) // 아무것도 할 수 없는 경우
		{
			return root;
		}
		if((p.getLeft() == null) && (p.getRight() == null))
		{
			if(p == root)
			{
				root = null;
			}
			else if(q.getLeft() == p)
			{
				q.setLeft(null);
			}
			else
			{
				q.setRight(null);
			}
		}
		else if((p.getLeft() == null )|| (p.getRight() == null))
		{
			if(p == root)
			{
				if(root.getLeft() != null)
					root = p.getLeft();
				else
					root = p.getRight();
			}
			else if(p.getLeft() != null)
			{
				if(q.getLeft() == p)
					q.setLeft(p.getLeft());
				else
					q.setRight(p.getLeft());
			}
			else
			{
				if(q.getLeft() == p)
					q.setLeft(p.getRight());
				else
					q.setRight(p.getRight());
			}
		}
		else
		{
			TreeNode t  = maxNode(p.getLeft());
			p.setKey(t.getKey());
			p.setLeft(delete(p.getLeft(),t.getKey()));
		}
		return root;
	}
	
	public void BSTdelete(Object k)
	{
		rootNode = delete(rootNode,k);
	}
	
	public boolean split(BinarySearchTree bBST, BinarySearchTree cBST,Object x) { 
		// 해당 메소드에서 Small / Large / S / L / p 의 위치가 반복문을 통과할때마다 변화하는 것을 설명하시오.
		TreeNode Small = new TreeNode();
		TreeNode Large = new TreeNode();
		TreeNode S = Small;
		TreeNode L = Large;
		TreeNode p = this.rootNode;
		
		while(p != null) {
			if(objectCompareTo(x,p.getKey())==0) {//같은 값이 나오면
				S.setRight(p.getLeft());	//왼쪽 작은값을 스몰에 넣어준다
				L.setLeft(p.getRight());    //오른쪽 큰값을 라지에 넣어준다	
				
				bBST.setRootNode(Small.getRight());//이제 만들어진 트리를 넣어준다
				cBST.setRootNode(Large.getLeft());
				
				return true;
			}
			else if(objectCompareToInteger(x,p.getKey())<0) {		//찾는 값보다 더 크다면
				L.setLeft(p);				//라지의 포인터를 옮긴다
				L = p;					//더 작은값을 찾기 위함
				p = p.getLeft();
			}
			else {						//찾는 값보다 작다면
				S.setRight(p);			//스몰의 포인터를 옮긴다 // Small
				S = p;					// S = p
				p = p.getRight();
			}
			
		}
		S.setRight(null);
		L.setLeft(null);
		bBST.setRootNode(Small.getRight());
		cBST.setRootNode(Large.getLeft());
		return false;
	}
	
	
	
	private void printNode(TreeNode n)
	{
		if(n != null)
		{
			System.out.print("(");
			printNode(n.getLeft());
			System.out.print(" " + n.getKey() + " ");
			printNode(n.getRight());
			System.out.print(")");
		}
	}
	
	public void print()
	{
		printNode(rootNode);
		System.out.println();
	}
	
	
	public void setRootNode(TreeNode rootNode)
	{
		this.rootNode = rootNode;
	}
	public TreeNode getRootNode()
	{
		return this.rootNode;
	}
	
	private int objectCompareToString(Object s1, Object s2) // Object의 변수 형태가 String인 경우
	{
		return ((String)s1).compareTo((String) s2); 
		// compareTo(A,B) -> A와 B를 비교했을 때 같은경우 0을 반환 , A가 더 큰 경우 1을 반환, B가 더 큰 경우 -1을 반환
	}	
	private int objectCompareToInteger(Object s1, Object s2) // Objecd의 변수 형태가 int인 경우
	{
		return ((Integer)s1).compareTo((Integer) s2);
//		if((int)s1 > (int)s2)
//		{
//			return 1;
//		}
//		else if((int)s1 < (int)s2)
//		{
//			return -1;
//		}
//		else 
//			return 0;
	}
	
	private int objectCompareTo(Object s1, Object s2)
	{
		if ( s1 instanceof String)
		{
			return ((String)s1).compareTo((String) s2);
		}
		else if( s1 instanceof Integer)
		{
			return ((Integer)s1).compareTo((Integer) s2);
		}
		else
		{
			System.out.println("처리를 하고자 하는 객체 정보가 아닙니다.");
			System.exit(0);
			return -1;
		}
	}
}
