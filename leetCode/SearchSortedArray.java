package leetCode;

public class SearchSortedArray {

	public static void main(String[] args) {
		
	}
	public int search(int[] A, int target) {
        return helper(A, target, 0, A.length-1);
    }
	public int helper(int[] A, int target, int low, int high)
	{
		int mid=(low+high)/2;
		if(high<low)
			return -1;
		if(target==A[mid])
			return mid;
		if(A[low]<A[high])
		{
			if(target>A[mid])
				return helper(A, target, mid+1, high);
			else
				return helper(A, target, low, mid);
		}
		if(A[low]>A[high])
		{
			if(A[high]>A[mid])
			{
				if(target>A[mid] && target<=A[high])
					return helper(A, target, mid+1, high);
				else
					return helper(A, target, low, mid);
			}
			else
			{
				if(target>=A[low] && target<A[mid])
					return helper(A, target, low, mid);
				else
					return helper(A, target, mid+1, high);
			}
		}
		return -1;
	}

}
