package leetCode;

import java.util.Stack;

public class FlattenBinaryTree {
	
	TreeNode previous=new TreeNode(0);
	
	public static void main(String[] args) {
		
	}
	Stack<TreeNode> s=new Stack<TreeNode>();
    public void flatten(TreeNode root) 
    {
        if(root==null)
            return ;
        TreeNode cur=root;
        while(true)
        {
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
            {
                cur.right=cur.left;
            	cur.left=null;
            }
            else
            {
                if(s.isEmpty())
                    break;
                else
                    cur.right=s.pop();
            }
            cur=cur.right;
        }
    }

}
