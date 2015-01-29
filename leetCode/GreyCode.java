package leetCode;

import java.util.LinkedList;
import java.util.List;

public class GreyCode {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public List<Integer> grayCode(int n) {
		List<String> result=new LinkedList<String>();
		helper(n, result);
		List<Integer> l=new LinkedList<Integer>();
		for(String s:result)
			l.add(Integer.parseInt(s,2));
		return l;
    }
	public void helper(int n, List<String> result)
	{
		if(n==1)
		{
			result.add("0");
			result.add("1");
			return;
		}
		if(n>1)
		{
		    helper(n-1, result);
			List<String> tempResult=new LinkedList<String>();
			for(int i=0; i<result.size(); i++)
			{
				tempResult.add("0"+result.get(i));
			}
			for(int i=0; i<result.size(); i++)
			{
				tempResult.add("1"+result.get(result.size()-1-i));
			}
			result.clear();
			result.addAll(tempResult);
		}
	}

}
