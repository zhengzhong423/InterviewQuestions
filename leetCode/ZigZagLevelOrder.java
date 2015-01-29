package leetCode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrder {
	Queue<TreeNode> q=new LinkedList<TreeNode>();
    TreeNode dummy=new TreeNode(0);
    int layer=0;
    
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
	}
    public  List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        q.add(root);
        q.add(dummy);
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(root==null)
            return result;
        helper(root, result);
        return result;
    }
    public void helper(TreeNode root, List<List<Integer>> result)
    {
        List<Integer> thisLayer=new LinkedList<Integer>();
        Stack<Integer> s=new Stack<Integer>();
        while(q.size()>1)
        {
            TreeNode temp=q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                    
                if(temp.right!=null)
                    q.add(temp.right);
           
            if(temp.val==0 && temp.left==null && temp.right==null)
            {
                q.add(dummy);
                layer++;
                while(!s.isEmpty())
                    thisLayer.add(s.pop());
                result.add(new LinkedList<Integer>(thisLayer));
                thisLayer.clear();
                s.clear();
            }
            else
                if(layer%2==0)
                    thisLayer.add(temp.val);
                else
                    s.add(temp.val);
        } 
        while(!s.isEmpty())
            thisLayer.add(s.pop());
        result.add(new LinkedList<Integer>(thisLayer));
    }
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        Queue<TreeNode> next=new LinkedList<TreeNode>();
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(root==null)
        	return result;
        int layer=0;
        q.add(root);
        while(!q.isEmpty())
        {
        	List<Integer> temp=new LinkedList<Integer>();
        	Stack<Integer> s=new Stack<Integer>();
        	while(!q.isEmpty())
        	{
        		if(q.peek().left!=null)
        			next.add(q.peek().left);
        		if(q.peek().right!=null)
        			next.add(q.peek().right);
        		if(layer%2==0)
        			temp.add(q.poll().val);
        		else
        			s.add(q.poll().val);
        	}
        	if(layer%2!=0)
        		while(!s.isEmpty())
        			temp.add(s.pop());
        	q.addAll(new LinkedList<TreeNode>(next));
        	next.clear();
        	layer++;
        	result.add(temp);
        }
        return result;
    }
}
