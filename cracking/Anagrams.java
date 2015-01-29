import java.util.*;


public class Anagrams {

	public static void main(String[] args) 
	{	
		Anagrams r=new Anagrams();
		System.out.println(r.anagrams("d      o g","god       "));
	}
	public HashMap<String,Integer> insert(String s)
	{
		HashMap<String, Integer> result=new HashMap<String, Integer>();
		for(int i=0;i<=s.length()-1;i++)
		{
			String temp2="";
			if(result.containsKey(temp2+s.charAt(i)))
			{				
				int num=result.get(temp2+s.charAt(i))+1;
				result.put(temp2+s.charAt(i),num);
			}
			else
			{
				String temp="";
				temp+=s.charAt(i);
				result.put(temp,1);
			}
		}
		return result;
	}
	public int anagrams(String s1, String s2)
	{
		HashMap<String, Integer> hash1=new HashMap<String, Integer>();
		HashMap<String, Integer> hash2=new HashMap<String, Integer>();
		Anagrams a=new Anagrams();
		hash1=a.insert(s1);
		hash2=a.insert(s2);
		for(String s:hash1.keySet())
		{
			if(hash2.containsKey(s))
			{
				if(hash2.containsValue(s)!=hash1.containsValue(s))
					return 0;
			}
			else
				return 0;
		}
		for(String s:hash2.keySet())
		{
			if(hash1.containsKey(s))
			{
				if(hash1.containsValue(s)!=hash2.containsValue(s))
					return 0;
			}
			else
				return 0;
		}
		return 1;

	}

}
