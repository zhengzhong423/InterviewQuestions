package dynamic_programming;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		helper("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com");
	}
	public static void helper(String s, String T)
	{
		int[][] opt=new int[s.length()][T.length()];
		int max=0;
		for(int i=0; i<s.length(); i++)
			for(int j=0; j<T.length(); j++)
				if(s.charAt(i)==T.charAt(j))
				{
					opt[i][j]=opt[i-1][j-1]+1;
					max=Math.max(opt[i][j], max);
				}
				else
					opt[i][j]=0;
		for(int i=0; i<s.length(); i++)
			for(int j=0; j<T.length(); j++)
				if(opt[i][j]==max)
					System.out.println(s.substring(i-max+1, i+1));
		
	}

}
