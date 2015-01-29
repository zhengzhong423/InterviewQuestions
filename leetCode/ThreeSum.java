package leetCode;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum s=new ThreeSum();
		int[] num={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		
		System.out.println(s.threeSum(num));
		
	}
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result=new LinkedList<List<Integer>>();
		HashSet<List<Integer>> hash=new HashSet<List<Integer>>();
		for(int s=0; s<num.length-2;s++)
		{
			int m=s+1;
			int e=num.length-1;
			while(m<e)
			{
				if(num[s]+num[m]+num[e]==0)
				{
					
					List<Integer> temp=new LinkedList<Integer>();
					temp.add(num[s]);
					temp.add(num[m]);
					temp.add(num[e]);
					if(!hash.contains(temp))
					{
						result.add(temp);
						hash.add(temp);
					}
				}
				if(num[s]+num[m]+num[e]>0)
					e--;
				else
					m++;
			}
		}
		return result;
    }

}
