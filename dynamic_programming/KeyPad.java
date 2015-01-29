package dynamic_programming;
/**
 * http://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
 * @author dell
 *
 */
public class KeyPad {
	
	public static void main(String[] args) {
		System.out.println(keyPad(5));
	}
	public static int keyPad(int N)
	{
		int opt[][]=new int[10][N];
		for(int i=0; i<10; i++)
		{
			opt[i][0]=1;
		}
		for(int i=1; i<N; i++)
		{
					opt[0][i]=opt[8][i-1]+opt[0][i-1];
					opt[7][i]=opt[8][i-1]+opt[4][i-1]+opt[7][i-1];
					opt[9][i]=opt[6][i-1]+opt[8][i-1]+opt[9][i-1];
					opt[1][i]=opt[2][i-1]+opt[4][i-1]+opt[1][i-1];
					opt[3][i]=opt[2][i-1]+opt[6][i-1]+opt[3][i-1];
					opt[2][i]=opt[1][i-1]+opt[3][i-1]+opt[5][i-1]+opt[2][i-1];
					opt[4][i]=opt[1][i-1]+opt[5][i-1]+opt[7][i-1]+opt[4][i-1];
					opt[6][i]=opt[3][i-1]+opt[9][i-1]+opt[5][i-1]+opt[6][i-1];
					opt[5][i]=opt[8][i-1]+opt[2][i-1]+opt[6][i-1]+opt[4][i-1]+opt[5][i-1];
					opt[8][i]=opt[0][i-1]+opt[7][i-1]+opt[9][i-1]+opt[5][i-1]+opt[8][i-1];
		}
		int sum=0;
		for(int i=0; i<10; i++)
			sum+=opt[i][N-1];
		return sum;
	}

}
