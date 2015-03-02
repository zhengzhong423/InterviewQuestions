package epic;

public class VerifyPassword {

	public static void main(String[] args) {
		VerifyPassword v=new VerifyPassword(); 
		System.out.println(v.helper("164", "18468"));
	}
	public boolean helper(String enter, String expected)
	{
		if(enter.equals(expected))
			return true;
		int num=getKey(enter, expected);
		if(num==-1)
			return false;
		
		expected=expected.replaceAll(String.valueOf(num), "");
		if(enter.equals(expected))
			return true;
		return false;
	}
	private int getKey(String enter, String expected) {
		int[] en=new int[10];
		int[] ex=new int[10];
		
		for(int i=0; i<enter.length(); i++)
			en[Integer.parseInt(""+enter.charAt(i))]++;
		for(int i=0; i<expected.length(); i++)
			ex[Integer.parseInt(""+expected.charAt(i))]++;
		
		int num=-1;
		for(int i=0; i<10; i++)
		{
			if(en[i]==0 && ex[i]!=0)
				if(num==-1)
					num=i;
				else
					return -1;
		}
		return num;
	}

}
