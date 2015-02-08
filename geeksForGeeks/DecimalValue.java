package geeksForGeeks;

import java.util.HashMap;

public class DecimalValue {
	static String loop="";
	public static void main(String[] args) {
		helper(14);
		System.out.println(loop);
		System.out.println(1.0/14.0f);
	}
	public static void helper(int num)
	{
		if(num==1)
			return;
		HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
		int index=0;
		int a=10;
		while(true)
		{
			int q=a/num;
			hash.put(a,index);
			if(q*num==a)
			{
				loop="-1";
				return;
			}
			a=(a-q*num)*10;
			loop=loop+String.valueOf(q);
			if(hash.containsKey(a))
			{
				loop=loop.substring(hash.get(a));
				return;
			}
			index++;
		}
		
	}

}
