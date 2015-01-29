package cracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class FindEachLayer {
		

	public static void main(String[] args) 
	{
		BinaryTree a=new BinaryTree(5);
		a.add(a, 2);
		a.add(a, 4);
		a.add(a, 1);
		a.add(a, 3);
		a.add(a, 6);
		a.add(a, 7);
		search(a,0);
	}
	public static void search(BinaryTree a, int layer)
	{
		ArrayList<LinkedList<BinaryTree>> r=new ArrayList<LinkedList<BinaryTree>>();
		LinkedList<BinaryTree> List=new LinkedList<BinaryTree>();
		List.add(a);
		r.add(layer, List);
		while(!List.isEmpty())
		{
			System.out.println("layer:"+layer);
			Iterator<BinaryTree> iter=List.iterator();
			while(iter.hasNext())
			{
				System.out.println(iter.next().num);
			}
			int size=r.get(layer).size();
			for(int i=1; i <= size;i++)
			{
				BinaryTree temp=List.pop();
				if(temp.left!=null)
				{
					List.add(temp.left);
				}
				if(temp.right!=null)
				{
					List.add(temp.right);
				}
			}
			r.add(layer++, List);
		}
	}

}
