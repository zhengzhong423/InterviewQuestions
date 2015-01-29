package chapter5_bit;

public class Count {

	public static void main(String[] args) {
		System.out.println(findMinMax(7));
	}
	public static int findMinMax(int num)
	{

		int result=0;
		for(int i=num;i!=0;i=i>>1)
		{
			int temp=i&1;
			if(temp==1)
			{result++;}
		}
		return result;
	}

}
