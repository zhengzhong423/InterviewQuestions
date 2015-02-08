package geeksForGeeks;

public class StringCompression {

	public static void main(String[] args) {
		String s="aasasasatb";
		int[][] record=new int[s.length()][s.length()];
		record=helper(s);
		for(int i=0; i<record.length; i++)
		{
			for(int j=0; j<record[0].length; j++)
				System.out.print(record[i][j]+"  ");
			System.out.println();
		}
		int[] path=opt(record, s);
		int i=s.length();
		System.out.println(i);
		while(i>0)
		{
			i=path[i];
			System.out.println(i);
		}
	}
	public static int[] opt(int[][] record, String s)
	{
		int[] opt=new int[s.length()+1];
		int[] path=new int[s.length()+1];
		for(int i=1; i<=s.length(); i++)
		{
			opt[i]=record[0][i-1];
			for(int j=0; j<i; j++)
			{
				if(opt[i]>opt[j]+record[j][i-1])
				{
					opt[i]=Math.min(opt[i], opt[j]+record[j][i-1]);
					path[i]=j;
				}
			}
		}
		return path;
	}
	
	
	public static int[][] helper(String s)
	{
		int[][] opt=new int[s.length()][s.length()];
		for(int len=0; len<s.length(); len++)
			for(int i=0; i<s.length()-len; i++)
			{
				int j=i+len;
				opt[i][j]=1000;
				for(int k=i; k<j; k++)
				{
					int flag=isGood(s, i, j, k);
					if(flag!=-1)
					{
						opt[i][j]=Math.min(opt[i][j], flag);
					}
				}
				if(opt[i][j]==1000 && j==i)
					opt[i][j]=2;
			}
		return opt;
	}
	public static int isGood(String s, int i, int j, int k)
	{
		if((j-i+1)%(k-i+1)!=0)
			return -1;
		int start=i;
		int end=k;
		String base=s.substring(i,k+1);
		while(end<j)
		{
			if(!base.equals(s.substring(start+(k-i)+1, end+(k-i)+2)))
				return -1;
			start+=(k-i+1);
			end+=(k-i+1);
		}
		return 2+k-i;
		
	}

}
