package geeksForGeeks;

import leetCode.TreeNode;


public class MirrorTree {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.right=new TreeNode(3);
		root=mirror(root);
	}
	public static TreeNode mirror(TreeNode root)
	{
		if(root==null)
			return null;
		TreeNode left=mirror(root.left);
		TreeNode right=mirror(root.right);
		root.left=right;
		root.right=left;
		return root;
	}

}
