package leetCode;

import java.util.Arrays;

public final class ScrambleStrings {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ScrambleStrings s=new ScrambleStrings();
		System.out.println(s.isScramble("cbccbcbcacaaaaaa", "cabaabcaaacaccbc"));
	}
	public boolean isScramble(String s1, String s2) {
		if(s1.length()<=3 && isSame(s1,s2))
			return true;
		if(!isSame(s1, s2))
			return false;
		int max=0;
		int type=0;
		for(int i=1; i<s1.length(); i++)
		{
			if(isSame(s1.substring(0,i), s2.substring(0,i)))
			{
				if(isSame(s1.substring(i,s1.length()), s2.substring(i, s2.length())))
				{
					if(i>max)
					{
						type=2;
						max=i;
					}
				}
			}
			if(isSame(s1.substring(0,i), s2.substring(s2.length()-i,s2.length())))
			{
				if(isSame(s1.substring(i,s1.length()), s2.substring(0, s2.length()-i)))
				{
					if(i>max)
					{
						type=1;
						max=i;
					}
				}
			}
		}
		if(type==1)
			return isScramble(s1.substring(0,max), s2.substring(s2.length()-max,s2.length())) && isScramble(s1.substring(max,s1.length()), s2.substring(0, s2.length()-max));
		if(type==2)
			return isScramble(s1.substring(0,max), s2.substring(0,max)) && isScramble(s1.substring(max,s1.length()), s2.substring(max, s2.length()));
		return false;
    }

	public boolean isSame(String s1, String s2)
	{
		char[] tempS1=s1.toCharArray();
		char[] tempS2=s2.toCharArray();
		Arrays.sort(tempS1);
		Arrays.sort(tempS2);
		for(int i=0; i<tempS1.length; i++)
		{
			if(tempS1[i]!=tempS2[i])
				return false;
		}
		return true;
	}

}
