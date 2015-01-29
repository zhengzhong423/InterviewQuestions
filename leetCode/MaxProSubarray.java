package leetCode;
import java.util.Stack;

public class MaxProSubarray {

	public static void main(String[] args) {
		int[] a={-2,3,-4,};
		System.out.println(maxProduct1(a));
		System.out.println(maxProduct2(a));
	}
	public static int maxProduct1(int[] A)
	{
		int maxProduct=Integer.MIN_VALUE;
		int count=0;
		Stack<Integer> t=new Stack<Integer>();
		while(count<=A.length-1)
		{
			for(int i=0; i<=count; i++)
				t.push(A[i]);
			int temp=1;
			while(!t.isEmpty())
			{
				temp=temp*t.pop();
				maxProduct=maxProduct<= temp? temp : maxProduct;
			}
			count++;
		}
		return maxProduct;
	}
	public static int maxProduct2(int[] A)
	{
		int[] max=new int[A.length];
		int[] min=new int[A.length];
		max[0]=A[0];
		min[0]=A[0];
		int maxProduct=A[0];
		for(int i=1; i<A.length; i++)
		{
			max[i]=Math.max(A[i], Math.max(max[i-1]*A[i], min[i-1]*A[i]));
			min[i]=Math.min(A[i], Math.min(max[i-1]*A[i], min[i-1]*A[i]));
			maxProduct=Math.max(maxProduct, max[i]);
		}
		return maxProduct;
	}
}
