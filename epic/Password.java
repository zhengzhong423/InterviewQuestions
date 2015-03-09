package epic;

import java.util.LinkedList;
import java.util.List;


public class Password {
	
	List<String> rs=new LinkedList<String>();
	
	public static void main(String[] args) {
		Password p=new Password();
		String src=p.getCh("zzzAEzzazPzazzlwzzzCzzzzAzz", 4);
		p.validPass(src, "", new int[src.length()]);
		System.out.println(p.rs);
	}
	public String getCh(String src, int N)
	{
		String rs="";
		int temp=N;
		while(N<src.length())
		{
			rs+=src.charAt(N-1);
			N+=temp;
		}
		return rs;
	}
	public boolean isVowel(char ch)
	{
		if(ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U')
			return true;
		return false;
	}
	public void validPass(String s, String temp, int[] visited)
	{
		if(temp.length()==s.length())
		{
			rs.add(temp);
			return;
		}
		for(int i=0; i<s.length(); i++)
		{
			if(visited[i]==0)
				if(temp.length()==0 || temp.length()==s.length()-1)
				{
					if(s.charAt(i)>='A' && s.charAt(i)<='Z')
					{
						visited[i]=1;
						String str=temp+s.charAt(i);
						validPass(s, str, visited);
						visited[i]=0;
					}
				}
				else if(s.length()%2==0 && (temp.length()==s.length()/2 || temp.length()==s.length()/2-1))
				{
					if(isVowel(s.charAt(i)))
					{
						visited[i]=1;
						String str=temp+s.charAt(i);
						validPass(s, str, visited);
						visited[i]=0;
					}
				}
				else
				{
					visited[i]=1;
					String str=temp+s.charAt(i);
					validPass(s, str, visited);
					visited[i]=0;
				}
		}
			
		
	}

}
