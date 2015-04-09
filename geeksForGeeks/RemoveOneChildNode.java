package geeksForGeeks;

import leetCode.TreeNode;

public class RemoveOneChildNode {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(7);
		root.left.right=new TreeNode(6);
		root.left.right.left=new TreeNode(1);
		root.left.right.right=new TreeNode(11);
		root.right=new TreeNode(5);
		root.right.right=new TreeNode(9);
		root.right.right.left=new TreeNode(4);
		
		TreeNode rs=new RemoveOneChildNode().helper(root);
		
		System.out.println(rs.right.val);
	}
	
	public TreeNode helper(TreeNode root)
	{
		if(root==null)
			return root;
		if(root.left==null && root.right==null)
			return root;
		if(root.left!=null && root.right!=null)
		{
			root.left=helper(root.left);
			root.right=helper(root.right);
			return root;
		}
		return root.left==null ? helper(root.right) : helper(root.left);
	}

}
