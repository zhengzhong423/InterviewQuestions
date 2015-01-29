package geeksForGeeks;
import leetCode.TreeNode;
/**
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 * @author dell
 * 
 */
public class AddGreaterValues {
	static int sum=0;
	public static void main(String[] args) {
		TreeNode root=null;
		root = insert(root, 50);
	    insert(root, 30);
	    insert(root, 20);
	    insert(root, 40);
	    insert(root, 70);
	    insert(root, 60);
	    insert(root, 80);
	    helper(root);
	    print(root);	
	}
	public static void print(TreeNode root)
	{
		if(root==null)
			return;
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}
	public static void helper(TreeNode root)
	{
		if(root==null)
			return;
		helper(root.right);
		sum+=root.val;
		root.val=sum;
		helper(root.left);
	}
	public static TreeNode insert(TreeNode root, Integer num)
	{
		if(root==null)	return new TreeNode(num);
		if(num>root.val)
			root.right=insert(root.right, num);
		else
			root.left=insert(root.left, num);
		return root;
	}
	

}
