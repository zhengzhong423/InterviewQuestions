package geeksForGeeks;

public class BST {
	public static void main(String[] args)
	{
		StringBuffer result=new StringBuffer();
		find(new int[] {8,2,4,9,12,1,3}, 7, result);
		System.out.println(result);
	}
	public static void find(int[] num, int target, StringBuffer result)
	{
		int min=Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		int i=0;
		while(i<num.length)
		{
			if(target==num[i])
				return;
			if(target>num[i])
			{
				min=Math.max(min, num[i]);
				while((i<num.length && min>=num[i]) || (i<num.length && max<=num[i] ))
					i++;
				if(i>=num.length)
					break;
				result.append(1);
			}
			else
			{
				max=Math.min(max, num[i]);
				while(i<num.length && (max<=num[i] || min>=num[i]))
					i++;
				if(i>=num.length)
					break;
				result.append(0);
			}
		}
		result.delete(0, result.length());
		result.append(-1);
	}
}
