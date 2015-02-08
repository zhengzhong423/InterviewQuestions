package geeksForGeeks;

public class Rearrange {

	public static void main(String[] args) {
		int[] num={1,2,3,4,5,-6,-7};
		helper2(num);
		for(int i=0; i<num.length; i++)
			System.out.println(num[i]);
	}

	public static void helper2(int[] arr)
	{
		int Pos=-1;
		int Neg=-1;
		for(int i=0; i<arr.length; i++)
			if(arr[i]>0)
			{
				Pos=i;
				break;
			}
			
		for(int j=0; j<arr.length; j++)
			if(arr[j]<0)
			{
				Neg=j;
				break;
			}
			
		for(int i=0; i<arr.length; i++)
		{
			if((i & 0x01)==0)
			{
				if(arr[i]>0 && Pos<=i && Pos!=-1)
					Pos=findNextPos(arr, i);
				if(arr[i]<0 && Pos!=-1)
				{
					int temp=arr[i];
					arr[i]=arr[Pos];
					arr[Pos]=temp;
					Pos=findNextPos(arr, Pos);
				}
			}
			
			if((i & 0x01)==1)
			{
				if(arr[i]<0 && Neg<=i && Neg!=-1)
					Neg=findNextNeg(arr, i);
				if(arr[i]>0 && Neg!=-1)
				{
					int temp=arr[i];
					arr[i]=arr[Neg];
					arr[Neg]=temp;
					Neg=findNextNeg(arr, Neg);
				}
			}
		}
	}
	
	 static int findNextNeg(int[] arr, int Neg)
	{
		for(int i=Neg+1; i<arr.length; i++)
			if(arr[i]<0)
				return i;
		return -1;
	}
	
	static int findNextPos(int[] arr, int Pos)
	{
		for(int i=Pos+1; i<arr.length; i++)
			if(arr[i]>0)
				return i;
		return -1;
	}
	public static void helper(int[] arr)
	{
			int j=-1;
			int i=0;
			for(; i<arr.length; i++)
			{
				if(j>=0)
				{
					if((arr[j]>0 && arr[i]<0) || (arr[j]<0 && arr[i]>0) )
					{
						rightRotate(arr, j, i);
						if(i-j>=2)
							j=j+2;
						else
							j=-1;
					}
				}
				if(j==-1)
					if(((i&0x01)==0 && arr[i]<0) || ((i&0x01)==1 && arr[i]>0) )
					{
						j=i;
					}
			}
	}
	public static void rightRotate(int[] arr, int j, int i) {
		int temp=arr[i];
		for(int k=i; k>j; k--)
			arr[k]=arr[k-1];
		arr[j]=temp;
	}

}
