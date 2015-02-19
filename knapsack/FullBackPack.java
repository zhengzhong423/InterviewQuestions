package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FullBackPack {

	HashMap<Integer, ArrayList<List<Integer>>> hash=new HashMap<Integer, ArrayList<List<Integer>>>(); 
	
	public static void main(String[] args) {
		FullBackPack fb=new FullBackPack();
		int money[] = {1,2,3};
		System.out.println(fb.Number3(money, 3));
		System.out.println(fb.hash);
	}
	
	public  int Number3(int[] money, int target)
	{
		for(int i=0; i<=target; i++)
			hash.put(i, new ArrayList<List<Integer>>());
		int[] opt=new int[target+1];
		opt[0]=1;
		for(int j=0; j<money.length; j++)
		{
			for(int i=0; i<=target; i++)
				if(money[j]<=i)
				{
					if(money[j]==i)
					{
						ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
						ArrayList<Integer> ar=new ArrayList<>();
						ar.add(money[j]);
						result.add(ar);
						hash.get(i).addAll(result);
					}
					else if(hash.get(i-money[j]).size()!=0)
					{
						ArrayList<List<Integer>> result=new ArrayList<List<Integer>>(hash.get(i-money[j]));
						for(List<Integer> temp: result)
						{
							List<Integer> tempRs=new LinkedList<>(temp);
							tempRs.add(money[j]);
							hash.get(i).add(tempRs);
						}
					}
					opt[i]+=opt[i-money[j]];
				}
		}
		return opt[target];
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
					if(j>=money[i])
						opt[i][j]=opt[i][j-money[i]];
					continue;
				}
				if(j>=money[i])
					opt[i][j]+=opt[i][j-money[i]]+opt[i-1][j];
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
