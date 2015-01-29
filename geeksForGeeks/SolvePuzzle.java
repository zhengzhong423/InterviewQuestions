package geeksForGeeks;

import java.util.*;

public class SolvePuzzle {
	HashMap<Character, Integer> hash=new HashMap<>();
	HashSet<Character> set=new HashSet<>();
	String s1="send";
	String s2="more";
	String s3="money";
	
	public static void main(String[] args) {
		SolvePuzzle sp=new SolvePuzzle();
		sp.getChar(sp.s1,sp.s2, sp.s3);
		ArrayList<Character> a=new ArrayList<>();
		Iterator<Character> iter=sp.set.iterator();
		while(iter.hasNext())
			a.add(iter.next());
		sp.assign(a);
	}
	public void getChar(String s1, String s2, String s3)
	{
		for(int i=0; i<s1.length(); i++)
			set.add(s1.charAt(i));

		for(int i=0; i<s2.length(); i++)
			set.add(s2.charAt(i));

		for(int i=0; i<s3.length(); i++)
			set.add(s3.charAt(i));
			
	}
	public void assign(ArrayList<Character> toAssign)
	{
		if(toAssign.size()==0)
		{
			test();
			return;
		}
		for(int i=0; i<=9; i++)
			if(!hash.containsValue(i))
			{
				hash.put(toAssign.get(0), i);
				ArrayList<Character> ar=new ArrayList<Character>(toAssign);
				ar.remove(0);
				assign(ar);
				hash.remove(toAssign.get(0));
			}
			
	}
	public void test() 
	{
		String newS1="";
		for(int i=0; i<s1.length(); i++)
		{
			if(i==0 && hash.get(s1.charAt(0))==0)
				return;
			newS1=newS1+hash.get(s1.charAt(i));
		}
		
		String newS2="";
		for(int i=0; i<s2.length(); i++)
		{
			if(i==0 && hash.get(s2.charAt(0))==0)
				return;
			newS2=newS2+hash.get(s2.charAt(i));
		}
		
		String newS3="";
		for(int i=0; i<s3.length(); i++)
		{
			if(i==0 && hash.get(s3.charAt(0))==0)
				return;
			newS3=newS3+hash.get(s3.charAt(i));
		}

		
		if(Integer.parseInt(newS1)+Integer.parseInt(newS2)==Integer.parseInt(newS3))
			System.out.println(newS1+"+"+newS2+"="+newS3);
	}
	

}
