package epic;

import java.util.HashSet;

public class ColorfulNumber {

	public static void main(String[] args) {
		ColorfulNumber c=new ColorfulNumber();
		System.out.println(c.helper(23));
	}
	public boolean helper(Integer num)
	{
		HashSet<Integer> hash=new HashSet<Integer>(); 
		String str=String.valueOf(num);
		for(int i=0; i<str.length(); i++)
		{
			Integer k=Integer.parseInt(str.charAt(i)+"");
			HashSet<Integer> temp=new HashSet<>();
				for(Integer number: hash)
				{
					if(hash.contains(k*number))
						return false;
					else
						temp.add(k*number);
				}
			hash.addAll(temp);
			if(!hash.add(k))
				return false;
		}
		return true;
	}

}
