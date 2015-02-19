package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Circus {

	public static void main(String[] args) 
	{	
		ArrayList<WeightHeight> a=new ArrayList<WeightHeight>();
		//(60, 100) (70, 150) (56, 90) (75, 130) (60, 95) (68,110)
		a.add(new WeightHeight(60, 100));
		a.add(new WeightHeight(70, 150));
		a.add(new WeightHeight(56, 90));
		a.add(new WeightHeight(75, 130));
		a.add(new WeightHeight(61, 95));
		a.add(new WeightHeight(68, 110));
		Collections.sort(a, new WeightHeight());
		ArrayList<Integer> b=new ArrayList<Integer>();
		for(WeightHeight temp: a)
		{
			b.add(temp.weight);
		}
		LIS(b);
	}
	public static void LIS(ArrayList<Integer> a)
	{
		int[] opt=new int[a.size()];
		for(int i=0; i<=a.size()-1; i++)
			opt[i]=1;
		for(int i=1; i<=a.size()-1; i++)
		{
			opt[i]=opt[i-1];
			for(int j=0; j<=i; j++)
			{
				if(a.get(i)>a.get(j) && opt[i]<opt[j]+1)
				{
					opt[i]=opt[j]+1;
				}
			}
			
		}
		System.out.println(opt[a.size()-1]);
	}
}
