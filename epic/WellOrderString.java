package epic;

import java.util.LinkedList;
import java.util.List;

public class WellOrderString {

	List<String> rs=new LinkedList<String>();
	int length;
	public static void main(String[] args) {
		WellOrderString w=new WellOrderString();
		System.out.println(w.permutation(6));
	}
	public List<String> permutation(int len)
	{
		this.length=len;
		helper(len);
		return rs;
	}
	public void helper(int len)
	{
		if(len==0)
			return;
		if(len==length)
		{
			for(int i=0; i<10; i++)
			{
				rs.add(String.valueOf((char)(i+'0')));
			}
			helper(len-1);
			return;
		}
		List<String> temp=new LinkedList<String>();
		for(String s:rs)
		{
			for(int i=(s.toLowerCase().charAt(s.length()-1)-'0'+1); i<10; i++)
			{
				temp.add(s+(char)('0'+i));
			}
		}
		rs.clear();
		rs.addAll(temp);
		helper(len-1);
	}

}
