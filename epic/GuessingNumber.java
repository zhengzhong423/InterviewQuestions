package epic;

import java.util.HashMap;

public class GuessingNumber {

	public static void main(String[] args) {
		GuessingNumber g=new GuessingNumber();
		int[] rs=g.helper("babb", "abcd");
		System.out.println(rs[0]+" "+rs[1]);
	}
	public int[] helper(String guess, String des)
	{
		int N=guess.length();
		HashMap<Character, Integer> hash=new HashMap<Character, Integer>();
		int A=0;
		int B=0;
		for(int i=0; i<N; i++)
		{
			if(guess.charAt(i)==des.charAt(i))
				A++;
			else
			{
				if(!hash.containsKey(des.charAt(i)))
					hash.put(des.charAt(i), 1);
				else
					hash.put(des.charAt(i), hash.get(des.charAt(i))+1);
			}
		}
		
		for(int i=0; i<N; i++)
		{
			if(guess.charAt(i)!=des.charAt(i))
			{
				if(hash.containsKey(guess.charAt(i)) && hash.get(guess.charAt(i))>0)
				{
					B++;
					hash.put(guess.charAt(i), hash.get(guess.charAt(i))-1);
				}
			}
		}
		
		return new int[] {A, B};
	}

}
