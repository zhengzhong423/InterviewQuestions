package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergedSortedArray {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public void merge(int A[], int m, int B[], int n) {
	    Comparator<Integer> com=new Comparator<Integer>()
	    {
			public int compare(Integer o1, Integer o2) {
				if(o1<o2)
					return -1;
				else
					return 1;
			}
	      };
       PriorityQueue<Integer> p=new PriorityQueue<Integer>(m+n, com);
       for(int i=0; i<m; i++)
    	   p.add(A[i]);
       for(int i=0; i<n; i++)
    	   p.add(B[i]);
       for(int i=0; i<m+n; i++)
    	   A[i]=p.poll();
    }

}
