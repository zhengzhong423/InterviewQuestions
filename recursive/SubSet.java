package recursive;

import java.util.ArrayList;

public class SubSet 
{
	public static void main(String[] args)
	{	
		ArrayList<Integer> a= new ArrayList<Integer>();
		a.add(0); a.add(1); a.add(1);
		GetSubSet(a, a.size());
	}
	public static ArrayList<ArrayList<Integer>> GetSubSet(ArrayList<Integer> a, int index)
	{
		ArrayList<ArrayList<Integer>> AllSubSet=new ArrayList<ArrayList<Integer>>();
		if(index==0)
		{
			AllSubSet=new ArrayList<ArrayList<Integer>>();
			AllSubSet.add(new ArrayList<Integer>());
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.add(a.get(0));
			AllSubSet.add(temp);
		}
		else
		{
			AllSubSet=GetSubSet(a, index-1);
			if(index==a.size())
				return AllSubSet;
			int item = a.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : AllSubSet)
			{
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			AllSubSet.addAll(moresubsets);
		}
		return AllSubSet;
	}
}
