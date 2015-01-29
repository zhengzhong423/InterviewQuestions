package geeksForGeeks;

public class Bit1s {

	public static void main(String[] args) {
		System.out.println(getOnes(7));
	}
	public static int getOnes(int k)
	{
		int max=1+(int) (Math.log(k)/Math.log(2));
		int num=0;
		for(int i=0; i<=max; i++)
			if(((1<<i) & k)!=0)
				num++;
		return num;
	}

}
