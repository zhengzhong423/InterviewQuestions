package leetCode;

public class BitCount {

	public static void main(String[] args) {
		 BitCount bc=new BitCount();
		 bc.helper(Integer.MAX_VALUE+1);
	}
	
	public void helper(int num)
	{
		String s=Long.toBinaryString(num);
		System.out.println(s);
	}

}
