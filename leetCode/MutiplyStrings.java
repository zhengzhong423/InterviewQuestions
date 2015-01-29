package leetCode;

public class MutiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("123", "321"));

	}
	 public static String multiply(String num1, String num2) 
	 {
		 String zeros="";
		 StringBuffer sb=new StringBuffer();
		 StringBuffer temp=new StringBuffer();
	        for(int i=num2.length()-1; i>=0; i--)
	        {
	        	temp=oneDigitMul(num1 , String.valueOf(num2.charAt(i)));
	        	temp.append(zeros);
	        	zeros+="0";
	        	sb=strAdd(new StringBuffer(sb), temp);
	        }
	      return sb.toString();
	 }
	public static StringBuffer oneDigitMul(String num1, String oneDigit)
    {
        int additional=0;
        StringBuffer sb=new StringBuffer();
        for(int i=num1.length()-1 ; i>=0 ; i--)
        {
                int num=Integer.parseInt(String.valueOf(num1.charAt(i)))*Integer.parseInt(oneDigit);
                int digit=(num+additional)%10;
                sb.insert(0, Integer.toString(digit));
                additional=(num+additional)/10;
        }
        if(additional>0)
            sb.insert(0, Integer.toString(additional));
        return sb;
    }
	public static StringBuffer strAdd(StringBuffer num1, StringBuffer num2)
	{
		if(num1.length()==0)
			return new StringBuffer(num2);
		for(int i=0; i<num1.length(); i++)
		{
			if(num1.charAt(i)!='0')
				break;
			if(i==num1.length()-1)
				return  new StringBuffer(num2);
		}
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		StringBuffer sb3=new StringBuffer();
		if(num1.length()<num2.length())
		{
			sb1.append(num2);
			sb2.append(num1);
		}
		else
		{
			sb1.append(num1);
			sb2.append(num2);
		}
		int add=0;
		for(int i=0; i<sb2.length(); i++)
		{
			int num=add+Integer.parseInt(String.valueOf(sb2.charAt(sb2.length()-1-i))) + Integer.parseInt(String.valueOf(sb1.charAt(sb1.length()-1-i)));
			sb3.insert(0, Integer.toString(num%10));
			if(num>=10)
				add=1;
			else
				add=0;
		}
		if(add==1)
			sb3.insert(0, strAdd( new StringBuffer(sb1.substring(0, sb1.length()-sb2.length())) , new StringBuffer("1")));
		else
			sb3.insert(0, sb1.substring(0, sb1.length()-sb2.length()));
		return sb3;
	}
}
