package leetCode;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> l=new LinkedList<List<Integer>>();
        helper(l, num, 0);
        return l;
    }
	public void helper(List<List<Integer>> result, int[] num, int index)
	{
		if(index==num.length)
		{
			result.add(new LinkedList<Integer>());
			return;
		}
		helper(result,num, index+1);
		List<List<Integer>> tempResult=new LinkedList<List<Integer>>();
			for(int i=0; i<=result.get(0).size(); i++)
			{
				for(List<Integer> l: result)
				{
					List<Integer> tempL=new LinkedList<Integer>(l);
					tempL.add(i, num[index]);
					tempResult.add(tempL);
				}
			}
			result.clear();
			result.addAll(tempResult);
			
	}

}
