package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBST2 {
	
	TreeNode header=new TreeNode(0);
	List<TreeNode> result=new LinkedList<TreeNode>();
	
	public static void main(String[] args) {
		UniqueBST2 u=new UniqueBST2();
		u.result=u.generateTrees(3);
	}
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    public List<TreeNode> helper(int left, int right)   //  recursion, return a TreeNode , a binary tree from num(left) to num(right)
    {
        List<TreeNode> temp=new LinkedList<TreeNode>(); // temp List 
        if(right<left)
            return temp;
        if(right==left)
        {
            temp.add(new TreeNode(right));
            return temp;
        }
        for(int i=left; i<=right; i++)  
        {
            //for each possible tree of left child, it could combine with each possible tree
            // of its right child. left child * right child
            List<TreeNode> tempLeft=helper(left, i-1);    //List of candidtate left child
            List<TreeNode> tempRight=helper(i+1, right);  //List of candidtate right child
            
            LinkedList<TreeNode> lastTemp=new LinkedList<TreeNode>();   // temp set for copy the result after adding right child
            
            if(tempLeft.size()==0)
            {
                TreeNode tempNode=new TreeNode(i);
                tempNode.left=null;
                lastTemp.add(tempNode); 
            }
            else
            {
                for(TreeNode k: tempLeft)               //add each possible left child to temp set
                {
                    TreeNode tempNode=new TreeNode(i);
                    tempNode.left=k;
                    lastTemp.add(tempNode);     
                }
            }
            //right child
            if(tempRight.size()==0)
            {
                for(TreeNode k: lastTemp)
                {
                    k.right=null; 
                	temp.add(k);
                }
            }
            else
            {
               
                for(TreeNode k: lastTemp)               //add each possible right child to each element in temp set
                {
                    for(TreeNode rightNode: tempRight)
                    {
                        TreeNode deep=deepCopy(k);
                        deep.right=rightNode;
                        temp.add(deep);
                    }    
                }
            }                      
        }
        return temp;
    }
    
    public  List<TreeNode> generateTrees2(int n) {
    	List<List<TreeNode>> result=new ArrayList<List<TreeNode>>();

    		List<TreeNode> start=new ArrayList<TreeNode>();
    		start.add(new TreeNode(1));
    		result.add(start);
    		
    	List<TreeNode> prev=result.get(0);
    	
    	for(int i=2; i<=n; i++)
    	{
	    	List<TreeNode> l=new ArrayList<TreeNode>();
	    	for(TreeNode t: prev)
	    	{
	    		TreeNode root=new TreeNode(i);
	    		root.left=t;
	    		l.add(root);
	    	}
	    	for(TreeNode t: prev)
	    	{
	    		TreeNode head=deepCopy(t);
	    		TreeNode temp=head;
	    		while(temp.right!=null)
	    		{
	    			temp=temp.right;
	    		}
	    		temp.right=new TreeNode(i);
	    		l.add(head);
	    	}
	    	for(TreeNode t: prev)
	    	{
	    		TreeNode GoRight=t;
	    		while(GoRight.right!=null)
	    		{
			    	TreeNode head=deepCopy(t);
			    	TreeNode temp=head;
			    	
			    	while(temp.val!=GoRight.val)
			    		temp=temp.right;
		    		TreeNode cur=new TreeNode(i);
		    		cur.left=GoRight.right;
		    		temp.right=cur;
		    		l.add(head);
		    		
		    		GoRight=GoRight.right;
	    		}
	    	}
	    	result.add(l);
	    	prev=result.get(i-1);
    	}
    	return result.get(n-1);
    }
    public TreeNode deepCopy(TreeNode root)
    {
    	if(root==null)
    		return null;
    	TreeNode t=new TreeNode(root.val);
    	t.left=deepCopy(root.left);
    	t.right=deepCopy(root.right);
    	return t;
    }
}
