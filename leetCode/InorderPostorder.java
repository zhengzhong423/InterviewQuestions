package leetCode;

import java.util.ArrayList;

public class InorderPostorder {

	public static void main(String[] args) {
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        ArrayList<Integer> in=new ArrayList<Integer>();
        for(Integer i: inorder)
        	in.add(i);
        ArrayList<Integer> post=new ArrayList<Integer>();
        for(Integer i:postorder)
        	post.add(i);
        return getTree(in, post, 0, in.size()-1, 0, post.size()-1);
    }
	public static TreeNode getTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inLow, int inHigh, int postLow, int postHigh)
	{
		if(inLow<0 || inHigh>=inorder.size() || postLow<0 || postHigh>=postorder.size())
			return null;
		if(inLow>inHigh || postLow>postHigh)
			return null;
		int rootVal=postorder.get(postLow);
		int index=inorder.indexOf(rootVal);
		int postLowLeft=postLow+1;
		int inLowRight=index-1;
		int inHighLeft=index+1;
		TreeNode root=new TreeNode(rootVal);
		root.left=getTree(inorder, postorder, inLow, inLowRight, postLowLeft, postLowLeft+inLowRight-inLow);
		root.right=getTree(inorder, postorder, inHighLeft, inHigh, postLowLeft+inLowRight-inLow+1, postHigh);
		return root;
	}

}
