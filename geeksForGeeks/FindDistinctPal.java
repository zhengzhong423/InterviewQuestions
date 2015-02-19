package geeksForGeeks;

import java.util.HashSet;
import java.util.Iterator;

public class FindDistinctPal {

	static HashSet<String> hash=new HashSet<>();
	
	public static void main(String[] args) {
		helper1("abaaaa");
		helper2("abaaaa");
		Iterator<String> iter=hash.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	public static void helper1(String s)
	{
			for(int i=0; i<s.length(); i++)
			{
				for(int len=0; len<s.length()-i; len++)
				{
					if(len==0)
						hash.add(s.substring(i-len,i+len+1));
					else if(i-len>=0)
					{
						if(s.charAt(i-len)!=s.charAt(i+len))
							break;
						else
							hash.add(s.substring(i-len, i+len+1));
					}
					else
						break;
				}
			}
	}
	
	public static void helper2(String s)
	{
			for(int i=0; i<s.length(); i++)
			{
				for(int len=1; len<s.length()-i; len++)
				{
					if(i-len>=0 && i+len<s.length())
					{
						if(s.charAt(i-len+1)!=s.charAt(i+len))
							break;
						else
							hash.add(s.substring(i-len+1, i+len+1));
					}
					else
						break;
				}
			}
	}

}
