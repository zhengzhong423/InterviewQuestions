package chapter2_binaryTree;

import java.util.ArrayList;

public class SubSumBinary {
	public static void main(String args[])
	{
		BinaryTree root=new BinaryTree(3);
		root.addNode(root, 5);
		root.addNode(root, 7);
		root.addNode(root, 1);
		root.addNode(root, 2);
		root.addNode(root, 4);
		root.addNode(root, 6);
		root.addNode(root, 8);
		root.getLayer(root, 0);
	//	root.printLayer(root);
		ArrayList<Integer> a=new ArrayList<Integer>();
		getSubSum(root, a, 3);
	}
	public static void getSubSum(BinaryTree node, ArrayList<Integer> a, int sum)
	{
		if(node==null)
			return;
		a.add(node.num);
		int p=sum;
		for(int i=a.size(); i>0; i--)
		{
			p=p-a.get(i-1);
			if(p==0)
			{
				putOut(a,i);
			}
		}
		ArrayList<Integer> temp1=new ArrayList<Integer>(a);
		ArrayList<Integer> temp2=new ArrayList<Integer>(a);
		getSubSum(node.left, temp1, sum);
		getSubSum(node.right, temp2, sum);
	}
	private static void putOut(ArrayList<Integer> a, int i) {
		for(int j=a.size(); j>=i; j--)
			System.out.print(a.get(j-1)+" ");
		System.out.println();
	}
}
