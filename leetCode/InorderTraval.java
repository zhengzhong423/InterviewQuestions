package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraval {

	public static void main(String[] args) {

	}
	public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<TreeNode>();
        List<Integer> result=new LinkedList<Integer>();
        HashSet<TreeNode> hash=new HashSet<TreeNode>();
        if(root==null)
        	return result;
        s.add(root);
        while(!s.isEmpty())
        {
        	while(s.peek().left!=null && !hash.contains(s.peek().left))
        	{
        		hash.add(s.peek().left);
        		s.add(s.peek().left);
        	}
        	result.add(s.peek().val);
        	if(s.peek().right!=null && !hash.contains(s.peek().right))
        	{
        		hash.add(s.peek().right);
        		s.add(s.peek().right);
        		
        	}
        	s.pop();
        }
        return result;
    }


}
