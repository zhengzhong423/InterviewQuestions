package chapter9_sorting;

public class GetIndex {

	public static void main(String[] args) {
		int[] a={15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(findIndex(a, 0, a.length-1, 14));
	}

	private static int findIndex(int[] a,int s, int e, int num) 
	{
		if(s<=e)
		{
			int mid=(s+e)/2;
			if(num==a[mid])
				return mid;
			if(a[mid]<=a[e])
			{
				if(num>a[mid] && num<=a[e])
					return findIndex(a, mid+1, e, num);
				if(num>a[mid] && num>=a[e])
					return findIndex(a, s, mid-1, num);
				if(num<a[mid])
					return findIndex(a, s, mid-1, num);
			}
			if(a[mid]>=a[e])
			{
				if(num>a[mid])
					return findIndex(a, s, mid+1, num);
				if(num<a[mid] && num<=a[e])
					return findIndex(a, mid+1, e, num);
				if(num<a[mid] && num>=a[e])
					return findIndex(a, s, mid-1, num);
			}
		}
		return -1;
	}

}
