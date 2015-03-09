package epic;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins={5,10};
		CoinChange cc=new CoinChange();
		System.out.println(cc.helper(coins, 18));
	}
	
	public int helper(int[] coins, int N)
	{
		int[][] opt=new int[coins.length][N+1];
		for(int i=0; i<coins.length; i++)
			Arrays.fill(opt[i], Integer.MAX_VALUE);
		for(int i=0; i<coins.length; i++)
			for(int j=0; j<=N; j++)
			{
				if(j==0)
					opt[i][j]=0;
				else if(i==0)
				{
					if(j>=coins[0] && opt[i][j-coins[0]]!=Integer.MAX_VALUE)
						opt[i][j]=opt[i][j-coins[0]]+1;
				}
				else if(j-coins[i]>0 && opt[i][j-coins[0]]!=Integer.MAX_VALUE)
						opt[i][j]=Math.min(opt[i-1][j], opt[i][j-coins[i]]+1);
				else
					opt[i][j]=opt[i-1][j];
			}
		return opt[coins.length-1][N];
	}

}
