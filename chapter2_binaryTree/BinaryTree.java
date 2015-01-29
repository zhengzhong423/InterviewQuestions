package chapter2_binaryTree;

import java.util.LinkedList;

public class BinaryTree {
	int num;
	int layer;
	BinaryTree left=null;
	BinaryTree right=null;
	
	public BinaryTree(int num)
	{
		this.num=num;
	}
	public BinaryTree() {
	}
	public void addNode(BinaryTree root, int newNum)
	{
		BinaryTree newNode=new BinaryTree(newNum);
		if(newNum>root.num)
		{
			if(root.right!=null)
			{
				addNode(root.right, newNum);
				return;
			}
			root.right=newNode;
			return;
		}
		if(root.left!=null)
		{
			addNode(root.left, newNum);
			return;
		}
		root.left=newNode;
	}
	
	public void getLayer(BinaryTree root, int layer)
	{
		root.layer=layer;
		layer++;
		if(root.left!=null)
			getLayer(root.left, layer);
		if(root.right!=null)	
			getLayer(root.right, layer);
		return;
	}
	
	public void printLayer(BinaryTree root)
	{
		LinkedList<BinaryTree> br= new LinkedList<BinaryTree>();
		LinkedList<BinaryTree> row= new LinkedList<BinaryTree>();
		row.add(root);
		br.addAll(row);
		while(!br.isEmpty())
		{
			while(!row.isEmpty())
			{
				System.out.print(row.poll().num+" ");
			}
			System.out.println();
			while(!br.isEmpty())
			{
				BinaryTree temp=br.pop();
				if(temp.left!=null)
					row.add(temp.left);
				if(temp.right!=null)
					row.add(temp.right);
			}
		br.addAll(row);
		}
	}
}
