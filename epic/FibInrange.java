package epic;

import java.util.LinkedList;
import java.util.List;

public class FibInrange {
	public static void main(String[] args)
	{
		System.out.println(new FibInrange().getNumbers(0,12122436));
	}
	
	public List<Integer> getNumbers(int min, int max)
	{
		List<Integer> rs=new LinkedList<Integer>();
		for(int i=min; i<=max; i++)
			if(valid(i))
				rs.add(i);
		return rs;
	}

	private boolean valid(int num) {
		String s=String.valueOf(num);
		for(int i=1; i<=3 && s.length()>=i; i++)
		{
			String seed=s.substring(0, i);
			int base=Integer.parseInt(seed);
			String result=String.valueOf(base*2);
			String rs=seed+seed+result;
			
			int mul1=1;
			int mul2=2;
			
			while(rs.length()<=s.length())
			{
				if(rs.equals(s))
					return true;
				if(!s.startsWith(rs))
					break;
				mul2=mul1+mul2;
				mul1=mul2-mul1;
				rs+=String.valueOf(base*mul2);
			}
		}
		return false;
	}
}
