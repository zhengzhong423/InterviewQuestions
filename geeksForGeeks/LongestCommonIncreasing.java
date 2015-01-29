package geeksForGeeks;

public class LongestCommonIncreasing {

	public static void main(String[] args) {
		int[] a1=new int[] {1,9,2,4};
		int[] a2=new int[] {1,5,2,4,1};
		System.out.println(LCI(a1, a2));
	}
	public static int LCI(int[] a1, int[] a2)
	{
		int n=a1.length; 
		int m=a2.length;
		int[][] opt=new int[n][m];
		opt[0][0]=a1[0]==a2[0]?1:0;
		for(int i=1; i<n; i++)
			opt[i][0]=a1[i]==a2[0]?1:opt[i-1][0];
		for(int j=1; j<m; j++)
			opt[0][j]=a1[0]==a2[j]?1:opt[0][j-1];
		for(int i=1; i<n; i++)
			for(int j=1; j<m; j++)
			{
				if(a1[i]==a2[j])
				{
					for(int k=0; k<=i; k++)
						if(a1[i]>=a1[k])
							opt[i][j]=Math.max(opt[i][j], opt[k][j]+1);
					for(int k=0; k<=j; k++)
						if(a2[j]>=a2[k])
							opt[i][j]=Math.max(opt[i][j], opt[i][k]+1);
				}
				else
				{
						opt[i][j]=Math.max(opt[i-1][j], opt[i][j-1]);
				}
			}
		return opt[a1.length-1][a2.length-1];
	}

}
