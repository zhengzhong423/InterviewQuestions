package geeksForGeeks;

public class SearchPivot {
	static int rs=-1;
	public static void main(String[] args)
	{
		int[] num={1,2,3,4,5,6,3,2,1};
		helper(num, 0, num.length-1);
		System.out.println(rs);
	}
	public static void helper(int[] num, int start, int end)
	{
		int mid=(start+end)/2;
		if(mid<num.length-1 && mid>0)
		{
			if((num[mid-1]<num[mid] && num[mid]>num[mid+1]))
			{
				rs=num[mid];
				return;
			}
			if(num[mid]>num[mid+1])
				helper(num, start, mid-1);
			else
				helper(num, mid+1, end);
		}
	}

}
