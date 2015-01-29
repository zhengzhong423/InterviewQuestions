package leetCode;

public class FindMin {

	public static void main(String[] args) {
		int a[]={5,1,2,3,4};
		System.out.println(findMin(a));
	}
	public static int findMin(int[] num)
	{
		int low=0;
		int high=num.length-1;
		int mid=(high+low)/2;
		int min=Integer.MAX_VALUE;
		while(high>=low)
		{
			if(num[low]<=num[mid])
				min=Math.min(min, num[low]);
			if(num[mid]<=num[high])
				min=Math.min(min, num[mid]);
			if(num[low]<=num[mid] && num[mid]<=num[high])
				break;
			if(num[low]>num[mid])
				high=mid-1;
			else if(num[mid]>num[high])
				low=mid+1;
			mid=(high+low)/2;
		}
		return min;
	}

}
