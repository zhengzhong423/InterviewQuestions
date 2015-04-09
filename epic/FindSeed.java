package epic;

public class FindSeed {

	public static void main(String[] args) {
		FindSeed f=new FindSeed();
		f.helper(1716);
	}
	public void helper(Integer k)
	{
		int seed=1;
		while(k>=seed)
		{
			if(k%seed==0)
			{
				int data=k/seed;
				if(data==getMul(seed))
				{
					System.out.print(seed+" ");
					for(int i=0; i<String.valueOf(seed).length(); i++)
						System.out.print(String.valueOf(seed).charAt(i)+" ");
					System.out.println();
				}
			}
			seed++;
		}
	}
	private int getMul(int data) {
		int rs=1;
		while(data>0)
		{
			rs*=(data%10);
			data=(data-data%10)/10;
		}
		return rs;
	}

}
