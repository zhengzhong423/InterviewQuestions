package cracking;

import java.util.LinkedList;
import java.util.Queue;
public class FindRoute {
	Queue<BinaryTree> q=new LinkedList<BinaryTree>();	
	public static void main(String[] args) {
		BinaryTree a=new BinaryTree(5);
		a.add(a, 2);
		a.add(a, 4);
		a.add(a, 1);
		a.add(a, 3);
		a.add(a, 6);
		a.add(a, 7);
		System.out.println(FindWay(a,2,1));
	}
	public static boolean FindWay(BinaryTree a,int num1, int num2)
	{
		BinaryTree temp=BFS(a,num1);
		if(temp!=null)
		{
			temp=BFS(temp,num2);
			if(temp!=null)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public static BinaryTree BFS(BinaryTree a, int num1)
	{
		Queue<BinaryTree> q=new LinkedList<BinaryTree>();
		q.add(a);
		while(!q.isEmpty())
		{
			if(q.peek().num==num1)
				return q.peek();
			if(q.peek().left!=null)
				q.add(q.peek().left);
			if(q.peek().right!=null)
				q.add(q.peek().right);
			q.remove();
		}
		return null;
	}
}
