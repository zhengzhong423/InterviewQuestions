package geeksForGeeks;

public class SubTree {
	
	SubTree left=null;
	SubTree right=null;
	int val;
	
	
	public static void main(String[] args) {
		SubTree root1=new SubTree(0);
		root1.left=new SubTree(1);
		SubTree root2=new SubTree(1);
		System.out.println(traverse(root1, root2));
	}
	
	private static boolean traverse(SubTree root, SubTree st) {
		if(root==null)
			return false;
		if(root.isSubTree(st))
			return true;
		return traverse(root.left, st) || traverse(root.right, st);
	}

	public SubTree(int val)
	{
		this.val=val;
	}
	
	public boolean isSubTree(SubTree st)
	{
		if(st.val==this.val)
		{
			if(this.left!=null && this.right!=null)
				return this.left.isSubTree(st.left) && this.right.isSubTree(st.right);
			if(this.left!=null)
				return this.left.isSubTree(st.left);
			if(this.right!=null)
				return this.right.isSubTree(st.right);
			return true;
		}
		return false;
	}

}
