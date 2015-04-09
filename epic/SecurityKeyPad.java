package epic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SecurityKeyPad {
	
	static HashMap<Integer, HashSet<Integer>> hash=new HashMap<Integer, HashSet<Integer>>();
	static{
		hash.put(1, new HashSet<Integer>(Arrays.asList(new Integer[] {1,2,4})));
		hash.put(2, new HashSet<Integer>(Arrays.asList(new Integer[] {2,1,3,5})));
		hash.put(3, new HashSet<Integer>(Arrays.asList(new Integer[] {3,2,6})));
		hash.put(4, new HashSet<Integer>(Arrays.asList(new Integer[] {1,4,5,7})));
		hash.put(5, new HashSet<Integer>(Arrays.asList(new Integer[] {5,2,4,6,8})));
		hash.put(6, new HashSet<Integer>(Arrays.asList(new Integer[] {3,6,5,9})));
		hash.put(7, new HashSet<Integer>(Arrays.asList(new Integer[] {7,4,8})));
		hash.put(8, new HashSet<Integer>(Arrays.asList(new Integer[] {5,7,8,9})));
		hash.put(9, new HashSet<Integer>(Arrays.asList(new Integer[] {6,8,9})));
	}
	
	public static void main(String[] args)
	{
		SecurityKeyPad p=new SecurityKeyPad();
		
			System.out.println(p.helper("11115", "22247"));
			
		
	}
	public boolean helper(String s, String expect)
	{
		if(expect.length()!=s.length())
			return false;
		for(int i=0; i<s.length(); i++)
		{	
			if(!hash.get(Integer.parseInt(""+expect.charAt(i))).contains(Integer.parseInt(s.charAt(i)+"")))
				return false;
		}
		return true;
	}
	
	
	
}
