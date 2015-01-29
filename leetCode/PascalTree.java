package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTree {

	public static void main(String[] args) {
	
	}
	 public List<List<Integer>> generate(int numRows) 
	 {
		List<List<Integer>> l=new ArrayList<List<Integer>>();
		List<Integer> row0=new ArrayList<Integer>();
		row0.add(1);
		l.add(row0);
	    for(int i=1; i<numRows; i++)
	    {
	    	List<Integer> temp=new ArrayList<Integer>();
	    	for(int j=0; j<=i; j++)
	    	{
	    		if(j==0)
	    		{
	    			temp.add(1);
	    			continue;
	    		}
	    		if(j==i)
	    		{
	    			temp.add(1);
	    			continue;
	    		}
	    		temp.add(l.get(i-1).get(j-1)+l.get(i-1).get(j));
	    	}
	    	l.add(temp);
	    }
	    return l;
	 }
}
