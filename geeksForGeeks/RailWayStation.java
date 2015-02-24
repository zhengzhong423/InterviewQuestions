package geeksForGeeks;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RailWayStation {

	public static void main(String[] args) {
		RailWayStation r=new RailWayStation();
		System.out.println(r.helper(new int[] {2, 5}, 4));
	}
	public int helper(int[] num, int k)
	{
		Comparator<Integer> cmp=new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		};
		PriorityQueue<Integer> p=new PriorityQueue<>(num.length, cmp);
		for(int i=0; i<num.length; i++)
			p.add(num[i]);
		int sum=0;
		for(int i=0; i<k; i++)
		{
			int max=p.poll();
			sum+=max;
			p.add(max-1);
		}
		return sum;
	}
}
