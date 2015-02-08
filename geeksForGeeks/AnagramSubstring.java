package geeksForGeeks;

public class AnagramSubstring {

	public static void main(String[] args) {
		helper("ABCD","BACDGABCDA");
	}
	
	public static Boolean compare(int[] BucketP, int[] BucketO)
	{
		for (int i = 0; i < BucketO.length; i++) 
			if (BucketO[i]!=BucketP[i]) 
				return false;
		return true;
	}
	
	public static void helper(String pattern, String original)
	{
		int[] BucketP=new int[255];
		int[] BucketO=new int[255];
		for(int i=0; i<pattern.length(); i++)
		{
			BucketP[pattern.charAt(i)]++;
			BucketO[original.charAt(i)]++;
		}
		for(int i=pattern.length(); i<original.length(); i++)
		{
			if(compare(BucketP, BucketO))
				System.out.println("Start:"+(i-pattern.length()));
			
			BucketO[original.charAt(i)]++;
			BucketO[original.charAt(i-pattern.length())]--;
		}
		
		if(compare(BucketP, BucketO))
			System.out.println("Start:"+(original.length()-pattern.length()));
	}

}
