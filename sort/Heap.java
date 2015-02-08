package sort;

public class Heap {

	public static void main(String[] args) {
		Heap heap=new Heap();
		int[] num=new int[] {6,4,3,5,8,9,10};
		heap.heapSort(num);
		heap.deleteHeap(num, num.length-1);
		heap.HeapUp(num, num.length-1);
		for(int i=0; i<num.length; i++)
			System.out.print(num[i]+" ");
	}

	// heap sort
	public void heapSort(int[] a) {
		for (int i = a.length/2; i >=0; i--)
			HeapDown(a, i, a.length);
	}

	// add element
	public void HeapUp(int[] a, int i) {
		int j=(i-1)/2;
		while(j>=0)
		{
			if(a[i]<a[j])
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			else
				break;
			i=j;
			j=(i-1)/2;
		}
	}

	// delete element
	public void deleteHeap(int[] a, int n) {
		int temp = a[0];
		a[0] = a[n];
		a[n] = temp;
		HeapDown(a, 0 ,n - 1);
	}

	public void HeapDown(int[] a, int i ,int n) {
		int j=i*2+1;
		while(j<n)
		{
			if(j+1<n && a[j+1]<a[j])
				j++;
			if(a[i]>a[j])
			{
				int temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}
			else
				break;
			i=j;
			j=i*2+1;
		}
	}

}
