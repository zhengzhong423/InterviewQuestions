package epic;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
	List<String> rs=new LinkedList<String>();
	
	public static void main(String[] args)
	{
		Permutation p=new Permutation();
		String src="ABCjioe";
		p.helper("" ,p.rs ,src, new int[src.length()]);
		System.out.println(p.rs);
	}
	
	public void helper(String s, List<String> rs, String src, int visited[])
	{
		if(s.length()==src.length())
		{
			rs.add(s);
			return;
		}
		if(src.charAt(s.length())>='A' && src.charAt(s.length())<='Z')
		{
			String str=new String(s);
			str+=src.charAt(s.length());
			helper(str, rs, src, visited);
			return;
		}
		for(int i=0; i<src.length(); i++)
		{
					if(visited[i]==0 && (src.charAt(i)<'A' || src.charAt(i)>'Z'))
					{
						visited[i]=1;
						String str=new String(s);
						str+=src.charAt(i);
						helper(str, rs, src, visited);
						visited[i]=0;
					}
			
		}
	}
}
