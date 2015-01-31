package cracking;
import java.util.LinkedList;
import java.util.ListIterator;
public class LinkList {
	public static void main(String[] args) {
		LinkList r=new LinkList();
		LinkedList<Integer> l=new LinkedList<Integer>();
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l.addLast(2);
		int m=1;
		int k=r.FindLastKthElement(l,m);
		System.out.println(l);
		System.out.println(k);
		
		l=r.DeleteDuplicate(l);
		System.out.println(l);
		
		l.remove((Integer)2);
		System.out.println(l);
	}
	private int FindLastKthElement(LinkedList<Integer> l,int m) 
	{
		ListIterator<Integer> b=l.listIterator(l.size());
		for(int i=1;i<=m;i++)
		{
			b.previous();
		}
		b.next();
		return b.previous();
	}
	public LinkedList<Integer> DeleteDuplicate(LinkedList<Integer> l)
	{
		ListIterator<Integer> a=l.listIterator();
		LinkedList<Integer> temp=new LinkedList<Integer>();
		while(a.hasNext())
		{
			if(temp.contains(a.next()))
			{
			}
			else 
			{
				a.previous();
				temp.addLast(a.next());
			}
			
		}
		return temp;
	}
}
