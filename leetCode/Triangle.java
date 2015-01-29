package leetCode;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {

	}
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()<2)
			return 0;
        int[][] opt=new int[triangle.size()][triangle.size()];
        opt[0][0]=triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++)
        {
        	for(int j=0; j<=i; j++)
        	{
        		if(j==0)
        			opt[i][0]=opt[i-1][0]+triangle.get(i).get(0);
        			else if(j==i)
        				opt[i][j]=opt[i-1][j-1]+triangle.get(i).get(j);
        				else
        					opt[i][j]=Math.min(opt[i-1][j-1], opt[i-1][j])+triangle.get(i).get(j);
        	}
        }
        int minTotal=Integer.MAX_VALUE;
        for(int j=0; j<triangle.size(); j++)
        	minTotal=Math.min(minTotal, opt[triangle.size()-1][j]);
        return minTotal;
    }
}
