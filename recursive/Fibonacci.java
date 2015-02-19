package recursive;

public class Fibonacci {

	public static void main(String[] args) 
	{
		for(int i=1; i<=20; i++)
		System.out.print(MyFibonacci(i)+" ");

	}
	public static int MyFibonacci (int k)
	{
		if(k==1 || k==2)
			return 1;
		return MyFibonacci(k-1)+MyFibonacci(k-2);
	}

}
