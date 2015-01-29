package dynamic_programming;

public class PossibleDecoding {

	public static void main(String[] args) {
		System.out.println(possible(new char[] {'1', '2', '1'}));
	}
	public static int possible(char[] num)
	{
		int[] opt=new int[num.length+1];
		opt[0]=1;
		for(int i=0; i<num.length; i++)
		{
			int num1=(int)num[i]-48;
			if(num1!=0)
				opt[i+1]=opt[i];
			if(i>0)
			{
				int num2=((int)num[i-1]-48)*10+(int)num[i]-48;
				if(num2>=10 && num2<=26)
					opt[i+1]+=opt[i-1];
			}
		}
		return opt[num.length];
	}

}
