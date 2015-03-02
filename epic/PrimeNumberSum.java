package epic;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimeNumberSum {

	public static void main(String[] args) {
		new PrimeNumberSum().helper(40);
	}
	public void helper(Integer num)
	{
		ArrayList<Integer> prime=findPrime(num);
		HashSet<Integer> hash=new HashSet<>(prime);
		for(int i=2; i<num; i++)
			if(hash.contains(i) && hash.contains(num-i) && i<num-i)
				System.out.println(String.valueOf(i)+" "+String.valueOf(num-i));
	}
	
	private ArrayList<Integer> findPrime(Integer num) 
	{
		ArrayList<Integer> rs=new ArrayList<Integer>();
		for(int i=2; i<num; i++)
			if(PrimeTest(i))
				rs.add(i);
		return rs;
	}
	private boolean PrimeTest(int num) {
		for(int i=num/2;i>=2; i--)
			if(num%i==0)
				return false;
		return true;
	}

}
