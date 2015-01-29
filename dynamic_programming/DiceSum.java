package dynamic_programming;

public class DiceSum {

	public static void main(String[] args) {
		System.out.println(helper(5, 3));
	}
	public static int helper(int num, int N)
	{
		int[][] opt=new int[N+1][num+1];
		for(int i=1; i<=4; i++)
			opt[1][i]=1;
		for(int i=2; i<=N; i++)
			for(int j=1; j<=num; j++)
				for(int k=1; k<=4; k++)
					if(j>=k)
					opt[i][j]=opt[i-1][j-k]+opt[i][j];
		return opt[N][num];
	}

}
