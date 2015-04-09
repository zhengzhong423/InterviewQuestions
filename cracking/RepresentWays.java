package cracking;

public class RepresentWays {

	public static void main(String[] args) {
		int[] nums={10,3,1,5,4,2};
		
		System.out.println(new RepresentWays().helper(nums, 190));
		System.out.println(new RepresentWays().helper2(nums, 190 , 0));
	}
	
	// Try a recursion solution
	public int helper2(int[] num, int target, int index)
	{
		if(target==0)
			return 1;
		if(target<0 || index>=num.length)
			return 0;
		
		int sum=helper2(num, target-num[index], index)+ helper2(num, target, index+1);
		return sum;
	}
	
	//	Iteration Solution, dynamic programming solution
	public int helper(int[] nums, int target)
	{
		int[][] opt=new int[nums.length][target+1];
		
		for(int i=0; i<opt.length; i++)
			opt[i][0]=1;
		
		for(int i=0; i<opt.length; i++)
			for(int j=0; j<target+1; j++)
			{
				if(j-nums[i]>=0)
					opt[i][j]+=opt[i][j-nums[i]];
				if(i>0 && j!=0)
					opt[i][j]+=opt[i-1][j];
			}
		
		return opt[nums.length-1][target];
	}

}
