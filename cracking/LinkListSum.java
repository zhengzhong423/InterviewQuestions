package cracking;
import java.util.LinkedList;
import java.util.ListIterator;
public class LinkListSum {
	public static void main(String[] args) 
	{
				LinkListSum r=new LinkListSum();
				LinkedList<Integer> l1=new LinkedList<Integer>();
				LinkedList<Integer> l2=new LinkedList<Integer>();
				l1.addLast(3);
				l1.addLast(1);
				l1.addLast(5);
				l2.addLast(5);
				l2.addLast(9);
				l2.addLast(2);
				l1=r.linkListSum(l1,l2);
				System.out.println(l1);
	}

	private LinkedList<Integer> linkListSum(LinkedList<Integer> l1, LinkedList<Integer> l2)
	{
		ListIterator<Integer> i1=l1.listIterator();
		ListIterator<Integer> i2=l2.listIterator();
		LinkedList<Integer> temp=new LinkedList<Integer>();
		int addition=0;
		while(i1.hasNext())
		{
			int num=i1.next()+i2.next();
			if(num>=10) 
			{
				num=num%10;
				temp.addLast(num+addition);
				addition=1;
			}
			else
			{
				temp.addLast(num+addition);
				addition=0;
			}
			}
		return temp;
		}
	}


