package epic;

public class DupNumber {

	public static void main(String[] args) {
		DupNumber d=new DupNumber();
		System.out.println(d.helper("11220049"));
	}
	public String helper(String s)
	{
		String rs="";
		for(int i=0; i<s.length(); i++)
		{
			if(i==0)
			{
				if(s.charAt(i)!=s.charAt(i+1))
					rs+=s.charAt(0);
			}
			else if(i==s.length()-1)
			{
				if(s.charAt(i)!=s.charAt(i-1))
					rs+=s.charAt(i);
			}
			else
				if(s.charAt(i)!=s.charAt(i-1) && s.charAt(i)!=s.charAt(i+1))
					rs+=s.charAt(i);
		}
		return rs;
	}

}
