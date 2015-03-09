package epic;

public class DeleteDup {

	public static void main(String[] args) {
		String src="100441440065556778";
		while(src.length()!=helper(src).length())
		{
			src=helper(src);
		}
		System.out.println(src);
	}
	public static String helper(String s)
	{
		if(s.length()<=1)
			return s;
		String rs="";
		for(int i=0; i<s.length()-1; i++)
		{
			if(i==0)
			{
				if(s.charAt(i)!=s.charAt(i+1))
					rs+=s.charAt(i);
			}
			else
			{
				if(s.charAt(i)!=s.charAt(i-1) && s.charAt(i)!=s.charAt(i+1))
				{
					rs+=s.charAt(i);
				}
			}
		}
		if(s.charAt(s.length()-1)!=s.charAt(s.length()-2))
		{
			rs+=(s.charAt(s.length()-1));
		}
		return rs;
	}

}
