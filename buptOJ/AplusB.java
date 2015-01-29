package buptOJ;

import java.util.*;


public class AplusB {

public static void main(String[] args) { 
   System.out.print(twoSum(new int[] {1,2,3,4}, 5));
}
public static int[] twoSum(int[] numbers, int target)
{
	 HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
     for(int i=0; i<numbers.length; i++)
     {
         hash.put(i, numbers[i]);
     }
     int left=0, right=0;
     for(int i=0; i<numbers.length; i++)
     {
         if(hash.containsValue(target-numbers[i]))
         {
             left=i;
             break;
         }
     }
     for(int i=left+1; i<numbers.length; i++)
     {
         if(numbers[i]==target-numbers[left])
         {
             right=i;
             break;
         }
     }
     return new int[] {left, right};
}

}
