package sort;

public class FindKthElement {

	public static void main(String[] args) { 
       int[] a = new int[] {1, 4, 6, 10};  
  //     int[] b = new int[] {5, 8, 9};  
  //      System.out.println(findKthElement(a, 0, 3, b,  0, 2, 7));  
       System.out.println(findKthElement2(a, 4));
	}
	public static int findKthElement2(int[] arr, int k)
	{
		int low=0;
		int high=arr.length-1;
		int n=arr.length;
		while(true)
		{
			int pos=partition(arr, low, high);
			if(pos==n-k)
				return arr[pos];
			if(pos>n-k)
				high=pos-1;
			if(pos<n-k)
				low=pos+1;
		}
	}
	public static int partition(int[] arr, int low, int high)
	{
		int temp=arr[high];
		while(low<high)
		{
			while(low<high && arr[low]<temp)
				low++;
			arr[high]=arr[low];
			while(high>low && arr[high]>temp)
				high--;
			arr[low]=arr[high];
		}
		arr[low]=temp;
		return low;
	}
	public static int findKthElement(int[] a, int as, int ae, int[] b, int bs, int be, int k)
	{
		if(as>ae)
			return b[bs+k-1];
		if(bs>be)
			return a[as+k-1];
		int aMid=(as+ae)/2;
		int bMid=(bs+be)/2;
		if(a[aMid]<=b[bMid])
		{
			if(k<=(aMid-as)+(bMid-bs)+1)
				return findKthElement(a, as, ae, b, bs, bMid-1, k);
			else
				return findKthElement(a, aMid+1, ae, b, bs, be, k-(aMid-as)-1);
		}
		else
		{
			if(k<=(aMid-as)+(bMid-bs)+1)
				return findKthElement(a, as, aMid-1, b, bs, be, k);
			else
				return findKthElement(a, as, ae, b, bMid+1, be, k-(bMid-bs)-1);
		}
	}

}
