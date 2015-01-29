package geeksForGeeks;

import java.util.*;

public class FindMedian {
	  PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(100, new Comparator<Integer>()
			{
				public int compare (Integer num1, Integer num2)
				{
					return num2-num1;
				}
			}
		);
	 PriorityQueue<Integer> minHeap=new PriorityQueue<Integer> ();
	 int left=0;
	 int right=0;
	 double mid=0;
	
	public static void main(String[] args) {
		int[] num={1,2,3,4,5,6,7,10,3,1,1,1};
		FindMedian f=new FindMedian();
		for(int i=0; i<num.length; i++)
		{
			System.out.println(f.median(num[i]));
		}
	}
	public  double median(int i) {
		if(left==0 && right==0)
		{
			maxHeap.add(i);
			left++;
			mid=i;
			return maxHeap.peek();
		}
		if(left==right)
		{
			if(i>mid)
			{
				minHeap.add(i);
				right++;
				mid= minHeap.peek();
				return mid;
			}
			else
			{
				maxHeap.add(i);
				left++;
				mid= maxHeap.peek();
				return mid;
			}
		}
		if(left>right)
		{
			if(i>mid)
			{
				minHeap.add(i);
				right++;
				mid= (minHeap.peek()+maxHeap.peek())/2.0;
				return mid;
			}
			else
			{
				maxHeap.add(i);
				minHeap.add(maxHeap.poll());
				right++;
				mid=  (minHeap.peek()+maxHeap.peek())/2.0;
				return mid;
			}
		}
		if(right>left)
		{
			if(i>mid)
			{
				minHeap.add(i);
				maxHeap.add(minHeap.poll());
				left++;
				mid= (minHeap.peek()+maxHeap.peek())/2.0;
				return mid;
			}
			else
			{
				maxHeap.add(i);
				
				left++;
				mid=  (minHeap.peek()+maxHeap.peek())/2.0;
				return mid;
			}
		}
		return -1;
	}

}
