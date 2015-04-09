package geeksForGeeks;

import leetCode.TreeNode;

public class BSTwithPreorder {

	int cur=-1;
	
	public static void main(String[] args) {
		int[] preOrder={10, 5, 1, 7, 40, 50};
		BSTwithPreorder b=new BSTwithPreorder();
		TreeNode root=b.helper(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(root.val);
	}
	
	public TreeNode helper(int[] preOrder, int min, int max)
	{
		cur++;
		if(cur<preOrder.length && preOrder[cur]>min && preOrder[cur]<max)
		{	
			TreeNode root=new TreeNode(preOrder[cur]);
			root.left=helper(preOrder, min, preOrder[cur]);
			root.right=helper(preOrder, preOrder[cur], max);
			return root;
		}
		else
		{
			cur--;
			return null;
		}
	}

}
