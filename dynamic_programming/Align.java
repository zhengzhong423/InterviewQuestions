package dynamic_programming;

public class Align {

	public static void main(String[] args) {
		System.out.println(align("AADDEFGGHC", "ADCDEGH"));
	}
	public static int align( String S, String T)
	{
		int opt[][]= new int[S.length()+1][T.length()+1];
		for(int i=1; i<=S.length(); i++)
			opt[i][0]=0;
		for(int j=0; j<=T.length(); j++)
			opt[0][j]=0;
		for(int i=S.length()-1; i>=0; i--)
			for(int j=T.length()-1; j>=0; j--)
			{
				if(S.charAt(i)==T.charAt(j))
					opt[i][j]=Math.max(2+opt[i+1][j+1] , Math.max(opt[i+1][j]-1, opt[i][j+1]));
				else
					opt[i][j]=Math.max(opt[i+1][j]-1, opt[i][j+1]);
			}
		return opt[0][0];
	}

}
