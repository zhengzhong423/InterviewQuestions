package leetCode;

import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(getAnagrams("123","213"));
	}
	public static boolean getAnagrams(String s1, String s2)
	{
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		Arrays.sort(c1);
		String temp1=new String(c1);
		Arrays.sort(c2);
		String temp2=new String(c2);
		if(temp1.equals(temp2))
			return true;
		return false;
	}

}
