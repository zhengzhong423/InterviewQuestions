package cracking;

import leetCode.TreeNode;

public class LowestCommonAncester {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
		root.right=new TreeNode(2);
		root.left.right=new TreeNode(3);
		root.left.left=new TreeNode(5);
		root.right.right=new TreeNode(4);
		
		LowestCommonAncester lca=new LowestCommonAncester();
		System.out.println(lca.LCA(3, 5, root).val);
	}
	
	public TreeNode LCA(int t1, int t2, TreeNode cur)
	{
		if(cur==null)
			return cur;
		if(cur.val==t1)
			return cur;
		if(cur.val==t2)
			return cur;
		TreeNode left=LCA(t1, t2, cur.left);
		TreeNode right=LCA(t1, t2, cur.right);
		if(left==null && right==null)
			return null;
		if(left!=null && right!=null)
			return cur;
		return left==null? right: left;
	}

}
