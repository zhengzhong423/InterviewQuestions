package cracking;

public class FindCommonParent {

	public static void main(String[] args) {
		BinaryTree a=new BinaryTree(5);
		a.add(a, 2);
		a.add(a, 4);
		a.add(a, 1);
		a.add(a, 3);
		a.add(a, 6);
		a.add(a, 7);
		FindSuccessor f=new FindSuccessor();
		FindCommonParent fcp=new FindCommonParent();
		System.out.println(fcp.CommonParent(f.match(1, a), f.match(3, a), a).num);
	}
	public BinaryTree CommonParent(BinaryTree p1, BinaryTree p2, BinaryTree a)
	{
		FindCommonParent f=new FindCommonParent();
		if(f.Relation(a.left, p2) && f.Relation(a.left, p1)) 
			return f.CommonParent(p1, p2, a.left);
		if(f.Relation(a.right, p2) && f.Relation(a.right, p1)) 
			return f.CommonParent(p1, p2, a.right);
		return a;
	}
	public boolean Relation(BinaryTree p1, BinaryTree p2)
	{
		if(p1==p2)	return true;
		if(p1==null) return false;
		return Relation(p1.right,p2) || Relation(p1.left,p2);
	}
}
