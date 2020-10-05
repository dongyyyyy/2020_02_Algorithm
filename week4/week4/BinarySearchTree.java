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
		else if(k instanceof String)
		{
			
			if(objectCompareToString(k,t.getKey()) < 0) // k < t
			{
				t.setLeft(insertKey(t.getLeft(),k));
				return t;
			}
			else if(objectCompareToString(k,t.getKey()) > 0) // k > t
			{
				t.setRight(insertKey(t.getRight(),k));
				return t;
			}
			else
			{
				return t;
			}
		}
		else if(k instanceof Integer)
		{
			if(objectCompareToInteger(k,t.getKey()) < 0 ) // k < t
			{
				t.setLeft(insertKey(t.getLeft(),k));
				return t;
			}
			else if(objectCompareToInteger(k,t.getKey()) > 0) // k > t
			{
				t.setRight(insertKey(t.getRight(),k));
				return t;
			}
			else
			{
				return t;
			}
		}
		else
		{
			System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
			return null;
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
			if(k instanceof String)
			{
				if(objectCompareToString(k,t.getKey())<0)
				{
					t = t.getLeft();
				}
				else if(objectCompareToString(k,t.getKey())>0)
				{
					t = t.getRight();
				}
				else
					return t;
			}
			else if(k instanceof Integer)
			{
				if(objectCompareToInteger(k,t.getKey())<0)
				{
					t = t.getLeft();
				}
				else if(objectCompareToInteger(k,t.getKey())>0)
				{
					t = t.getRight();
				}
				else
					return t;
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return null;
			}
		}
		return null;
	}
	
	public void BSTinsert(Object k)
	{
		TreeNode p = rootNode;
		TreeNode q = p;
		
		while(p != null)
		{
			if(k instanceof String)
			{
				if(objectCompareToString(k,p.getKey()) == 0)
					return;
				q = p;
				if(objectCompareToString(k,p.getKey()) < 0) // k < p 
					p = p.getLeft();
				else // k > p 
					p = p.getRight();
					
			}
			else if(k instanceof Integer)
			{
				if(objectCompareToInteger(k,p.getKey()) == 0)
					return;
				q = p;
				if(objectCompareToInteger(k,p.getKey()) < 0) // k < p 
					p = p.getLeft();
				else // k > p 
					p = p.getRight();
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return;
			}
		}
		TreeNode newNode = new TreeNode(k);;
		if(rootNode == null)
			rootNode = newNode;
		else
		{
			if(k instanceof String)
			{
				if(objectCompareToString(k,q.getKey()) < 0) // k < p 
					q.setLeft(newNode);
				else
					q.setRight(newNode);
			}
			else if(k instanceof Integer)
			{
				if(objectCompareToInteger(k,q.getKey()) < 0)
					q.setLeft(newNode);
				else
					q.setRight(newNode);
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return;
			}
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
	
	private int objectCompareToString(Object s1, Object s2) // Object의 변수 형태가 String인 경우
	{
		return ((String)s1).compareTo((String) s2); 
		// compareTo(A,B) -> A와 B를 비교했을 때 같은경우 0을 반환 , A가 더 큰 경우 1을 반환, B가 더 큰 경우 -1을 반환
	}
	
	private int objectCompareToInteger(Object s1, Object s2) // Objecd의 변수 형태가 int인 경우
	{
		if((int)s1 > (int)s2)
		{
			return 1;
		}
		else if((int)s1 < (int)s2)
		{
			return -1;
		}
		else 
			return 0;
	}
	
	private int objectCompareTo(Object s1, Object s2)
	{
		if(s1 instanceof String)
		{
			return ((String)s1).compareTo((String) s2);
		}
		else if (s1 instanceof Integer)
		{
			return ((Integer)s1).compareTo((Integer) s2);
		}
		else
		{
			System.out.println("문제있음");
			System.exit(1);
			return 0;
		}
	}
}
