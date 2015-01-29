package hackerank;

import java.util.*;

public class AlternatingCharacters {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		in.nextLine();
		for(int i=0; i<num; i++)
		{
			String s=in.nextLine();
			helper(s);
		}
		in.close();
	}
	static void helper(String s)
	{
		int delete=0;
		char buffer = 0;
		for(int j=0; j<s.length(); j++)
		{	
			if(j==0)
				buffer=s.charAt(0);
			else
			{
				if(s.charAt(j)==buffer)
					delete=delete+1;
				else
					buffer=s.charAt(j);
			}
		}
		System.out.println(delete);
	}

}
