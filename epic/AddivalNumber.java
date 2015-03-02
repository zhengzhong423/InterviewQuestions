package epic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AddivalNumber {

	public static void main(String[] args) {
		AddivalNumber ad=new AddivalNumber();
		System.out.println(ad.addival(new int[] {4,3,2,6,7,8}));
	}
	public double addival(int[] arr)
	{
		Comparator<Integer> cmp=new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
		
		PriorityQueue<Integer> p=new PriorityQueue<Integer>(arr.length, cmp);
		
		double rs=0.0f;
		for(int i=0; i<arr.length; i++)
			p.add(arr[i]);
		
		if(p.size()>3)
		{
			p.poll();
			p.poll();
			p.poll();
			while(!p.isEmpty())
				rs+=(double)(p.poll())/(double)(arr.length-3);
		}
		else
			return 0.0f;
		return rs;
	}

}
