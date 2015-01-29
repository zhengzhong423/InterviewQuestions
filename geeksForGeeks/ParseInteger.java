package geeksForGeeks;

import java.util.LinkedList;
import java.util.List;

public class ParseInteger {
	List<String> result=new LinkedList<String>();
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		ParseInteger i=new ParseInteger();
		i.bruteforce("1003", 0, "");
		System.out.println(i.result);
	}
	public void bruteforce(String str, int index, String temp)
	{
		if(index>=str.length())
		{
			result.add(new String(temp));
			return;
		}
		int num1=Integer.parseInt(String.valueOf(str.charAt(index)));
		if(num1>0)
			bruteforce(str, index+1, temp+(char)(num1-1+'a'));
		if(index+1<str.length())
		{
			int num2=Integer.parseInt(String.valueOf(str.charAt(index+1)));
			int num=num1*10+num2;
			if(num<26 && num>0)
				bruteforce(str, index+2, temp+(char)(num-1+'a'));
		}
	}
}
