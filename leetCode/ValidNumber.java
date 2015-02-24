package leetCode;

public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber vn=new ValidNumber();
		System.out.println(vn.validNumber("11"));
	}
	public boolean validNumber(String s)
	{
		String str=s.trim();
		boolean b1=str.matches("\\d+\\.\\d*") ;
		boolean b2=	str.matches("\\d+e\\d+");
		boolean b3=str.matches("\\d+") ;
		boolean b4=str.matches("\\.\\d+");
		return b1|| b2|| b3|| b4;
	}

}
