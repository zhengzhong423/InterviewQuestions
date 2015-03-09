package epic;

public class ReplaceString {

	public static void main(String[] args) {
		ReplaceString r=new ReplaceString();
		System.out.println(r.separate("      A boy is a and djia"));
	}
	public String separate(String s)
	{
		String[] strs=s.split(" ");
		String rs="";
		for(int i=0; i<strs.length; i++)
		{
			if(strs[i].equals("a"))
				strs[i]="one";
			if(strs[i].equals("A"))
				strs[i]="ONE";
			rs+=(strs[i]+" ");
		}
		return rs.substring(0, rs.length()-1);
		
	}
}
