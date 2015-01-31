package geeksForGeeks;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(lcs("12345","23456781"));
	}
	public static int  lcs(String s1, String s2)
	{
		int[][] opt=new int[s1.length()][s2.length()];
		for(int i=0; i<s1.length(); i++)
			for(int j=0; j<s2.length(); j++)
			{
				if(i==0)
				{
					opt[i][j]=s1.charAt(i)==s2.charAt(j)?1:0;
					continue;
				}
				if(j==0)
				{
					opt[i][j]=s1.charAt(i)==s2.charAt(j)?1:0;
					continue;
				}
				if(s1.charAt(i)==s2.charAt(j))
					opt[i][j]=1+opt[i-1][j-1];
				else
					opt[i][j]=0;
			}
		int max=0;
		for(int i=0; i<s1.length(); i++)
			for(int j=0; j<s2.length(); j++)
				max=Math.max(opt[i][j], max);
		return max;
	}

}
