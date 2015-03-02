package epic;

import java.util.LinkedList;
import java.util.List;

public class FibInrange {
	public static void main(String[] args)
	{
		System.out.println(new FibInrange().getNumbers(-1, 100000));
	}
	
	public List<Long> getNumbers(int min, int max)
	{
		List<Long> rs=new LinkedList<Long>();
		long num1=1;
		if(num1>=min && num1<=max)
			rs.add(num1);
		long num2=2;
		while(num2<=max)
		{
			if(num2>=min)
				rs.add(num2);
			num2=num1+num2;
			num1=num2-num1;
		}
		return rs;
	}
}
