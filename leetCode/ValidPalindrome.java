package leetCode;

public class ValidPalindrome {

	public static void main(String[] args) {
		
		String s=",abcscb,a.";
		System.out.println(isPalindrome(s));
	}
	public static boolean isPalindrome(String s) {
		if(s.length()<=1)
			return true;
        char[] ch=s.toLowerCase().toCharArray();
        int start=0;
        int end=ch.length-1;
        if(!validPaliMid(ch, start, end))
        	return true;
        while(end>start)
        {
        	while(true)
        	{
        		if(ch[start]<='z' && ch[start]>='a')
        			break;
        		if(ch[start]<='9' && ch[start]>='0')
        			break;
        		start++;
        		if(!validPaliMid(ch, start, end))
        			return true;
        	}
        	while(true)
        	{
        		if(ch[end]<='z' && ch[end]>='a')
        			break;
        		if(ch[end]<='9' && ch[end]>='0')
        			break;
        		end--;
        		if(!validPaliMid(ch, start, end))
        			return true;
        	}
        	if(ch[start]!=ch[end])
        		return false;
        	else
        	{
        		start++;
        		end--;
        	}
        }
        return true;
    }
	public static boolean validPaliMid(char[] ch, int start, int end)
	{
		for(int i=start; i<=end; i++)
		{
	        	if(ch[i]<='z' && ch[i]>='a')
	        			return true;
	        	if(ch[i]<='9' && ch[i]>='0')
	        			return true;
		}
		return false;
	}
}
