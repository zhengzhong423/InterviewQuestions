package epic;

import java.util.LinkedList;
import java.util.List;

public class FibRange {
	public static void main(String[] args)
	{
		FibRange fr=new FibRange();
		System.out.println(fr.helper(0, 88888888));
	}
	
	public List<Long> helper(int min, int max)
	{
		int seed1=1;
		int seed2=1;
		int seed=1;
		List<Long> rs=new LinkedList<Long>();
		String result=String.valueOf(seed2)+String.valueOf(seed1)+String.valueOf(seed1+seed2);
		while(Long.parseLong(result)<max && Long.parseLong(result)>0)
		{
			while(true)
			{
				if(Long.parseLong(result)<0)
					break;
				Long resultNum=Long.parseLong(result);
				if(resultNum>min && resultNum<max)
					rs.add(resultNum);
				else	 if(resultNum>max)
					break;
				seed2=seed1+seed2;
				seed1=seed2-seed1;
				result+=String.valueOf(seed2+seed1);
			}
			seed++;
			seed1=seed;
			seed2=seed;
			result=String.valueOf(seed2)+String.valueOf(seed1)+String.valueOf(seed1+seed2);
		}
		return rs;
	}
}