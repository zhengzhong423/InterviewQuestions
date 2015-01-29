package geeksForGeeks;

import java.util.LinkedList;

public class ReverseArray {

	public static void main(String[] args) {
		LinkedList<Integer> a=new LinkedList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(reverse(a));
	}
	public static LinkedList<Integer> reverse(LinkedList<Integer>  l)
	{
			if(l.size()==0)
				return new LinkedList<Integer>();
			int num=l.get(0);
			l.remove(0);
			LinkedList<Integer> rs=reverse(l);
			rs.add(num);
			return rs;
	}

}
