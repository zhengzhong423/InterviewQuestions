package recursive;

import java.util.Stack;

public class Hanoi {
	
	
	
	public static void main(String[] args)
	{
		Hanoi han=new Hanoi();
		
		Stack<Integer> a=new Stack<Integer>();
		Stack<Integer> b=new Stack<Integer>();
		Stack<Integer> c=new Stack<Integer>();
		Stack<Integer> d=new Stack<Integer>();
		
		for(int i=5; i>=1; i--)
			a.push(i);
		
		
		
		han.hanoi(a.size(), a, b, c, d);
	}
	
	public void hanoi(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c, Stack<Integer> d)
	{
		if(n==1)
		{
			System.out.println(a.peek()+" Move From "+ a +" To "+ d );
			d.push(a.pop());
			return;
		}
		if(n==2)
		{
			System.out.println(a.peek()+" Move From "+ a +" To "+ b );
			b.push(a.pop());
			
			System.out.println(a.peek()+" Move From "+ a +" To "+ d );
			d.push(a.pop());
			
			System.out.println(b.peek()+" Move From "+ b +" To "+ d );
			d.push(b.pop());
			
			return;
		}
		
		hanoi(n-2, a, c, d, b);
		System.out.println(a.peek()+" Move From "+ a +" To "+ c );
		c.push(a.pop());
		System.out.println(a.peek()+" Move From "+ a +" To "+ d );
		d.push(a.pop());
		System.out.println(c.peek()+" Move From "+ c +" To "+ d );
		d.push(c.pop());
		hanoi(n-2, b, a, c, d);
	}
	
}
