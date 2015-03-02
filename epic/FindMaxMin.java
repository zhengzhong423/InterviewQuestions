package epic;

import java.util.Scanner;

public class FindMaxMin {
	
	int maxOdd=Integer.MIN_VALUE+1;
	int minEven=Integer.MAX_VALUE-1;
	public static void main(String[] args) {
		new FindMaxMin().helper();
	}
	
	public void helper()
	{
		int input=1;
		while(input!=0)
		{
			input=new Scanner(System.in).nextInt();
			if(input!=0)
			{
				if(input%2!=0 && input>=maxOdd)
					maxOdd=input;
				else if(input%2==0 && input<=minEven)
					minEven=input;
			}
		}
		System.out.println(maxOdd);
		System.out.println(minEven);
	}

}
