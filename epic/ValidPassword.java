package epic;

public class ValidPassword {

	public static void main(String[] args) {
		ValidPassword v=new ValidPassword();
		System.out.println(v.validPassword("1q123123"));
	}
	public boolean validPassword(String s)
	{
		if(s.length()>12 || s.length()<5)
			return false;
		boolean hasNumber=false;
		boolean hasLowerCase=false;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)>='0' && s.charAt(i)<='9')
				hasNumber=true;
			if(s.charAt(i)>='a' && s.charAt(i)<='z')
				hasLowerCase=true;
		}
		if(hasNumber && hasLowerCase)
		{
			if(!checkSequence(s))
				return false;
		}
		else
			return false;
		return true;
	}
	private boolean checkSequence(String s) {
		
		for(int len=1; len<s.length(); len++)
			for(int i=0; i<s.length(); i++)
			{
				int j=i+len;
				int nextStart=j;
				int nextEnd=j+len;
				if(nextEnd<=s.length())
				{
					if(s.substring(i, j).equals(s.substring(nextStart, nextEnd)))
						return false;
				}
				else
					break;
			}
		return true;
			
	}

}
