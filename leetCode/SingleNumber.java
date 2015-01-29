package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleNumber {

	public static void main(String[] args) {
		int[] a={43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
		System.out.print(singleNumber(a));

	}
	 public static int singleNumber(int[] A) {
		  if(A.length==1)
		    	return A[0];
		  List<Integer> l= new ArrayList<Integer>();
		for(int i:A)
		{
			l.add(i);
		}	   
		Collections.sort(l);
	    for(int i=0; i<l.size()-2;i=i+3)
	    { 
	    	
	    	if((long)l.get(i)==(long)l.get(i+1))
	    		if( (long)l.get(i)==(long)l.get(i+2))
	    			continue;
	    	if(l.get(i)==l.get(i+1))
	    		return (int) l.get(i+2);
	    	if(l.get(i)==l.get(i+2))
	    		return (int) l.get(i+1);
	    	else
	    		return (int) l.get(i);
	    }
	    return l.get(A.length-1);
	 }
}
