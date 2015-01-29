package dynamic_programming;

public class LIS {

	public static void main(String[] args) {
		int[] num={9,8,7};
		System.out.println(lis(num));
	}
	public static int lis(int[] num)
	{
		int[] opt=new int[num.length];
		for(int i=0; i<num.length; i++)
			for(int j=0; j<=i; j++)
				if(num[i]<num[j])
					opt[i]=Math.max(opt[j]+1, opt[i]);
		return 1+opt[num.length-1];
	}

}
