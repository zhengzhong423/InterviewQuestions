package backpack;

import java.util.Arrays;

public class FullBackPack {

	public static void main(String[] args) {
		int money[] = {1,2,5,21,25};
		System.out.println(Number2(money, 5));
	}
	
	//iteration
	// 0/1 fill the knapsack, or Subset Sum
	// unlimited stuff fill the knapsack
	public static int Number2(int[] money, int target)
	{
		int[][] opt=new int[money.length][target+1];
		for(int i=0; i<money.length; i++)
			opt[i][0]=1;
		for(int i=0; i<money.length; i++)
			for(int j=0; j<=target; j++)
			{
				if(i==0)
				{
					if( j==money[i])
						opt[i][j]=1;
				}
				else if(j>=money[i])
					opt[i][j]=opt[i-1][j-money[i]]+opt[i-1][j];
				else
					opt[i][j]=opt[i-1][j];
			}
		return opt[money.length-1][target];
			
	}
	
	// 0/1 fill the knapsack, or Subset Sum
	// unlimited stuff fill the knapsack
	//recursion version
	public static int Number(int[] money ,int target, int index)
	{
		if(index>=money.length)
			return 0;
		if(target==money[index])
			return 1;
		if(target<0)
			return 0;
		int sum=0;
		sum+=Number(money, target-money[index], index+1);
		sum+=Number(money, target, index+1);
		return sum;
	}
	public static int backPackFull(int[] money, int target)
	{
		int[][] opt=new int[money.length][target+1];
		for(int i=0; i<opt.length; i++)
			Arrays.fill(opt[i], money.length+1);
		opt[0][money[0]]=1;
		for(int i=1; i<money.length; i++)
			for(int j=0; j<=target; j++)
			{
				if(j>money[i])
					opt[i][j]=Math.min(opt[i-1][j], Math.min(1+opt[i-1][j-money[i]], 1+opt[i][j-money[i]]));
				else if(j==money[i])
					opt[i][j]=1;
				else
					opt[i][j]=opt[i-1][j];
			}
		return opt[money.length-1][target];
	}

}
