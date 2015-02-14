package geeksForGeeks;

import java.util.LinkedList;
import java.util.List;


public class InvertingBinaryTree {

	class InvertTreeNode{
		int val;
		InvertTreeNode left;
		InvertTreeNode right;
		InvertTreeNode parent;
		public InvertTreeNode(int num)
		{
			this.val=num;
		}
	}
	public static void main(String[] args) {
		InvertingBinaryTree k=new InvertingBinaryTree();
		InvertTreeNode root=k.new InvertTreeNode(0);
		root.left=k.new InvertTreeNode(1);
		root.right=k.new InvertTreeNode(2);
		root.right.left=k.new InvertTreeNode(3);
		InvertTreeNode observe=k.new InvertTreeNode(4);
		root.right.right=observe;
		helper(root);
	}
	public static void helper(InvertTreeNode root)
	{
		List<InvertTreeNode> l=new LinkedList<>();
		traverse(root, l);
		while(!l.isEmpty())
		{
			InvertTreeNode temp=l.remove(0);
			while(temp.parent!=null)
			{
				if(temp.parent.left==temp)
				{
					temp.right=temp.parent;
					temp.parent.left=null;
				}
				else
				{
					temp.left=temp.parent;
					temp.parent.right=null;
				}
				InvertTreeNode k=temp;
				temp=temp.parent;
				k.parent=null;
			}
		}
	}
	private static void traverse(InvertTreeNode root, List<InvertTreeNode> l) {
		if(root.left==null && root.right==null)
			l.add(root);
		if(root.left!=null)
		{
			traverse(root.left, l);
			root.left.parent=root;
		}
		if(root.right!=null)
		{
			traverse(root.right, l);
			root.right.parent=root;
		}
	}
	

}
