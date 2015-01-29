package chapter8_recursive;

import java.util.ArrayList;

public class Parentheses {

	public static void main(String[] args) {
		ArrayList<String> a=new ArrayList<String>();
		String str="";
		getParentheses(10, 10, a, str);
		System.out.println(a);
		System.out.println(a.size());
	}
	public static void getParentheses(int l, int r, ArrayList<String> a, String str)
	{
		if(l==0 && r==0)
		{
			a.add(str);
			return;
		}
		else
		{
			if(r==l && l>0)
			{
				str+="(";
				getParentheses(l-1, r, a ,str);
				str=str.substring(0, str.length()-1);
			}
			if(r>l)
			{
				if(l>0)
				{
					str+="(";
					getParentheses(l-1, r, a, str);
					str=str.substring(0, str.length()-1);
				}
				if(r>0)
				{
					str+=")";
					getParentheses(l, r-1, a, str);
					str=str.substring(0, str.length()-1);
				}
			}
		}
	}
}
