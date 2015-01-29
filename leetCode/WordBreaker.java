package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreaker {
	public static
	LinkedList<List<String>> result=new LinkedList<List<String>>();
	public static void main(String[] args)
	{
		String s="catsanddog";
		String[] a={"cat", "cats", "and", "sand", "dog"};
		Set<String> dict=new HashSet<String>(Arrays.asList(a));
	//	List<String> l=wordBreak(s, dict);
		List<String> l=wordBreak2(s, dict);
		Iterator<String> iter=l.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	 private static List<String> wordBreak2(String s, Set<String> dict) {
		 HashMap<Integer, List<String>> hash=new HashMap<Integer, List<String>>();
		 LinkedList<String> temp=new LinkedList<String>();
		 temp.add("");
		 hash.put(s.length(), temp);
		 for(int i=s.length()-1; i>=0 ;i--)
			 for(int j=i+1; j<=s.length(); j++)
			 {
				 if(dict.contains(s.substring(i, j)))
					if(hash.containsKey(j))
					{
						
							List<String> l=new LinkedList<String>();
							for(String p:hash.get(j))
							{
								p=s.substring(i,j)+" "+p;
								l.add(p.trim());
							}
							if(hash.containsKey(i))
								for(String p:hash.get(i))
								{
									l.add(p);
								}
							hash.put(i, l);
						
					}
			 }
		 if(hash.containsKey(0))
			 return hash.get(0);
		 else
			 return new LinkedList<String>();
	}
	public static List<String> wordBreak(String s, Set<String> dict) 
	 {
	     LinkedList<String> c=new LinkedList<String>();
	     List<String> l=new LinkedList<String>();
	     getWordBreak(s, dict, c);
	     String str="";
	     for(int i=0; i<result.size(); i++)
	     {
	    	 for(String c1:result.get(i))
	    	 {
	    		 str=str+c1+" ";
	    	 }
	    	 l.add(str.trim());
	    	 str="";
	     }
	     return l;
	 }
	public static void getWordBreak(String s, Set<String> dict, LinkedList<String> c) 
	{
		if(s.length()==0)
		{
			result.add(new LinkedList<String>(c));
			return;
		}
		 for(int i=0; i<s.length(); i++)
	      {
	    	  if(dict.contains(s.substring(0,i+1)))
	    	  {
	    		  c.add(s.substring(0,i+1));
	    		 getWordBreak(s.substring(i+1),dict,c);
	    		 c.removeLast();
	    	  }
	      }
	}
}
