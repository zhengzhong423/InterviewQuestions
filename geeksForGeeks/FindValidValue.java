package geeksForGeeks;

public class FindValidValue {

	public static void main(String[] args) {
		int a1=1;
		int a2=2;
		int a3=3;
		int pre=a3;
		int val=a3*a2+a1;
		int k=4;
		while(val>pre)
		{
			pre=val;
			a1=a2;
			a2=a3;
			a3=val;
			val=a3*a2+a1;
			k++;
		}
		System.out.println(k);

	}

}
