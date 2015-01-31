package cracking;
import java.util.ArrayList;
import java.util.Stack;


public class stackOperation {

	public static void main(String[] args) 
	{
		stackOperation o=new stackOperation();
		ArrayList<Stack<Integer>> a=new ArrayList<Stack<Integer>>();
		Stack<Integer> s=new Stack<Integer>();
		int cap=3;
		s.push(0);
		s.push(1);
		s.push(2);
		o.insert(a,s,cap);
		s.push(4);
		s.push(5);
		s.push(6);
		o.insert(a, s, cap);
		o.push(a, 0, 2, 7, cap);
		System.out.println(a);
		}
	@SuppressWarnings("unchecked")
	public void insert(ArrayList<Stack<Integer>> a, Stack<Integer> s, int cap)
	{
		Stack<Integer> temp=new Stack<Integer>();
		temp=(Stack<Integer>) s.clone();
		a.add(temp);
		s.clear();
	}
	public Integer pop(ArrayList<Stack<Integer>> a)
	{
		Stack<Integer> temp=a.get(a.size()-1);
		Integer r=temp.pop();
		if(temp.isEmpty())
		{
			a.remove(a.size()-1);
		}
		return r;
	}
	public void push(ArrayList<Stack<Integer>> a, int index, int num, int element ,int cap)
	{
		
		ArrayList<Stack<Integer>> temp=new ArrayList<Stack<Integer>>();
		int k=a.size()-1;
		for(int i=index;i<=k;i++)
		{
			temp.add(a.get(index));
			a.remove(index);
		}
		Stack<Integer> stack=temp.get(0);
		temp.remove(0);
		Stack<Integer> tempstack=new Stack<Integer>();
		Stack<Integer> result=new Stack<Integer>();
		for(int i=0;i<num;i++)
		{
			tempstack.push(stack.pop());
		}
		result=tempstack;
		result.push(element);
		while(temp.size()!=0 || stack.isEmpty()==false)
		{
			if(result.size()==cap)
			{
				addResult(a,result,cap);
			}
			else
			{
				if(stack.isEmpty()==false)
				{
					result.push(stack.pop());
				}
					else
				{
					stack=temp.get(0);
					temp.remove(0);
				}
			}
		}
		addResult(a,result,cap);
	}

@SuppressWarnings("unchecked")
private void addResult(ArrayList<Stack<Integer>> a, Stack<Integer> result,int cap)
	{
		Stack<Integer> temp=new Stack<Integer>();
		temp= (Stack<Integer>) result.clone();
		a.add(temp);
		int k=result.size();
		for(int j=0;j<k;j++)
			result.pop();
	}

}
