package epic;

public class SwapString {

	public static void main(String[] args) {
		new SwapString().swap("ddebc", "adcdd");
	}
	
	public void swap(String s1, String s2)
	{
		if(s1.length()!=s2.length())
		{
			System.out.println("false");
			return ;
		}
		char[] ch1=s1.toCharArray();
		char[] ch2=s2.toCharArray();
		int i=0;
		System.out.println(ch2);
		while(i<s1.length())
		{
			int j=i;
			while(j<s2.length() && ch1[i]!=ch2[j])
				j++;
			if(j==s2.length())
			{
				System.out.println("false");
				return ;
			}
			while(j>i)
			{
				char temp=ch2[j];
				ch2[j]=ch2[j-1];
				ch2[j-1]=temp;
				System.out.println(ch2);
				j--;
			}
			i++;
		}
	}

}
