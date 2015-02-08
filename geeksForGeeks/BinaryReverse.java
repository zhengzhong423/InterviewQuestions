package geeksForGeeks;

public class BinaryReverse {

	public static void main(String[] args) {
		helper(12);
	}
	public static void helper(Integer k)
	{
		String s="";
		while(k>0)
		{
			s=String.valueOf(k%2)+s;
			k=k/2;
		}
		String rs="";
		for(int i=0; i<s.length(); i++)
			if(s.charAt(i)=='0')
				rs=rs+"1";
			else
				rs=rs+"0";
		System.out.println(Integer.parseInt(rs,2));
	}

}
