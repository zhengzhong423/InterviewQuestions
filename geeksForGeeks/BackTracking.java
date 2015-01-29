package geeksForGeeks;

public class BackTracking {

	public static void main(String[] args) {
		int k=4;
		fill(1, new int[k*2]);
	}
	public static void fill(int n, int[] num)
	{
			if(n>num.length/2)
			{
				for(int i=0; i<num.length; i++)
					System.out.print(num[i]);
				System.out.println();
				return;
			}
			for(int i=0; i<num.length; i++)
			{
				if(i+n+1>=num.length)
					return;
				if(num[i]==0 && num[i+n+1]==0)
				{
					num[i]=n;
					num[i+n+1]=n;
					fill(n+1, num);
					num[i]=0;
					num[i+1+n]=0;
				}
			}
	}
	

}
