package leetCode;

import java.util.LinkedList;
import java.util.List;

public class BSTpath {
	
	List<Integer> find=new LinkedList<>();
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		BSTpath p=new BSTpath();
		p.add(root, 6);
		p.add(root, 4);
		p.add(root, 8);
		p.find(root, 7);
		System.out.println(p.find);
	}
	//find iteration
	public void find(TreeNode root, int val)
	{
		TreeNode cur=root;
		find.add(-1);
		List<Integer> temp=new LinkedList<>();
		while(true)
		{
			if(cur==null)
				return;
			if(cur.val==val)
				break;
			if(cur.val>val)
			{
				temp.add(0);
				cur=cur.left;
			}
			else
			{
				temp.add(1);
				cur=cur.right;
			}
		}
		find.clear();
		find.addAll(temp);
	}
	//iteration
	public void add(TreeNode root, int val)
	{
		TreeNode cur=root;
		while(true)
		{
			if(cur.val>val)
			{
				if(cur.left==null)
				{
					cur.left=new TreeNode(val);
					break;
				}
				else 
					cur=cur.left;
			}
			else
			{
					if(cur.right==null)
					{
						cur.right=new TreeNode(val);
						break;
					}
					else 
						cur=cur.right;
			}
		}
	}
	//recursion
	public TreeNode addNode(TreeNode root, int val)
	{
		if(root==null)
			return new TreeNode(val);
		if(val>root.val)
			root.right=addNode(root.right, val);
		else
			root.left=addNode(root.left, val);
		return root;
	}

}
