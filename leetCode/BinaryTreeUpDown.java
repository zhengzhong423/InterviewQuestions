package leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUpDown {

	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		
		BinaryTreeUpDown bt=new BinaryTreeUpDown();
		root=bt.UpSideDown(root);
		bt.traverse(root);
	}
	
	//Iteration
	public TreeNode UpSideDown(TreeNode root)
	{
		Stack<TreeNode> s=new Stack<TreeNode>();
		TreeNode cur=root;
		while(cur.left!=null)
		{
			s.push(cur);
			cur=cur.left;
		}
		root=cur;
		while(!s.isEmpty())
		{
			TreeNode node=s.pop();
			cur.left=node.right;
			cur.right=node;
			node.left=null;
			node.right=null;
			cur=node;
		}
		return root;
	}
	
	public void traverse (TreeNode root)
	{
		List<TreeNode> cur=new LinkedList<TreeNode>();
		cur.add(root);
		while(!cur.isEmpty())
		{
			List<TreeNode> next=new LinkedList<TreeNode>();
			boolean elem=false;
			while(!cur.isEmpty())
			{
				TreeNode node=cur.remove(0);
				if(node==null)
				{
					System.out.print("#"+" , ");
					continue;
				}
				else
					System.out.print(node.val+" , ");
				if(node.left!=null)
					elem=true;
				next.add(node.left);
				
				if(node.right!=null)
					elem=true;
				next.add(node.right);
			}
			cur.addAll(next);
			if(!elem)
				break;
		}
	}

}
