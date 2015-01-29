package chapter5_bit;

public class bitUpdate {

	public static void main(String[] args)
	{
		int k=updateBits(1024,3,0,1);
		String m=Integer.toBinaryString(k);
		System.out.println(m);
	}
	public static int updateBits(int k, int l, int i, int j) {
			int max = ~0; 
			int left = max - ((1 << j) - 1);
			int right = ((1 << i) - 1); 
			int mask = left | right; 
			return (k & mask) | (l << i); 
}
}
