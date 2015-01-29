package leetCode;

import java.util.*;

public class FourSum {

	public static void main(String[] args) {
		FourSum s=new FourSum();
		int[] num={1,-2,-5,-4,-3,3,3,5};
		System.out.println(s.fourSum(num, -11));
		
	}
		public List<List<Integer>> fourSum(int[] num, int target) {
			  List<List<Integer>> result=new LinkedList<List<Integer>>();
				List<Integer> temp=new LinkedList<Integer>();
				if(num.length<4)
				    return result;
				Arrays.sort(num);
		        helper(num, target, 4, 0, result, temp);
		        return result;
		    }
		    public void helper(int[] num, int target, int quantity, int start, List<List<Integer>> result, List<Integer> temp)
		    {
		    	
		    	if(quantity==0)
		    	{
		    		if(target!=0)
		    			return;
		    		else
		    		{
		    			result.add(temp);
		    			return;
		    		}
		    	}
		    	if(target<num[start])
		    	    return;
		        for(int i=start; i<num.length+1-quantity; i++)
		        {
		            List<Integer> l=new LinkedList<Integer>(temp);
		            l.add(num[i]);
		            helper(num, target-num[i], quantity-1, i+1, result ,l);
		        }
	        
	    }

	

}
