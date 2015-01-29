package leetCode;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

	public static void main(String[] args) {
	}
	 public static List<List<Integer>> pathSum(TreeNode root, int sum) 
	 {
		 List<List<Integer>> l=new LinkedList<List<Integer>>();
		 pathSum2(root, sum, new LinkedList<Integer>(), l);
		 return l;
	 }
	 public static void pathSum2(TreeNode root, int sum, List<Integer> c, List<List<Integer>> l)
	 {
		 if(root==null)
			 return;
		 c.add(root.val);
		 if(root.left==null && root.right==null)
		 {
			 if(root.val==sum)
				 l.add(new LinkedList<Integer>(c));
			 return;
		 }
		 pathSum2(root.left, sum-root.val, new LinkedList<Integer>(c), l);
		 pathSum2(root.right, sum-root.val, new LinkedList<Integer>(c), l);
	 }
}
