package epic;

public class SteppingNumber {

	public static void main(String[] args) {
		System.out.println(new SteppingNumber().helper(908));
	}
	public boolean helper(Integer num)
	{
		String str=num.toString();
		if(str.length()==1)
			return true;
		char pre=str.charAt(0);
		for(int i=1; i<str.length(); i++)
		{
			if(Math.abs((int)(str.charAt(i)-pre))!=1)
					return false;
			pre=str.charAt(i);
		}
		return true;
	}

}
