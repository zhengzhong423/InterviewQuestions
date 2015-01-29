package chapter8_recursive;

import java.util.LinkedList;

public class Permutation {

	public static void main(String[] args) {
		LinkedList<String> result=getPermutation("123",0);
		System.out.println(result);
	}
	public static LinkedList<String> getPermutation(String s, int index)
	{
		LinkedList<String> result = new LinkedList<String>();
		if(s.length()==index)
		{
			String temp = "";
			result.add(temp);
		}
		else
		{
			result=getPermutation(s, index+1);
			String tempString=s.charAt(index)+"";
			LinkedList<String> moreResult = new LinkedList<String>();
			for(String myString : result)
			{
				for(int i=0; i<=myString.length(); i++)
				{
					if(myString.length()==0)
						moreResult.add(tempString);
					else
						moreResult.add(myString.substring(0, i)+tempString+myString.substring(i));
				}
			}
			result.clear();
			result.addAll(moreResult);
		}
		return result;
	}

}
