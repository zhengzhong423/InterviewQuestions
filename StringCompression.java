import java.util.*;


public class StringCompression {

	public static void main(String[] args) 
	{	
		StringCompression r=new StringCompression();
		HashMap<String,Integer> hash=new HashMap<String, Integer>();
		String s="aaabbbcccddddddd";
		r.stringCompression(s, hash);
		for(String p:hash.keySet())
		{
			System.out.print(p);
			System.out.print(hash.get(p));
		}
	}

	private void stringCompression(String s,HashMap<String, Integer> hash) 
	{
		for(int i=0;i<=s.length()-1;i++)
		{
			char temp=s.charAt(i);
			if(hash.containsKey(temp+""))
			{
				int num=hash.get(temp+"");
				hash.put(temp+"", num+1);
			}
			else
				hash.put(temp+"", 1);
		}
	}

}
