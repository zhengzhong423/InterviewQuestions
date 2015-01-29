package leetCode;

public class MinCut {

	public static void main(String[] args) {
		System.out.println(minCut2("bb"));

	}
	public static int minCut2(String s) {
        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 0;
        char[] ch=s.toCharArray();
        int[] opt=new int[s.length()+1];
        for(int i=1; i<=s.length(); i++)
            opt[i]=i-1;
        opt[0]=-1;
        boolean[][] rs=isPalindrome(ch);
        for(int i=1; i<=s.length(); i++)
            for(int j=0; j<i; j++)
                if(rs[j][i-1])
                    opt[i]=Math.min(opt[i], 1+opt[j]);
        return opt[s.length()];
    }
    public static boolean[][] isPalindrome(char[] ch)
    {
        boolean[][] rs=new boolean[ch.length][ch.length];
        for(int len=0; len<ch.length; len++)
            for(int i=0; i<ch.length-len; i++)
            {
                int j=i+len;
                if(ch[i]==ch[j])
                {
                    if(i==j || j==i+1)
                        rs[i][j]=true;
                    else
                        rs[i][j]=rs[i+1][j-1];
                }
                else
                    rs[i][j]=false;
            }
       return rs; 
    }
	public static int minCut(String s)
	{
		int[] opt=new int[s.length()];
        for(int i=0; i<s.length(); i++)
            opt[i]=i;
        for(int i=0; i<s.length(); i++)
        {
            for(int j=0; i-j>=0 && i+j<s.length() && s.charAt(i-j)==s.charAt(i+j) ; j++)
                if(i-j-1>=0)
                    opt[i+j]=Math.min(opt[i], opt[i-j-1]+1);
                else
                    opt[i+j]=Math.min(opt[i], 0);
            for(int j=0; i-j>=0 && i+j+1<s.length() && s.charAt(i-j)==s.charAt(i+j+1) ; j++)
                if(i-j-1>=0)
                    opt[i+j+1]=Math.min(opt[i], opt[i-j-1]+1);
                else
                    opt[i+j+1]=Math.min(opt[i], 0);
        }
        return opt[s.length()-1];
	}
	 public static boolean isPalindrome(String str)
	 {
		 if(str.length()==0)
			 return false;
		 for(int i=0; i<=str.length()/2; i++)
		 {
			 if(str.charAt(i)!=str.charAt(str.length()-i-1))
			 	return false;
		 }
		 return true;
	 }
}
