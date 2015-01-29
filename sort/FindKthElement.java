package sort;

public class FindKthElement {

	public static void main(String[] args) { 
       int[] a = new int[] {1, 4, 6, 10};  
       int[] b = new int[] {5, 8, 9};  
        System.out.println(findKthElement(a, 0, 3, b,  0, 2, 7));  

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
