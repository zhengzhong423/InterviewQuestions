package leetCode;

import java.util.*;

public class CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates={7,3,9,6};
		System.out.println(combinationSum(candidates, 6));

	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(candidates.length==0)
            return result;
        if(target<candidates[0])
            return result;
        Arrays.sort(candidates);
        helper(candidates,target,result, new LinkedList<Integer>(), 0);
        return result;
    }
    public static void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int start)
    {
        for(int i=start; i<candidates.length; i++)
        {
            if(target<candidates[i])
                return;
            if(target==candidates[i])
            {
                temp.add(candidates[i]);
                result.add(new LinkedList<Integer>(temp));
            }
            if(target>candidates[i])
            {
                List<Integer> newTemp=new LinkedList<Integer>(temp);
                newTemp.add(candidates[i]);
                helper(candidates, target-candidates[i], result, newTemp, i);
            }
        }
        
    }

}
