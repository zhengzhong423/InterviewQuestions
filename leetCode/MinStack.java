package leetCode;

import java.util.Stack;

public class MinStack {
	Stack<Integer> s=new Stack<Integer>();
	Stack<Integer> minStack=new Stack<Integer>();
	public static void main(String[] args) {
		MinStack s=new MinStack();
		s.push(512);
		s.push(-1024);
		s.push(-1024);
		s.push(512);
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
	}
	    
	public void push(int x) {
        s.push(x);
        if(minStack.isEmpty())
            minStack.push(x);
        else
        {
            if(x<=minStack.peek())
                minStack.push(x);
        }
    }

    public void pop() {
    	int num=minStack.peek();
    	int num1=s.peek();
        if(num==num1)
            minStack.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
