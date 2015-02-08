package geeksForGeeks;

import leetCode.TreeNode;

public class VariantChildrenSum {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(60);
		root.left=new TreeNode(50);
		root.left.left=new TreeNode(30);
		root.left.left.left=new TreeNode(40);
		TreeNode rs=helper(root);
		System.out.println(rs.val);
	}
	public static TreeNode helper(TreeNode root)
	{
		if(root.left==null && root.right==null)
			return new TreeNode(0);
		TreeNode left=null;
		TreeNode right=null;
		int newSum=0;
		if(root.left!=null)
		{
			left=helper(root.left);
			if(root.val>root.left.val)
				newSum=newSum+left.val+root.left.val;
			else
				newSum+=left.val;	
		}
		
		if(root.right!=null)
		{
			right=helper(root.right);
			if(root.val>root.right.val)
				newSum=newSum+right.val+root.right.val;
			else
				newSum+=right.val;
		}
		TreeNode newRoot=new TreeNode(newSum);
		newRoot.left=left;
		newRoot.right=right;
		return newRoot;
	}

}
