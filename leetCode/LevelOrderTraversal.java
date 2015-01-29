package leetCode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> result=new LinkedList<List<Integer>>();
		List<TreeNode> level=new LinkedList<TreeNode>();
		level.add(root);
		while(!level.isEmpty())
		{
			List<TreeNode> copy=new LinkedList<TreeNode>(level);
			List<Integer> temp=new LinkedList<Integer>();
			level.clear();
			for(TreeNode tn: copy)
			{
				if(tn.left!=null)
					level.add(tn.left);
				if(tn.right!=null)
					level.add(tn.right);
				temp.add(tn.val);
			}
			result.add(0, new LinkedList<Integer>(temp));
		}
		return result;
    }
}
