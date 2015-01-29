package geeksForGeeks;

import leetCode.TreeNode;


public class MirrorTree {

	public static void main(String[] args) {

	}
	public static TreeNode mirror(TreeNode root)
	{
		if(root==null)
			return null;
		TreeNode rs=new TreeNode(root.val);
		rs.left=mirror(root.right);
		rs.right=mirror(root.left);
		return rs;
	}

}
