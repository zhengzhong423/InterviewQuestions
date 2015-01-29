package leetCode;

public class SumRoot {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
//		root.right=new TreeNode(5);
//		root.left.right=new TreeNode(9);
//		root.left.right.left=new TreeNode(9);
//		root.left.right.right=new TreeNode(5);
		System.out.print(sumNumbers(root));
	}
	public static
		int result;
	
	public static int sumNumbers(TreeNode root) 
	{
		 if(root==null)
		      return 0;
		 sumNumbers2(root, root.val);
		        return result;
       
    }
	public static void sumNumbers2(TreeNode root, int sum) 
	{
		if(root.left==null && root.right==null)
			result=result+sum;
		if(root.left!=null)
			sumNumbers2(root.left, sum*10+root.left.val);
		if(root.right!=null)
			sumNumbers2(root.right, sum*10+root.right.val);
	}
}
