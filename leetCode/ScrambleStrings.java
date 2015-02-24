package leetCode;

import java.util.Arrays;

public final class ScrambleStrings {

	public static void main(String[] args) {
		ScrambleStrings s=new ScrambleStrings();
		System.out.println(s.isScramble("abb", "bba"));
	}
	public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        if(!sameCh(s1, s2))
            return false;
        if(s1.equals(s2))
            return true;

        if(s1.length()<=2)
            return true;
            
        for(int i=1; i<=s1.length()-1; i++)
        {
            if((isScramble(s1.substring(i), s2.substring(i)) && isScramble(s1.substring(0,i), s2.substring(0,i)) )||
            (isScramble(s1.substring(i), s2.substring(0,s2.length()-i)) && isScramble(s1.substring(0,i), s2.substring(s2.length()-i)))
            )
                return true;
        }
        return false;
    }
    
    public boolean sameCh(String s1, String s2)
    {
        char[] ch1=(s1.toCharArray());
        char[] ch2=(s2.toCharArray());
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
//	public boolean isScramble(String s1, String s2) {
//		if(s1.length()<=3 && isSame(s1,s2))
//			return true;
//		if(!isSame(s1, s2))
//			return false;
//		int max=0;
//		int type=0;
//		for(int i=1; i<s1.length(); i++)
//		{
//			if(isSame(s1.substring(0,i), s2.substring(0,i)))
//			{
//				if(isSame(s1.substring(i,s1.length()), s2.substring(i, s2.length())))
//				{
//					if(i>max)
//					{
//						type=2;
//						max=i;
//					}
//				}
//			}
//			if(isSame(s1.substring(0,i), s2.substring(s2.length()-i,s2.length())))
//			{
//				if(isSame(s1.substring(i,s1.length()), s2.substring(0, s2.length()-i)))
//				{
//					if(i>max)
//					{
//						type=1;
//						max=i;
//					}
//				}
//			}
//		}
//		if(type==1)
//			return isScramble(s1.substring(0,max), s2.substring(s2.length()-max,s2.length())) && isScramble(s1.substring(max,s1.length()), s2.substring(0, s2.length()-max));
//		if(type==2)
//			return isScramble(s1.substring(0,max), s2.substring(0,max)) && isScramble(s1.substring(max,s1.length()), s2.substring(max, s2.length()));
//		return false;
//    }
//
//	public boolean isSame(String s1, String s2)
//	{
//		char[] tempS1=s1.toCharArray();
//		char[] tempS2=s2.toCharArray();
//		Arrays.sort(tempS1);
//		Arrays.sort(tempS2);
//		for(int i=0; i<tempS1.length; i++)
//		{
//			if(tempS1[i]!=tempS2[i])
//				return false;
//		}
//		return true;
//	}

}
