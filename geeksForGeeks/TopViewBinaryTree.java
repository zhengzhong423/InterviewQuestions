package geeksForGeeks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import leetCode.TreeNode;

public class TopViewBinaryTree {
	TreeMap<Integer, TreeNode> hash=new TreeMap<Integer, TreeNode>();
	class qItem
	{
		TreeNode root;
		int index;
		public qItem(TreeNode root, int index)
		{
			this.root=root;
			this.index=index;
		}
	}
	public static void main(String[] args)
	{
		TopViewBinaryTree t=new TopViewBinaryTree();
		
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
		t.helper(root, 0, t);
		
		Iterator<Integer> iter=t.hash.keySet().iterator();
		while(iter.hasNext())
			System.out.println(t.hash.get(iter.next()).val+" ");
	}
	public  void helper(TreeNode root, int index, TopViewBinaryTree t)
	{
		Queue<qItem> q=new LinkedList<>();
		Queue<qItem> next=new LinkedList<>();
		q.add(t.new qItem(root, index));
		while(!q.isEmpty())
		{
			while(!q.isEmpty())
			{
				qItem item=q.poll();
				if(!t.hash.containsKey(item.index))
					t.hash.put(item.index	, item.root);
				if(item.root.left!=null)
					next.add(t.new qItem(item.root.left, item.index-1));
				if(item.root.right!=null)
					next.add(t.new qItem(item.root.right, item.index+1));
			}
			q.addAll(next);
			next.clear();
		}
	}

}
