package cracking;

import java.util.LinkedList;
import java.util.ListIterator;

public class GraphSum {

	public static void main(String[] args)
	{
		BinaryTree a=new BinaryTree(5);
		a.add(a, 2);
		a.add(a, 4);
		a.add(a, 1);
		a.add(a, 3);
		a.add(a, 6);
		a.add(a, 7);
		GraphSum g=new GraphSum();
		g.FindSum(a,12);
	}
	public void FindSum(BinaryTree a, int sum)
	{
		if(a!=null)
		{
			LinkedList<Integer> result = new LinkedList<Integer>();
			StartSearch(a,sum,result);
			FindSum(a.left,sum);
			FindSum(a.right,sum);
		}
		else 
			return;
	}
	private void StartSearch(BinaryTree a, int sum, LinkedList<Integer> result1) 
	{
		if(a!=null)
		{
			
			if(sum==0)
			{
				ListIterator<Integer> iter=result1.listIterator();
				while(iter.hasNext())
				{
					System.out.print(iter.next()+"---->");
				}
				System.out.println("done");
			}
			result1.addFirst(a.num);
			StartSearch(a.left, sum-a.num, result1);
			StartSearch(a.right, sum-a.num, result1);
		}
		else
		{
				result1.pop();
		}
	}

}
