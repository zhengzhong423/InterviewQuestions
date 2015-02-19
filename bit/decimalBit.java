package bit;

public class decimalBit {

	public static void main(String[] args) {
		
		myDecimalBit("3.75");
	}
	public static void myDecimalBit(String s)
	{
		int iPart=Integer.parseInt(s.substring(0, s.indexOf('.')));
		double dPart=Double.parseDouble(s.substring(s.indexOf('.')));
		String iString=Integer.toBinaryString(iPart);
		String dString="";
		double temp=dPart*2;
		while(true)
		{
			if(dString.length()>32) {System.out.println("ERROR"); return;}
			if(temp>=1)
			{
				dString=dString+"1";
				if(temp==1) break;
				temp=temp-1;
			}
			else
			{
				dString=dString+"0";
			}
			temp=temp*2;
		}
		String result=iString+"."+dString;
		System.out.println(result);
	}
}
