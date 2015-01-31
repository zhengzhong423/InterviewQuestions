package cracking;

public class StringRotation {

	public static void main(String[] args) 
	{
		StringRotation r=new StringRotation();
		String s1="cba";
		String s2="abc";
		System.out.println(r.stringRotation(s1, s2));
	}
	public boolean stringRotation(String s1,String s2)
	{
		if(s1.length()==s2.length())
		{
			if(s1.length()==0)
				return true;
			else
			{
				int start=s2.indexOf(s1.charAt(0));
				if(start>=0)
				{
				int i=0;
				int j=start;
				while(i<s1.length())
				{
					if(j>=s2.length())
						j=j-s2.length();
					if(s2.charAt(j)==s1.charAt(i))
					{
						j++;
						i++;
					}
					else
					{
						return false;
					}
				}
				return true;
				}
			}
			
		}
		return false;
	}
}
