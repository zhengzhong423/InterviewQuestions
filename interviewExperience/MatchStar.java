package interviewExperience;

import java.util.LinkedList;
import java.util.List;

public class MatchStar {
	static List<String> rs=new LinkedList<String>();
	
	public static void main(String[] args) {
		helper(0, "", "1*1*");
		System.out.println(rs);
	}
	
	public static void helper(int index, String temp, String s)
	{
		for(int i=index; i<s.length(); i++)
		{
			if(s.charAt(i)=='*')
			{
				helper(i+1, temp+"0", s);
				helper(i+1, temp+"1", s);
			}
			else
				temp=temp+s.charAt(i);
		}
		if(temp.length()==s.length())
			rs.add(temp);
	}

}
