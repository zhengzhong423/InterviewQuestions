package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WorldLadder {

	public static void main(String[] args) {
		Set<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dot");
		dict.add("dog");
		dict.add("hit");
		dict.add("lot");
		dict.add("log");
//		dict.add("a");
//		dict.add("b");
//		dict.add("c");
		System.out.println(ladderLength("hit","cog",dict));
	}
	public static int ladderLength(String start, String end, Set<String> dict) {
	       
        Queue<String> cur=new LinkedList<String>();
        cur.add(start);
        HashSet<String> hash=new HashSet<String>();
        hash.add(start);
        int count=1;
        
        while(!cur.isEmpty())
        {
           Queue<String> next=new LinkedList<String>();
           count++;
           while(!cur.isEmpty())
           {
                String thisOne=cur.poll();
                char[] ch=thisOne.toCharArray();
                
                for(int i=0; i<ch.length; i++)
                {
                	char original=ch[i];
                    for(int j=0; j<=26; j++)
                    {
                       ch[i]=(char)('a'+j);
                       String s=String.valueOf(ch);
                       if(dict.contains(s) && !hash.contains(s))
                       {
                           next.add(s);
                           hash.add(s);
                           if(s.equals(end))
                            return count;
                           
                       }
                       ch[i]=original;
                    }
                }
           }
           for(String str:next)
               if(transOne(str , end))
                 return count+1;
           cur.addAll(next);
           
        }
        return 0;  
    }
    public static boolean transOne(String s1, String s2)
    {
        boolean set=false;
        for(int i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(!set)
                    set=true;
                else
                    return false;
            }
        }
        return set;
    }
//	 public static int ladderLength(String start, String end, Set<String> dict) 
//	 {
//	        HashMap<String, Integer> hash=new HashMap<String, Integer>();
//	        for(String s: dict)
//	        hash.put(s, 0);
//	        int ca=1;
//	        if(dict.contains(start))
//	        	ca=0;
//	        int cd=1;
//	        if(dict.contains(end))
//	        	cd=0;
//	        if(dict.contains(start))
//	        {ca=0;hash.put(start, 1);}
//	        else
//	        hash.put(start,0);
//	        hash.put(end, 0);
//	        if(dict.contains(start) && dict.contains(end) && start.length()==1 && end.length()==1)
//	        	return 2;
//	        dict.add(end);
//	        LinkedList<String> updated= new LinkedList<String>();
//	        Set<String> visited=new HashSet<String>();
//	        updated.add(start);
//	        int s=1;
//	        visited.add(start);
//	        while(true)
//	        {
//				test(updated.getFirst(), hash, dict, updated, visited);
//			    if(hash.get(end)!=0)
//			        	return hash.get(end)+cd+ca;
//			    s=updated.size();
//			    if(s>1)
//			    	updated.removeFirst();
//			    else
//			    	break;
//	        }
//		    return -1;
//
//	 }
//	private static void test(String start, HashMap<String, Integer> hash, Set<String> dict, LinkedList<String> updated, Set<String> visited) {
//		int len=start.length();
//		char[] newWord=start.toCharArray();
//		for(int i=0; i<len; i++)
//        {
//        	for(int k=0; k<26; k++)
//        	{
//        		char ch=(char) ((int)'a'+k);
//        		newWord[i]=ch;
//        		String newStart=String.valueOf(newWord);
//        		if(dict.contains(newStart))
//        		{
//        			if(!visited.contains(newStart))
//        			{	
//        				updated.add(newStart);
//	        			hash.put(newStart, hash.get(start)+1);
//	        			visited.add(newStart);
//        			}
//        		}
//        	}
//        	newWord=start.toCharArray();
//        }
		
//	}
}
