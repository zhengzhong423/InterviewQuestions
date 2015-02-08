package geeksForGeeks;

import java.util.ArrayList;

public class ArrayListTest {
	ArrayList<String> rs=new ArrayList<String>();
	public static void main(String[] args)
	{
		ArrayListTest a=new ArrayListTest();
		a.helper("101");
		System.out.println(a.rs);
	}
	public void helper(String input)
	{
		ArrayList<ArrayList<String>> opt=new ArrayList<ArrayList<String>>();
		int index=0;
		
		
		while(index<input.length())
		{
			int num1=Integer.parseInt(""+input.charAt(index));
			if(num1>0)
			{
				if(index==0)
				{
					ArrayList<String> temp=new ArrayList<String>();
					temp.add((char)(num1+'a'-1)+"");
					opt.add(temp);
				}
				if(index>0)
				{
					ArrayList<String> temp=new ArrayList<String>();
					for(String s: opt.get(index-1))
					{
						s=s+(char)(num1+'a'-1);
						temp.add(s);
					}
					opt.add(temp);
				}
			}
			
			if(index==0)
			{
				index++;
				continue;
			}
			
			int num2=num1+10*Integer.parseInt(""+input.charAt(index-1));
			if(num2<=26 && num2>=10)
			{
				if(index-2<0)
				{
					ArrayList<String> temp=new ArrayList<String>();
					temp.add((char)(num2+'a'-1)+"");
					if(opt.size()>index)
						opt.get(index).addAll(temp);
					else
						opt.add(temp);
				}
				else
				{
					ArrayList<String> temp=new ArrayList<String>();
					for(String s: opt.get(index-2))
					{
						s=s+(char)(num2+'a'-1);
						temp.add(s);
					}
					if(opt.size()>index)
						opt.get(index).addAll(temp);
					else
						opt.add(temp);
				}
			}
			index++;
		}
		rs=opt.get(input.length()-1);
	}
	public void helper(String input, int index, String temp)
	{
		if(index==input.length())
		{
			rs.add(temp);
			return;
		}
		
		int num1=Integer.parseInt(""+input.charAt(index));
		if(num1>0)
				helper(input, index+1, temp+(char)(num1+'a'-1));
		if(index<input.length()-1)
		{
			int num2 = num1*10+Integer.parseInt(""+input.charAt(index+1));
			if(num2<=26 && num2>=10)
				helper(input, index+2, temp+(char)(num2+'a'-1));
		}
	}
}
