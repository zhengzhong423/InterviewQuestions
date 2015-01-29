package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

	public static void main(String[] args) {
		int[] input={1,-1,2,3};
		ArrayList<TreeNode> inputList=new ArrayList<TreeNode>();
		for(int c:input)
			inputList.add(new TreeNode(c));
		buildTree(inputList);
		List<Integer> post=new LinkedList<Integer>();
		post=postorderTraversal(inputList.get(0));
		Iterator<Integer> iter=post.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		List<Integer> pre=new LinkedList<Integer>();
		pre=preorderTraversal(inputList.get(0));
		Iterator<Integer> iter2=pre.iterator();
		while(iter2.hasNext())
			System.out.println(iter2.next());
	}
	private static void buildTree(ArrayList<TreeNode> inputList) 
	{
		int count=0;
		for(TreeNode c:inputList)
		{
			if(c.val==-1)
				continue;
			count++;
			if(count*2-1<inputList.size())
				if(inputList.get(count*2-1).val!=-1)
				{
					c.left=inputList.get(count*2-1);
				}
			if(count*2<inputList.size())
				if(inputList.get(count*2).val!=-1)
				{
					c.right=inputList.get(count*2);
				}
		}
	}
	public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<TreeNode>();
        List<Integer> l=new LinkedList<Integer>();
        s.add(root);
        TreeNode pre=null;
        while(!s.isEmpty())
        {
        	TreeNode temp=s.peek();
        	if(temp.right==null && temp.left==null)
        	{
        		l.add(temp.val);
        		pre=temp;
        		s.pop();
        		continue;
        	}
        	if(pre!=null &&(temp.right==pre || temp.left==pre))
        	{
        		l.add(temp.val);
        		pre=temp;
        		s.pop();
        		continue;
        	}
        	if(temp.right!=null)
        		s.add(temp.right);
        	if(temp.left!=null)
        		s.add(temp.left);
        }
        return l;
    }
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<TreeNode>();
        List<Integer> l=new LinkedList<Integer>();
        if(root==null)
        	return l;
        s.add(root);
        while(!s.isEmpty())
        {
        	TreeNode temp=s.pop();
        	l.add(temp.val);
        	if(temp.right!=null)
        		s.add(temp.right);
        	if(temp.left!=null)
        		s.add(temp.left);
        }
        return l;
    }
}
