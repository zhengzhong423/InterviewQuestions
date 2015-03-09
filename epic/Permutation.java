package epic;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
	List<String> rs=new LinkedList<String>();
	
	public static void main(String[] args)
	{
		Permutation p=new Permutation();
		String src="ABC";
		p.helper(src, new StringBuffer(), new int[src.length()]);
		System.out.println(p.rs);
	}
	
	public void helper(String src, StringBuffer temp, int[] visited)
	{
		if(temp.length()==src.length())
		{
			rs.add(temp.toString());
			return;
		}
		if(src.charAt(temp.length())>='A' && src.charAt(temp.length())<='Z')
		{
			StringBuffer sb=new StringBuffer(temp);
			sb.append(src.charAt(temp.length()));
			helper(src, sb, visited);
			return;
		}
		for(int i=0; i<src.length(); i++)
			if(visited[i]==0 && (src.charAt(i)<'A' || src.charAt(i)>'Z'))
			{
				visited[i]=1;
				StringBuffer sb=new StringBuffer(temp);
				sb.append(src.charAt(i));
				helper(src, sb, visited);
				visited[i]=0;
			}
					
			
	}
}
