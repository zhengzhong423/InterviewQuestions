package epic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	HashMap<Character, Integer> hash=new HashMap<>();
	
	public static void main(String[] args) {
		Calculator c=new Calculator();
		c.init();
		System.out.println(c.helper("1*2+3*4"));
	}
	
	public void init()
	{
		hash.put('+', 0);
		hash.put('-', 0);
		hash.put('*', 1);
		hash.put('/', 1);
	}
	public int helper(String s)
	{
		List<String> rs=new LinkedList<String>();
		Stack<Character> opS=new Stack<Character>();
		char[] ch=s.toCharArray();
		
		int num=0;
		
		for(int i=0; i<ch.length; i++)
		{
			if(ch[i]>='0' && ch[i]<='9')
				num=num*10+Integer.parseInt(""+ch[i]);
			else if(ch[i]=='+' || ch[i]=='-' || ch[i]=='*' || ch[i]=='/')
			{
				rs.add(String.valueOf(num));
				num=0;
				addOp(ch[i], opS, rs);
			}
		}
		rs.add(String.valueOf(num));
		while(!opS.isEmpty())
			rs.add(opS.pop()+"");
		
		return postFixCal(rs);
	}
	private int postFixCal(List<String> rs) {
		Stack<Integer> s=new Stack<Integer>();
		for(String str: rs)
		{
			if(str.equals("+"))
				s.add(s.pop()+s.pop());
			else if(str.equals("-"))
				s.add(-(s.pop()-s.pop()));
			else if(str.equals("*"))
				s.add(s.pop()*s.pop());
			else if(str.equals("/"))
				s.add(1/(s.pop()/s.pop()));
			else
				s.add(Integer.parseInt(str));
		}
		return Integer.valueOf(s.pop());
	}

	private void addOp(char c, Stack<Character> opS, List<String> rs) {
		if(opS.isEmpty())
		{
			opS.add(c);
			return ;
		}
		else 
		while(!opS.isEmpty() && hash.get(c)<=hash.get(opS.peek()))
			rs.add(opS.pop()+"");
		opS.add(c);
	}

}
