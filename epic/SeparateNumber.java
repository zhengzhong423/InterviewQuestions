package epic;

public class SeparateNumber {

	public static void main(String[] args) {
		System.out.println(separate("12378"));
	}
	public static String separate(String s)
	{
		char pre=s.charAt(0);
		String rs="";
		rs+=pre;
		
		for(int i=1; i<s.length(); i++)
		{
			char ch=s.charAt(i);
			if(Integer.parseInt(String.valueOf(pre))+1==Integer.parseInt(String.valueOf(ch)))
				rs+=ch;
			else
				rs+=(","+ch);
			pre=ch;
		}
		
		return rs;
		
	}

}
