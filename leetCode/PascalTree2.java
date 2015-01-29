package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTree2 {

	public static void main(String[] args) {
		System.out.println(getRow(2));
	}
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> row0=new ArrayList<Integer>();
		List<Integer> row=new ArrayList<Integer>();
		if(rowIndex==0)
			return row;
		row.add(1);
		if(rowIndex==1)
			return row;
		for(int i=1; i<=rowIndex; i++)
	    {
			row0=new ArrayList<Integer>(row);
	    	row.clear();
	    	for(int j=0; j<=i; j++)
	    	{
	    		if(j==0)
	    		{
	    			row.add(1);
	    			continue;
	    		}
	    		if(j==i)
	    		{
	    			row.add(1);
	    			continue;
	    		}
	    		row.add(row0.get(j-1)+row0.get(j));
	    	}
	    }
		return row;
    }
}
