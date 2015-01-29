package leetCode;

import java.util.HashMap;

public class GetTwoSum {

	public static void main(String[] args) {
		GetTwoSum a=new GetTwoSum();
		int[] numbers={2, 7, 11, 15};
		int target=9;
		System.out.println(a.twoSum(numbers, target)[0]);
		System.out.println(a.twoSum(numbers, target)[1]);
	}
	public int[] twoSum(int[] numbers, int target) 
	{
        HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
        for(int i=0; i<=numbers.length; i++)
        {
        	if(hash.containsKey(target-numbers[i]))
        	{
        		int[] result = new int[2];
        		result[0]=hash.get(target-numbers[i]);
        		result[1]=i+1;
        		return result;
        	}
        	else
        		hash.put(numbers[i],i+1);
        }
        int[] bad={0};
        return bad;
    }
}
