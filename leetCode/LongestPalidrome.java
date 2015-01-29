package leetCode;

public class LongestPalidrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abcbbcc"));

	}
	public static String longestPalindrome(String s) {
		int max=0;
		int mid1=0;
		
        for(int mid=0; mid<s.length(); mid++)
        {
        	int i=0;
        	int j=0;
        	int count1 = 0;
        	int count2=0;
        	while(mid-i>=0 && mid+j<s.length())
        	{
        		if(s.charAt(mid-i)==s.charAt(mid+j))
        			count1++;
        		else
        			break;
        		i++; j++;
        	}
        	mid1= (max<count1*2-1)? mid : mid1;
        	max=Math.max(max, count1*2-1);
        	
        	if(mid==s.length()-1)
        		continue;
        	i=0;
        	j=0;
        	if(s.charAt(mid)==s.charAt(mid+1))
        		while(mid-i>=0 && mid+j+1<s.length())
        		{
        			if(s.charAt(mid-i)==s.charAt(mid+1+j))
            			count2++;
            		else
            			break;
            		i++; j++;
        		}
        	mid1= (max<count2*2)? mid : mid1;
        	max=Math.max(max, count2*2);
        }
        if(max%2==0)
        	return s.substring(mid1-max/2+1 , mid1+max/2+1);
        return s.substring(mid1-max/2, mid1+max-max/2);
    }

}
