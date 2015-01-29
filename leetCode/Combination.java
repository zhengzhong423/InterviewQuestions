package leetCode;

import java.util.LinkedList;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		Combination.combine(4, 2);
	}
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result=new LinkedList<List<Integer>>();
		List<Integer> temp=new LinkedList<Integer>();
		if(n==0 || k==0)
			return result;
		helper(result, temp, 0, 0, n, k);
		return result;
    }
	public static void helper(List<List<Integer>> result, List<Integer> temp, int num, int largest, int n, int k)
	{
		if(num>n || temp.size()>k)
			return;
		if(temp.size()==k)
		{
			result.add(new LinkedList<Integer>(temp));
			return;
		}
		for(int i=largest; i<n; i++)
		{
			temp.add(i+1);
			helper(result, temp, num+1, i+1, n, k);
			temp.remove(temp.size()-1);
		}
		return;
	}
}
