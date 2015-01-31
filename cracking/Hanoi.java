package cracking;
import java.util.*;


public class Hanoi {

	public static void main(String[] args) {
		Hanoi hanoi=new Hanoi();

		int n=3;
		Stack<Integer> a=new Stack<Integer>();
		Stack<Integer> b=new Stack<Integer>();
		Stack<Integer> c=new Stack<Integer>();
		for(int i=1;i<=n;i++)
		{
			a.push(i);
		}
		hanoi.move(n,a,b,c);
		System.out.println(c);
	}

	private void move(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c)
	{
		if(n<=1)
			c.push(a.pop());
		else
		{
			move(n-1,a,c,b);
			c.push(a.pop());
			move(n-1,b,a,c);
		}
	}

}
