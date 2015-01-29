package leetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Permutation2 {

	public static void main(String[] args) {

	}
	List<List<Integer>> result=new LinkedList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] num) {
        result.add(new LinkedList<Integer>());
        helper(num, 0);
        return result;
    }
    public void helper(int[] num, int index)
    {
        if(index==num.length)
            return;
        HashSet<List<Integer>> hash=new HashSet<List<Integer>>();
        for(List<Integer> k: result)
            for(int i=0; i<=k.size(); i++)
            {
            	LinkedList<Integer> temp=new LinkedList<>(k);
            	temp.add(i, num[index]);
                hash.add(temp);
            }
        Iterator<List<Integer>> iter=hash.iterator();
        while(iter.hasNext())
            result.add(iter.next());
    }

}
