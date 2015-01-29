package geeksForGeeks;

public class DimeterBinaryTree {
	public interface Vegetarian{}
	public class Animal{}
	public class Deer extends Animal implements Vegetarian{}
	Deer d = new Deer();
	Animal a = d;
	Vegetarian v = d;
	Object o = d;
	
	class TreeNode
	{
		TreeNode left;
		TreeNode right;
		public TreeNode()
		{}
	}
	int max;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DimeterBinaryTree d=new DimeterBinaryTree();
		TreeNode root =d.new TreeNode();
		  root.left        = d.new TreeNode();
		  root.right       =d. new TreeNode();
		  root.left.left  = d.new TreeNode();
		  root.left.right =d. new TreeNode();
		  d.getDiameter(root);
		  System.out.println(d.max);
	}
	public int getDiameter(TreeNode root)
	{
		if(root==null)
			return -1;
		int left=1+getDiameter(root.left);
		int right=1+getDiameter(root.right);
		max=Math.max(left+right+1, max);
		return Math.max(left, right);
	}
	
}
