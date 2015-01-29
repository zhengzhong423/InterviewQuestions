package leetCode;

import java.util.*;

public class LongestParenthesis {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())()()("));

	}
	public static int longestValidParentheses(String str) {
        Stack<Integer> s=new Stack<Integer>();
        int start=0;
        int max=0;
        for(int i=0; i<str.length(); i++)
        {
            int count=0;
            if(str.charAt(i)=='(')
                s.push(i);
            else if(s.isEmpty() && str.charAt(i)==')')
                   		start=i;
                else if(!s.isEmpty())
                {
                	s.pop();
                	if(!s.isEmpty())
                		count=i-s.peek();
                	else
                		count=i-start;
                }
            max=Math.max(max, count);
        }
        return max;
    }

}
