import java.util.Stack;


public class SortStack {

	public static void main(String[] args)
	{
		SortStack a=new SortStack();
		Stack<Integer> s=new Stack<Integer>();
		a.insert(s,12);
		a.insert(s,6);
		a.insert(s,8);
		a.insert(s,10);
		System.out.println(s);
	}
	public void insert(Stack<Integer> s, int num)
	{
		Stack<Integer> temp=new Stack<Integer>();
		if(!s.isEmpty())
		{
		while(s.peek()>=num)
		{
				temp.push(s.pop());
				if(s.isEmpty())
				{
					break;
				}
		}
		s.push(num);
		while(!temp.isEmpty())
		{
			s.push(temp.pop());
		}
		}
		else
			s.push(num);
	}
}
