package geeksForGeeks;

import java.util.LinkedList;

public class StreamNumber {

	public static void main(String[] args) {
		StreamNumber sn=new StreamNumber();
		String str="geeksforgeeksisrabbish";
		sn.helper(str);
	}
	
	public void helper(String str)
	{
		boolean secondVisit[]=new boolean[256];
		boolean firstVisit[]=new boolean[256];
		LinkedList<Character> rs=new LinkedList<Character>();
		for(int i=0; i<str.length(); i++)
		{
			char ch=str.charAt(i);
			if(!secondVisit[(int)ch])
			{
				if(!firstVisit[(int)ch])
				{
					firstVisit[(int)ch]=true;
					rs.add(ch);
				}
				else
				{
					secondVisit[(int)ch]=true;
					rs.remove((Character)ch);
				}
			}
			System.out.println(rs.peek());
		}
	}

}
