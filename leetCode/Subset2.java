package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subset2 {

	public static void main(String[] args) {

	}
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result=new LinkedList<List<Integer>>();
		Arrays.sort(num);
		helper(result, 0, num);
		return result;
    }
	public void helper(List<List<Integer>> result, int index, int[] num)
	{
		if(index>num.length)
			return;
		if(index==0)
		{
			List<Integer> temp=new LinkedList<Integer>();
			result.add(temp);
			helper(result, index+1, num);
		}
		if(index>0)
		{
			List<List<Integer>> tempResult=new LinkedList<List<Integer>>();
			for(List<Integer> l:result)
			{
				List<Integer> temp=new LinkedList<Integer>(l);
				temp.add(num[index-1]);
				tempResult.add(temp);
			}
			for(List<Integer> o:tempResult)
			{
				if(!result.contains(o))
				result.add(o);
			}
			helper(result, index+1, num);
		}
		
	}

}
