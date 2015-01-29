package leetCode;

public class DistinctSubsequence {

	public static void main(String[] args) {

	}
	public int numDistinct(String S, String T) 
	{
        int ls=S.length();
        int lt=T.length();
        if(ls==0 || lt==0)
        	return 0;
        int[][] OPT=new int[ls][lt];
        for(int i=0; i<ls; i++)
        	for(int j=0; j<lt; j++)
        	{
        		if(i==0)
        		{
        			OPT[i][j]=(S.charAt(i)==T.charAt(j) ? 1 : 0);
        			continue;
        		}
        		if(j==0)
        		{
        			OPT[i][j]=(S.charAt(i)==T.charAt(j) ? 1 : 0)+ OPT[i-1][j];
        			continue;
        		}
        		OPT[i][j]=(S.charAt(i)==T.charAt(j) ? OPT[i-1][j-1] : 0)+OPT[i-1][j];
        	}
        return OPT[ls-1][lt-1];
    }

}
