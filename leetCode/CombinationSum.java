package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
	}
	public static List<List<Integer>> combination2(int[] num, int target)
	{
		Arrays.sort(num);
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> cur=new ArrayList<Integer>();
		if(num.length==0 && target==0)
			return result;
		helper(num, target, 0, result, cur);
		return result;
	}
	private static void helper(int[] num, int target, int index, List<List<Integer>> result, List<Integer> cur)
	{
		if(target==0)
		{
			List<Integer> temp=new ArrayList<Integer>();
			temp.addAll(cur);
			if(!result.contains(cur))
				result.add(temp);
			return;
		}
		for(int i=index; i<num.length; i++)
		{
			if(num[i]>target)
				break;
			List<Integer> temp=new ArrayList<Integer>();
			temp.add(num[i]);
			cur.addAll(temp);
			helper(num, target-num[i], i+1, result, cur);
			if(cur.size()!=0)
				cur.remove(cur.size()-1);
		}
		return;
		
	}
	
}
