import java.util.LinkedList;
import java.util.ListIterator;
public class LinkListCircular {

	public static void main(String[] args) 
	{	
		LinkListCircular a=new LinkListCircular();
		LinkedList<Integer> l=new LinkedList<Integer>();
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l.addLast(3);
		a.Check(l);
		
	}
	public void Check(LinkedList<Integer> l)
	{
		ListIterator<Integer> a1=l.listIterator();
		ListIterator<Integer> a2=l.listIterator();
		int upper=0;
		while(a1.hasNext())
		{
			a2=l.listIterator();
			for(int i=0;i<upper;i++)
			{
				if(a2.next()==a1.next())
				{
					System.out.println(a1.previous());
					return;
				}
				a1.previous();
			}
			a1.next();
			upper++;
		}
		System.out.println("NO!");
	}

}
