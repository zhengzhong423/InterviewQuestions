package leetCode;

public class MinimumRotatedArray {
	int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[] num={2,2,2,0,0,1};
		MinimumRotatedArray r=new MinimumRotatedArray();
		System.out.println(r.findMin(num));
	}
	 public int findMin(int[] num) {
		 if(num.length==0)
			 return 0;
		 	helper(num, 0, num.length-1);
		 	return min;
	    }
	 public void helper(int[] num, int low, int high)
	 {
		 int mid=(low+high)/2;
		 min=Math.min(min, num[low]);
		 min=Math.min(min, num[high]);
		 if(low+1>=high)
			 return;
		 if(num[low]>=num[high])
		 {
			 if(num[mid]<num[high])
			 {
				 helper(num, low, mid);
				 return;
			 }
			 if(num[mid]==num[high] && num[mid]<num[low])
			 {
				 helper(num, low, mid);
				 return;
			 }
			 if(num[mid]>num[low])
			 {
				 helper(num, mid, high);
				 return;
			 }
			 if(num[mid]==num[low] && num[mid]>num[high])
			 {
				 helper(num, mid, high);
				 return;
			 }
			 if(num[mid]==num[high] && num[low]==num[high])
			 {
				 helper(num, low, mid);
			 	 helper(num, mid+1, high);
			 	 return;
			 }
		 }

		return;
	 }
}
