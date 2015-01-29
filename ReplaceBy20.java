
public class ReplaceBy20 {

	public static void main(String[] args)
	{
		String s="jsif sjdifower ryetuihd hugir";
		ReplaceBy20 r=new ReplaceBy20();
		System.out.println(r.replaceBy20(s));
	}
	public String replaceBy20(String s)
	{
		return s.replaceAll(" ", "%20");
	}

}
