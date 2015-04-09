package interesting;


public class BitAdd {

	public static void main(String[] args) {
		BitAdd ba=new BitAdd();
		System.out.println(ba.add(-3, -10));
	}
	
	public int add(int a, int b)
	{
		int sum=0;
		int k=0;
		int carry=0;
		while(k<32)
		{
			int digitA=a&0x0001;
			int digitB=b&0x0001;
			
			System.out.println(Integer.toBinaryString(digitA));
			
			int thisDigit=digitA ^ digitB^ carry;
			carry=(digitA & digitB) | (digitA & carry) | (digitB & carry);
			
			a=a>>1;
			b=b>>1;
			sum=sum|(thisDigit<<k);
			k++;
		}
		return sum;
		
	}

}
