package hackerank;

import java.util.*;

public class Dfs {
	public static void main(String[] args) {
		HashMap<String, LinkedList<String>> hash=new HashMap<String, LinkedList<String>>();
		LinkedList<String> l=new LinkedList<String>();
		l.add("wa");
		l.add("ma");
		
		hash.put("la", new LinkedList<String>(l));
		l.clear();
		l.add("la");
		l.add("oa");
		l.add("china");
		hash.put("ma",  new LinkedList<String>(l));
		l.clear();
		l.add("tx");
		l.add("cancun");
		hash.put("oa", new LinkedList<String>(l));
		System.out.println(ifCan("la","tx", hash, new HashSet<String>()));
	}
	public static boolean ifCan(String s, String des, HashMap<String, LinkedList<String>> hash, HashSet<String> visited)
	{
		boolean result=false;
		HashSet<String> newVisited=new HashSet<String>(visited);
		if(hash.containsKey(s))
		{
			LinkedList<String> l=hash.get(s);
			if(l.contains(des))
				return true;
			for(String str:l)
			{
				if(visited.contains(str))
					continue;
				newVisited.add(str);
				result=result || ifCan(str, des, hash, newVisited);
			}
			return result;
			
		}
		return false;
		
	}
	

}
