package chapter8_recursive;

import java.util.LinkedList;

public class EightQuene {

	public static void main(String[] args) {
		LinkedList<Integer> current=new LinkedList<Integer>();
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		getEightQuene(0, result, current);
		System.out.println(result.size());
	}
	public static void getEightQuene(int num, LinkedList<LinkedList<Integer>> result, LinkedList<Integer> current)
	{
		if(num==8)
		{
			LinkedList<Integer> temp=new LinkedList<Integer>();
			temp.addAll(current);
			result.add(temp);
			return;
		}
		for(int i=0; i<=7; i++)
		{
			if(checkValid(i, current))
			{
				current.add(i);
				getEightQuene(num+1, result, current);
				current.removeLast();
			}
		}	
	}
	private static boolean checkValid(int pos, LinkedList<Integer> current) 
	{
			if(current.isEmpty())
				return true;
			else
			{
				for(int i=0; i<=current.size()-1; i++)
				{
					if(current.get(i)==pos)
						return false;
					if(current.get(i)>pos)
						if(current.get(i)-pos==current.size()-i)
							return false;
					if(current.get(i)<pos)
						if(pos-current.get(i)==current.size()-i)
							return false;
				}
			}
		return true;
	}
}
