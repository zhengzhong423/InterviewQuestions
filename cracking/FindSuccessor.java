
public class FindSuccessor {

	public static void main(String[] args) 
	{
		BinaryTree a=new BinaryTree(5);
		a.add(a, 2);
		a.add(a, 4);
		a.add(a, 1);
		a.add(a, 3);
		a.add(a, 6);
		a.add(a, 7);
		FindSuccessor f=new FindSuccessor();
		BinaryTree b=f.match(4,a);
		BinaryTree result=f.successor(b);
		System.out.println(result.num);
	}
	public BinaryTree match(int num, BinaryTree a)
	{
		a.q.add(a);
		while(!a.q.isEmpty())
		{
			if(a.q.peek().left!=null)
			{
				a.q.add(a.q.peek().left);
				a.q.peek().left.parent=a.q.peek();
			}
			if(a.q.peek().right!=null)
			{
				a.q.add(a.q.peek().right);
				a.q.peek().right.parent=a.q.peek();
			}
			BinaryTree temp=a.q.remove();
			if(temp.num==num)
			{
				return temp;
			}
		}
		BinaryTree newTemp=new BinaryTree();
		newTemp.num=-1;
		return newTemp;
	}
	public BinaryTree successor(BinaryTree b)
	{
		if(b.right!=null)
		{
			return b.right;
		}
		else	
		{	
			if(b.parent==null)
			{
				return b;
			}
			if(b.parent.left==b)
			{
				return b.parent;
			}
			else
			{
				BinaryTree p=b.parent;
				BinaryTree temp=b;
				while(p.right==temp)
				{
					temp=p;
					if(p.parent==null)
					{
						return b;
					}
					p=p.parent;
				}
				return p;
			}
		}
	}
}
