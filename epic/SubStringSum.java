package epic;

import java.util.LinkedList;
import java.util.List;

public class SubStringSum {
	List<List<Integer>> rs=new LinkedList<List<Integer>>();
	
	public static void main(String[] args) {
		SubStringSum sss=new SubStringSum();
		sss.helper(new int[] {1, 7, 6, 3, 5, 8, 9}, 0, 16, new LinkedList<Integer>());
		System.out.println(sss.rs);
	}
	public void helper(int[] num, int index, int sum, List<Integer> temp)
	{
		if(sum==0)
			rs.add(temp);
		if(index>=num.length)
			return;
		for(int i=index; i<num.length; i++)
		{
			List<Integer> newTemp=new LinkedList<Integer>(temp);
			newTemp.add(num[i]);
			helper(num, i+1, sum-num[i], newTemp);
		}
	}

}
