package epic;

import java.util.LinkedList;
import java.util.List;

public class ValidPhone {
	List<String> rs=new LinkedList<String>();
	int length=0;
	public static void main(String[] args) {
		ValidPhone v=new ValidPhone();
		System.out.println(v.helper(2));
	}
	public  List<String> helper(int n)
	{
		this.length=n;
		permutation(n);
		return this.rs;
	}
	public void permutation(int n)
	{
		if(n==0)
			return;
		if(n==length)
		{
			for(int i=0; i<10; i++)
				rs.add(String.valueOf(i));
			permutation(n-1);
			return ;
		}
		List<String> temp=new LinkedList<String>();
		for(int i=0; i<10; i++)
		{
			for(String str:rs)
			{
				if(Integer.parseInt(""+str.charAt(str.length()-1))!=i)
				{
					if(i==4)
					{
						if(str.charAt(0)=='4')
							temp.add(str+String.valueOf(i));
					}
					else
						temp.add(str+String.valueOf(i));
				}
			}
		}
		rs.clear();
		rs.addAll(temp);
		permutation(n-1);
	}

}
