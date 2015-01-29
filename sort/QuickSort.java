package sort;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort q=new QuickSort();
		int[] num={1 ,3 ,9 ,8 ,2 ,7 ,5};
		q.quickSort(num, 0, num.length-1);
	}
	public void quickSort(int[] num, int low, int high)
	{
		if(low<high)
		{
			int mid=getMid(num, low, high);
			quickSort(num, low, mid-1);
			quickSort(num, mid+1, high);
			printArray(num);
		}
		
	}
	 static void printArray(int[] ar) {
         for(int i=0; i<ar.length; i++){
            System.out.print(ar[i]+" ");
         }
           System.out.println("");
      }
	 static int getMid(int[] ar, int low, int high)
     {
		 int temp=ar[high];
		 while(low<high)
		 {
			 while(low<high && ar[low]<=temp)
				 low++;
			 ar[high]=ar[low];
			 while(low<high && ar[high]>=temp)
				 high--;
			 ar[low]=ar[high];
		 }
		 ar[high]=temp;
		 return high;
     }   

}
