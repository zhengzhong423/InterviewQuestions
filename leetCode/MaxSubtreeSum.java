package leetCode;

public class MaxSubtreeSum {

	 int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		TreeNode t=new TreeNode(2);
		t.left=new TreeNode(-1);
		MaxSubtreeSum mss=new MaxSubtreeSum();
		System.out.println(mss.maxPathSum(t));
	}
	
	    
	    public int maxPathSum(TreeNode root) {
	        helper(root);
	        return max;
	    }
	    public int helper(TreeNode root)
	    {
	        if(root==null)
	            return 0;
	        
	        int re=root.val;
	        max=Math.max(max, root.val);
	        
	        int left=0;
	        if(root.left!=null)
	        {
	            left=maxPathSum(root.left);
	            max=Math.max(max, root.val+left);
	            re=Math.max(re, root.val+left);
	        }
	        
	        int right=0;    
	        if(root.right!=null)
	        {
	            right=maxPathSum(root.right);
	            max=Math.max(max, root.val+right);
	            re=Math.max(re, root.val+right);
	        }
	        
	        if(left!=0 && right!=0)
	            max=Math.max(max, root.val+left+right);
	        
	        return re;
	    }

}
