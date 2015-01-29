package leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parentheses {

	public static void main(String[] args) {
		
Stack<Integer> s=new Stack<Integer>();
s.pop();
	}
	 public List<String> generateParenthesis(int n) {
		 List<String> result= new LinkedList<String>();
	        helper(0,0,n,"", result);
	       return result;
	    }
	 public void helper(int l, int r, int n ,String temp, List<String> result)
	 {
		 if(l==n && r==n)
		 {
			 result.add(new String(temp));
			 return;
		 }
		 if(l<=n && l<=r)
		 {
			 temp+="(";
			 helper(l+1, r, n, temp, result);
			 temp=temp.substring(0, temp.length()-1);
		 }
		 if(l<=n && l>r)
		 {
			 temp+=")";
			 helper(l, r+1, n, temp, result);
			 temp=temp.substring(0, temp.length()-1);
		 }
	 }
}
