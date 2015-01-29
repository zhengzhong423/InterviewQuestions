package leetCode;

public class TreeMaxSum {

	public static void main(String[] args) {
		

	}
	int maxValue=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root)
	{
		if(root==null)
			return 0;
		getMaxPathSum(root);
		return maxValue;
	}
	public int getMaxPathSum(TreeNode root) 
	{
	      if(root==null)
	    	  return 0;
	      int l=Math.max(0, getMaxPathSum(root.left));
	      int r=Math.max(0, getMaxPathSum(root.right));
	      maxValue=Math.max(maxValue, l+r+root.val);
	      return l+r+root.val;
	}
	
}
