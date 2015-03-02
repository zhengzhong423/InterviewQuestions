package geeksForGeeks;

import java.util.HashMap;
import java.util.Stack;

public class Caculator {
	
	static HashMap<String, Integer> hash=new HashMap<>();
	static{
		hash.put("+", 0);
		hash.put("-",	 0);
		hash.put("*", 1);
		hash.put("/", 1);
		hash.put("(", -1);
	}
	
	public static void main(String[] args) {
		
		Caculator c=new Caculator();
		System.out.println(c.GetPost("11+21*31+(41*51+61)*71"));
	}
	
	public  Stack<String> GetPost(String str)
	{
		Stack<String> rs=new Stack<>();
		Stack<String> op=new Stack<>();
		
		int digit=0;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*' || str.charAt(i)=='/')
			{
				rs.push(String.valueOf(digit));
				digit=0;
				addOp(op, rs, str.charAt(i));
			}
			else if(str.charAt(i)=='(' || str.charAt(i)==')')
			{
				addOp(op, rs, str.charAt(i));
			}
			else
				digit=digit*10+Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		rs.push(String.valueOf(digit));
		while(!op.isEmpty())
			rs.push(op.pop());
		return rs;
	}
	
	private void addOp(Stack<String> op, Stack<String> rs, char operator) {
		if(op.isEmpty())
		{
			op.add(String.valueOf(operator));
			return;
		}
		
		if(operator=='(')
			op.add(String.valueOf(operator));
		else if(operator==')')
		{
			while(!op.peek().equals("("))
				rs.add(op.pop());
			op.pop();
		}
		else
		{
			String cur=String.valueOf(operator);
			while(hash.get(op.peek())>=hash.get(cur))
			{
				rs.add(op.pop());
				if(op.isEmpty())
					break;
			}
			op.add(cur);
		}
			
		
	}
//
//	public Integer Caculate(Stack<Integer> s)
//	{
//		
//	}

}
