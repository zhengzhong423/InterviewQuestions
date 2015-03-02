package epic;

public class Decimal {

	public static void main(String[] args) {
		Decimal d=new Decimal();
		int[] rs=d.helper(0.35);
		System.out.println(rs[1]+"/"+rs[0]);
	}
	public int[] helper(double f)
	{
		int num1=1000;
		int num2=(int)(f*1000);
		int k=LargetCommonFactor(num1, num2);
		return new int[] {num1/k, num2/k};
	}
	public int LargetCommonFactor(int num1, int num2)
	{
		int remainer=num1%num2;
		while(num2%remainer!=0)
		{
			num1=num2;
			num2=remainer;
			remainer=num1%num2;
		}
		return remainer;
	}

}
