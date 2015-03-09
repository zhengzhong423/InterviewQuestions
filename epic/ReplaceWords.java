package epic;

public class ReplaceWords {
	public static void main(String[] args)
	{
		System.out.println(new ReplaceWords().replace("A person can't walk in this street"));
	}
	
	public String replace(String str)
	{
		String[] strs=str.split(" ");
		String rs="";
		for(int i=0; i<strs.length; i++)
		{
			int len=getLen(strs[i]);
			if(len>=0 && len%2==0 && strs[i].length()>=4)
				rs+=(addSpace(strs[i], len)+" ");
			else
				rs+=(strs[i]+" ");
		}
		return rs.trim();
		
	}
	private String addSpace(String str, int len) {
		int mid=len/2;
		int count=0;
		String rs="";
		for(int i=0; i<str.length(); i++)
		{
			if((str.charAt(i)>='a' && str.charAt(i)<='z')|| (str.charAt(i)>='A' && str.charAt(i)<='Z'))
				count++;
			rs+=str.charAt(i);
			if(count==mid)
				rs+=" ";
		}
		return rs;
	}

	public int getLen(String str)
	{
		char[] ch=str.toCharArray();
		int len=0;
		for(int i=0; i<str.length(); i++)
		{
			if((ch[i]>='a' && ch[i]<='z') || (ch[i]>='A' && ch[i]<='Z'))
				len++;
		}
		return len;
	}
}
