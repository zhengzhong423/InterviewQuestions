package recursive;

public class Coin {

	public static void main(String[] args) {
		System.out.println(getCoin(100,25));
	}
	public static int getCoin(int sum, int Coin)
	{
		int result=0, nextCoin=0;
		if(sum==0)
			return 1;
		switch(Coin)
		{
			case 25:
				nextCoin=10;
				break;
			case 10:
				nextCoin=5;
				break;
			case 5:
				nextCoin=1;
			case 1:
				return 1;
		}
		for(int i=0; i*Coin<=sum;i++)
		{
			result+=getCoin(sum-i*Coin, nextCoin);
		}
		return result;
	}
}
