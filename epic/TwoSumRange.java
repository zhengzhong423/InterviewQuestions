package epic;

import java.util.*;

public class TwoSumRange {

	public static void main(String[] args) {
		TwoSumRange t=new TwoSumRange();
		System.out.println(t.find(100, 9999));
	}
	public List<Integer> find(int min, int max)
	{
		List<Integer> rs=new LinkedList<Integer>();
		for(int i=min; i<=max; i++)
		{
			if(valid(i))
				rs.add(i);
		}
		return rs;
	}
	public boolean valid(Integer num)
	{
		String str=num.toString();
		int pointer=0;
		while(pointer+2<str.length())
		{
			if(Integer.parseInt(""+str.charAt(pointer))+Integer.parseInt(""+str.charAt(pointer+1))!=Integer.parseInt(""+str.charAt(pointer+2)))
				break;
			pointer+=3;
			if(pointer==str.length())
				return true;
		}
		
		pointer=0;
		if(str.length()==6 || str.length()==7)
			if(Integer.parseInt(str.substring(0,2))+Integer.parseInt(str.substring(2,4))==Integer.parseInt(str.substring(4)))
				return true;
		
		if(str.length()==9)
			if(Integer.parseInt(str.substring(0,3))+Integer.parseInt(str.substring(3,6))==Integer.parseInt(str.substring(6)))
				return true;
		
		return false;
	}

}
