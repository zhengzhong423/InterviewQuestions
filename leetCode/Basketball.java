package leetCode;

public class Basketball {

	public static void main(String[] args) {
		System.out.println(new Basketball().helper(100, 100, 10));
	}
	public int helper(int made, int attempt, int games)
	{
		double fAttempt=games*4.5;
		int get=(int)Math.ceil(0.45*(attempt+fAttempt)-made);
		if(get>fAttempt)
			return -1;
		else if(get<=0)
			return 0;
		else
			return get;
	}

}
