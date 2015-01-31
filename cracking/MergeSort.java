package cracking;

public class MergeSort {

	public static void main(String[] args)
	{
		MergeSort test=new MergeSort();
		StringBuilder s=new StringBuilder("sdfnuiwesdf  hrjuihs nf$#@#$kdg");
		test.mergesort(s, 0, s.length()-1);

		System.out.println(s);
	}
	public void mergesort(StringBuilder s, int a,int b)
	{
		if(b>a)
		{
		int mid=(a+b)/2;
		mergesort(s,a,mid);
		mergesort(s,mid+1,b);
		merge(s,a,b,mid);
		}
	}
	public void merge(StringBuilder s, int a, int b, int mid)
	{
		int i=a;
		int m=mid+1;
		String order="";
		while(i<=mid && m<=b)
		{				
			if(s.charAt(i)<=s.charAt(m))
			{
				order+=s.charAt(i);
				i++;
			}
			else
			{
				order+=s.charAt(m);
				m++;
			}
		}
		while(m<=b)
		{
			order+=s.charAt(m);
			m++;
		}
		while(i<=mid)
		{
			order+=s.charAt(i);
			i++;
		}
		s.replace(a, b+1, order);
	}

}
