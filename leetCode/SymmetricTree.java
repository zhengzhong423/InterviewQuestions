package leetCode;

public class SymmetricTree {

	public static void main(String[] args) {
	}
	 public boolean isSymmetric(TreeNode root) 
	 {
		 if(root==null)
			 return true;
		 reverse(root.right);
		 return compare(root.left, root.right);
	 }
	 private boolean compare(TreeNode left, TreeNode right) {
		if(left==null && right==null)
			return true;
		if(left==null && right!=null)
			return false;
		if(right==null && left!=null)
			return false;
		if(left.val!=right.val)
			return false;
		return compare(left.left, right.left)&&compare(left.right, right.right);
	}
	public void reverse(TreeNode root)
	 {
		 if(root==null)
			 return;
		 TreeNode temp=root.left;
		 root.left=root.right;
		 root.right=temp;
		 reverse(root.left);
		 reverse(root.right);
	 }
}
