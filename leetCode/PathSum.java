package leetCode;

public class PathSum {

	public static void main(String[] args) {
		

	}
	public boolean hasPathSum(TreeNode root, int sum) 
	{
		if(root==null)
			return false;
		if(root.left==null && root.right==null & sum==root.val)
			return true;
		if(root.left==null && root.right==null & sum!=root.val)
			return false;
		return hasPathSum(root.right, sum-root.val) || hasPathSum(root.left, sum-root.val);
    }
}
