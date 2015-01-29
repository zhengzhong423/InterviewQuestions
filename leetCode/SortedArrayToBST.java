package leetCode;

public class SortedArrayToBST {
	public static void main(String[] args) {
	
	}
	public TreeNode sortedArrayToBST(int[] num) {
        return arrayToBST(num, 0, num.length-1);
    }
	private TreeNode arrayToBST(int[] num, int start, int end)
	{
		if(end<start)
			return null;
		int mid=(start+end)/2;
		TreeNode root=new TreeNode(num[mid]);
		root.left=arrayToBST(num, start, mid-1);
		root.right=arrayToBST(num, mid+1, end);
		return root;
	}
}
