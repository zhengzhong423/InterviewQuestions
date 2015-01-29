
public class MinHeightBinaryTree {

	public static void main(String[] args)
	{
		MinHeightBinaryTree m=new MinHeightBinaryTree();
		BinaryTree a=new BinaryTree();
		int arr[]={1,2,3,4,5,6,7,8};
		m.MinHeight(a, arr, 0, arr.length-1);
		a.BFS(a);
	}
	public void MinHeight(BinaryTree a, int[] arr, int start, int end)
	{
		if(start>end)
		{
			return;
		}
		int mid=(start+end)/2;
		a.num=arr[mid];
		a.left=new BinaryTree();
		MinHeight(a.left, arr, start, mid-1);
		if(start>mid-1)
			a.left=null;
		a.right=new BinaryTree();
		MinHeight(a.right, arr, mid+1, end);
		if(mid+1>end)
			a.right=null;
	}
}
