package leetCode;

public class VlidateBST {
	public static void main(String[] args)
	{
		VlidateBST v=new VlidateBST();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(1);
		System.out.println(v.isValidBST(root));
	}
	public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	 }
	public boolean helper(TreeNode root, long max, long min)
	{
	    if(root.val==Integer.MAX_VALUE && root.right!=null)
	    	return false;
	    if(root.val==Integer.MIN_VALUE && root.left!=null)
	    	return false;
		if(max!=Integer.MAX_VALUE && root.val>=max )
			return false;
		if( root.val<=min && min!=Integer.MIN_VALUE  )
			return false;
		if(root.left==null && root.right==null)
			return true;
		if(root.left!=null && root.right==null)
			return helper(root.left, root.val, min);
		if(root.right!=null && root.left==null)
			return helper(root.right, max, root.val);
		return helper(root.left, root.val, min) && helper(root.right, max, root.val);
	}
}
