package sort;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort m=new MergeSort();
		int[] num={3,2,1,4,6,5};
		m.mergeSort(num, 0, num.length-1);
	}
	public void mergeSort(int[] num, int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			mergeSort(num, low, mid);
			mergeSort(num, mid+1, high);
			merge(num, low, high, mid);
		}
	}
	public void merge(int[] a, int low, int high, int mid)
	{
		if(high>low)
		{
		int pointerA=low;
		int pointerB=mid+1;
		int[] temp=new int[high-low+1];
		int index=0;
			while(pointerA<=mid && pointerB<=high)
			{
				if(a[pointerA]>a[pointerB])
				{
					temp[index]=a[pointerB];
					index++;
					pointerB++;
				}
				else
				{
					temp[index]=a[pointerA];
					index++;
					pointerA++;
				}
			}
		while(pointerA<=mid)
		{
			temp[index]=a[pointerA];
			index++;
			pointerA++;
		}
		while(pointerB<=high)
		{
			temp[index]=a[pointerB];
			index++;
			pointerB++;
		}
		for(int i=low; i<=high; i++)
			a[i]=temp[i-low];
	}
	}
	

}
