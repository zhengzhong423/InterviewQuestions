package epic;

public class OctDec {

	public static void main(String[] args) {
		for(int i=0; i<10000; i++)
			if(new OctDec().check(i))
				System.out.println(i);
	}
	public boolean check(int k)
	{
		if(Pali(String.valueOf(k)) && Pali(Oct(String.valueOf(k))))
			return true;
		return false;
	}
	public String Oct(String num)
	{
		int n=Integer.parseInt(num);
		String rs="";
		while(n>=8)
		{
			rs=String.valueOf((n%8))+rs;
			n=n/8;
		}
		rs=String.valueOf(n%8)+rs;
		return rs;
	}
	public boolean Pali(String s)
	{
		char[] ch=s.toCharArray();
		for(int i=0; i<s.length()/2; i++)
			if(ch[i]!=ch[ch.length-i-1])
				return false;
		return true;
	}

}
