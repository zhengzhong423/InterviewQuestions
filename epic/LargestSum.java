package epic;

import java.util.ArrayList;

public class LargestSum {

	public static void main(String[] args) {
		LargestSum l=new LargestSum();
		System.out.println(l.helper(new int[] {-1,-2}));
	}
	public ArrayList<Integer> helper(int[] num)
	{
		int pivot=num[0];
		int max=Integer.MIN_VALUE;
		ArrayList<Integer> temp=new ArrayList<Integer>();
		ArrayList<Integer> rs=new ArrayList<Integer>();
		for(int i=1; i<num.length; i++)
		{
			if(pivot+num[i]>num[i]+num[i-1])
				temp.add(num[i]);
			else
			{
				temp.clear();
				temp.add(num[i-1]);
				temp.add(num[i]);
			}
			pivot=Math.max(num[i]+num[i-1], pivot+num[i]);
			if(max<pivot)
			{
				rs.clear();
				rs.addAll(temp);
			}
			max=Math.max(pivot, max);
		}
		return rs;
	}
}
