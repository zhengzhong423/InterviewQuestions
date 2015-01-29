package cracking;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class BinaryTree {
	public
		int num;
		BinaryTree parent=null;
		BinaryTree left=null;
		BinaryTree right=null;
		Queue<BinaryTree> q=new LinkedList<BinaryTree>();
		Stack<BinaryTree> s=new Stack<BinaryTree>();
		LinkedList<BinaryTree> path=new LinkedList<BinaryTree>();
		Set<BinaryTree> hash=new HashSet<BinaryTree>();
		
	public static void main(String[] args) 
	{
		BinaryTree a=new BinaryTree(5);
		a.add(a, 2);
		a.add(a, 4);
		a.add(a, 1);
		a.add(a, 3);
		a.add(a, 6);
		a.add(a, 7);
		a.DFS2(a, new LinkedList<BinaryTree>());
	//	a.BFS(a);
	//	System.out.println(a.layers(a));
	//	a.inOrder(a);
	//	a.preOrder(a);
		
	}
	public BinaryTree(int n)
	{
			this.num=n;
	}
	public BinaryTree() {
	}
	public void add(BinaryTree b, int num)
	{
		BinaryTree c=new BinaryTree(num);
		if(b.num>num)
		{
			// left child
			if(b.left!=null)
				b.add(b.left, num);
			else
				{
				b.left=c;
				b.left.parent=b;
				}
		}
		else
		{
			// right child
			if(b.right!=null)
				b.add(b.right, num);
			else
			{	b.right=c;
				b.right.parent=c;
			}
		}
	}
	public void inOrder(BinaryTree b)
	{
		if(b.left!=null)
			b.left.inOrder(b.left);
		System.out.println(b.num);
		if(b.right!=null)
			b.right.inOrder(b.right);
	}
	public void preOrder(BinaryTree b)
	{
		System.out.println(b.num);
		if(b.left!=null)
			b.left.preOrder(b.left);
		if(b.right!=null)
			b.right.preOrder(b.right);
	}
	public void BFS(BinaryTree b)
	{	
		q.add(b);
		while(!q.isEmpty())
		{
			if(q.peek().left!=null)
			{
				q.add(q.peek().left);
				q.peek().left.parent=q.peek();
			}
			if(q.peek().right!=null)
			{
				q.add(q.peek().right);
				q.peek().right.parent=q.peek();
			}
			System.out.println(q.remove().num);
		}
	}
	public int layers(BinaryTree b)
	{
		if(b==null)
			return 0;
		if(b.left==null && b.right==null)
		{
			return 1;
		}
		return 1+Math.max(b.layers(b.left), b.layers(b.right));
	}
	public void DFS2(BinaryTree b, LinkedList<BinaryTree> path)
	{
		if(b.left==null && b.right==null)
		{
			path.add(b);
			for(BinaryTree bt: path)
				System.out.print(bt.num);
			System.out.println();
		}
		if(b.left!=null)
		{
			LinkedList<BinaryTree> pathL=new LinkedList<BinaryTree>(path);
			pathL.add(b);
			DFS2(b.left, pathL);
		}
		if(b.right!=null)
		{
		LinkedList<BinaryTree> pathR=new LinkedList<BinaryTree>(path);
		pathR.add(b);
		DFS2(b.right, pathR);
		}
	}
	public void DFS(BinaryTree b)
	{
		s.push(b);
		hash.add(b);
		while(!s.isEmpty())
		{
			BinaryTree temp=s.peek();
			hash.add(temp);
			if(temp.left==null && temp.right==null)
			{
				path.add(temp);
				for(BinaryTree t:path)
					System.out.print(t.num);
				System.out.println();
				path.removeLast();
				s.pop();
				continue;
			}
			if((hash.contains(temp.left) && hash.contains(temp.right) )||( hash.contains(temp.left) && temp.right==null) || (hash.contains(temp.right) && temp.left==null))
			{
				s.pop();
				path.removeLast();
				continue;
			}
			path.add(temp);
			if(!hash.contains(temp.right) && temp.right!=null)
			{
				s.push(temp.right);
			}
			if(!hash.contains(temp.left) && temp.left!=null)
			{
				s.push(temp.left);
			}
		}
			
	}
}
