package geeksForGeeks;

/**
Input: str = "123123"
Output: 6
The complete string is of even length and sum of first and second
half digits is same

Input: str = "1538023"
Output: 4
The longest substring with same first and second half sum is "5380"
**/

/* Name of the class has to be "Main" only if the class is public. */
class LongestSame
{
	int start;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		LongestSame i=new LongestSame();
		
		String s="153803";
		int len=i.helper(s);
		System.out.println(s.substring(i.start, i.start+len));
	}
	public int helper(String str)
	{
		int max=0;
		int[][] opt=new int[str.length()][str.length()];
		for(int i=0; i<str.length(); i++)
			opt[i][i]=Integer.parseInt(String.valueOf(str.charAt(i)));
		for(int len=1; len<str.length(); len++)
			for(int i=0; i<str.length()-len; i++)
			{
				int j=i+len;
				int k=len/2;
				opt[i][j]=opt[i][j-1]+Integer.parseInt(str.charAt(j)+"");
				if(len%2!=0 && opt[i][i+k]==opt[i+k+1][j] && len+1>max)
				{
					start=i;
					max=len+1;
				}
			}
		return max;
	}
	
}