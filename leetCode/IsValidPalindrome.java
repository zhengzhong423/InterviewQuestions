package leetCode;

public class IsValidPalindrome {
	public static void main(String[] args)
	{
		IsValidPalindrome i=new IsValidPalindrome();
		System.out.println(i.isPalindrome("a."));
	}
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s=s.toLowerCase();
        while(j>i)
        {
            char ch1;
            while( i<s.length() && (!(((ch1=s.charAt(i))>='a' && ch1<='z') || (ch1>='0' && ch1<='9') || (ch1>='A' && ch1<='Z'))))
                i++;
            char ch2;
            while(j>=0 && (!(((ch2=s.charAt(j))>='a' && ch2<='z') || (ch2>='0' && ch2<='9') || (ch2>='A' && ch2<='Z'))))
                j--;
            if(j<=i)
                return true;
            else if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
