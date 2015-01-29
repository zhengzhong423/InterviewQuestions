package leetCode;

import java.util.*;

public class SubSet {

	public static void main(String[] args) {
		
    }
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        result.add(new LinkedList<Integer>());
        helper(S, 0, result);
        return result;
    }
    public void helper(int[] S, int index, List<List<Integer>> result)
    {
        if(index==S.length)
            return;
        List<List<Integer>> tempResult=new LinkedList<List<Integer>>();
        for(List<Integer> temp: result)
        {
            List<Integer> l=new LinkedList<Integer>(temp);
            l.add(S[index]);
            tempResult.add(l);
        }
        result.addAll(tempResult);
        helper(S, index+1, result);
    }

}
