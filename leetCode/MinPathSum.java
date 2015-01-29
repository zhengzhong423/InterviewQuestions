package leetCode;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] grid={{1,2},{1,1}};
		System.out.println(minPathSum(grid));
	}
	   public static int minPathSum(int[][] grid) {
	        int[][] path=new int[grid.length][grid[0].length];
	        int num=0;
	        if(grid.length==1 && grid[0].length==1)
	            return grid[0][0];
	        for(int i=0; i<grid.length; i++)
	        {
	            num+=grid[i][0];
	            path[i][0]=num;
	        }
	        num=0;
	        for(int i=0; i<grid[0].length; i++)
	        {
	            num+=grid[0][i];
	            path[0][i]=num;
	        }
	        path[0][0]=grid[0][0];
	        for(int i=1; i<grid.length; i++)
	            for(int j=1; j<grid[0].length; j++)
	            {
	                path[i][j]=Math.min(path[i-1][j]+grid[i][j], path[i][j-1]+grid[i][j]);
	            }
	        return path[grid.length-1][grid[0].length-1];
	                
	    }

}
