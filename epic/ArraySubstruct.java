package epic;

public class ArraySubstruct {
	static boolean isNeg=false;
	public static void main(String[] args)
	{
		int[] ch1={1,9};
		int[] ch2={1,6,1};
		String result=new ArraySubstruct().helper(ch1, ch2);
		if(isNeg)
			System.out.println("-"+result);
		else
			System.out.println(result);
	}
	public String helper(int[] ch1, int[] ch2)
	{
		if(compare(ch1, ch2)) //make sure that the number in ch1 is bigger than ch2
		{
			int[] temp=ch1;
			ch1=ch2;
			ch2=temp;
			isNeg=true;
		}
		ch1=reverse(ch1);
		ch2=reverse(ch2);
		int N=ch2.length; 
		int carry=0;
		String rs="";
		int i=0;
		for(; i<N; i++)
		{
			int num=ch1[i]-carry-ch2[i];
			if(num<0)
			{
				carry=1;
				num+=10;
			}
			else
				carry=0;
			rs+=String.valueOf(num);
		}
		
		while(i<ch1.length)
		{
			int num=ch1[i]-carry;
			if(num<0)
			{
				carry=1;
				num+=10;
			}
			else
				carry=0;
			rs+=String.valueOf(num);
			i++;
		}
		if(rs.charAt(rs.length()-1)=='0' && rs.length()>1)
			rs=rs.substring(0, rs.length()-1);
		StringBuffer s=new StringBuffer(rs);
		rs=s.reverse().toString();
		return rs;
	}

	private int[] reverse(int[] ch) {
		int k=0;
		while(k<ch.length/2)
		{
			ch[k]=ch[ch.length-1-k]+ch[k];
			ch[ch.length-1-k]=ch[k]-ch[ch.length-1-k];
			ch[k]=ch[k]-ch[ch.length-1-k];
			k++;
		}
		return ch;
	}
	private boolean compare(int[] ch1, int[] ch2) {
		if(ch2.length>ch1.length)
			return true;
		if(ch2.length==ch1.length)
		{
			for(int i=0; i<ch1.length; i++)
			{
				if(ch2[i]>ch1[i])
					return true;
				if(ch1[i]>ch2[i])
					return false;
			}
		}
		return false;
	}
}
