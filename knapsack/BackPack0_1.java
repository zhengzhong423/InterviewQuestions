package knapsack;


public class BackPack0_1{

	public static void main(String[] args) {
		
	}
	public int[][] helper(int[] weight, int[] value, int W)
	{
		int[][] opt=new int[weight.length+1][W+1];
		for(int i=1; i<=weight.length; i++)
			for(int j=0; j<=W; j++)
			{
				if(j>=weight[i-1])
					opt[i][j]=Math.max(opt[i-1][j], opt[i-1][j-weight[i-1]]+value[i-1]);
				else
					opt[i][j]=opt[i-1][j];
			}
		return opt;
	}
	public static void getPath(int[][] opt, int[] weight, int[] value)
	{
		int j=opt[weight.length-1][opt[0].length-1];
		int i=weight.length;
		while(j>0 && i>0)
		{
			if(j>=weight[i-1])
				if(opt[i][j]==opt[i-1][j-weight[i-1]]+value[i-1])
				{
					j=j-weight[i-1];
					System.out.println("No."+(i-1));
				}
			i--;
		}
	}
}
