package geeksForGeeks;

import java.util.LinkedList;

public class MaximumAllSubArray {

	public static void main(String[] args) {
		int[] arr={5,5,5,5,5,5,5,5};
		helper(arr, 3);
	}
	public static void helper(int[] arr, int k)
	{
		LinkedList<Integer> l=new LinkedList<Integer>();
		for(int i=0; i<k; i++)
		{
			if(l.isEmpty())
				l.add(arr[i]);
			int j=0; 
			while(j<l.size() && l.get(j)>arr[i])
				j++;
			while(j<l.size())
				l.remove(j);
			l.add(arr[i]);
		}
		
		for(int i=k; i<arr.length; i++)
		{
			System.out.println(l.peek());
			
			int leaving=arr[i-k];
			for(Integer integer: l)
				if(integer==leaving)
				{
					l.remove(integer);
					break;
				}
			
			int j=0;
			while(j<l.size() && l.get(j)>arr[i])
				j++;
			while(j<l.size())
				l.remove(j);
			l.add(arr[i]);
		}
		
		System.out.println(l.peek());
	}

}
