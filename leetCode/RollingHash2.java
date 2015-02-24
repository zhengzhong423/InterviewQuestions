package leetCode;

public class RollingHash2 {

	public static void main(String[] args) {
		RollingHash2 hash=new RollingHash2();
		System.out.println(hash.strStr("baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa", "bbaaaababa"));

	}
    
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        int len=needle.length();
        long total=(long)Math.pow(26, len-1);
        long val=0;
        
        for(int i=0; i<needle.length(); i++)
            val=val*26+(needle.charAt(i)-'a');
            
        long num=0;
        for(int i=0; i<haystack.length(); i++)
        {
        	 if(i>=len)
                 num-=(total*(haystack.charAt(i-len)-'a'));
            
            num=num*26+(haystack.charAt(i)-'a');
            
            if(num==val && i+1>=len)
                return i+1-len;
        }
        return -1;
    }

}
