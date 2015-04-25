package sort;

public class Merge {

	public static void main(String[] args) {
		int[] a=new int[5];
		int[] b={2,3,4};
		a[0]=6;
		a[1]=7;
		a=getMerge(a,b,2);
		for(int i=0;i<=a.length-1;i++)
			System.out.println(a[i]);
	}
	public static int[] getMerge(int[] a, int[] b, int alen)
	{
		int apointer=alen;
		int bpointer=b.length;
		int resultpointer=apointer+bpointer;
		while(apointer>0 && bpointer>0)
		{
			if(a[apointer-1]>b[bpointer-1])
				a[--resultpointer]=a[--apointer];
			else
				a[--resultpointer]=b[--bpointer];
		}
		while(bpointer>0)
		{
			a[--resultpointer]=b[--bpointer];
		}
		return a;
	}

}
