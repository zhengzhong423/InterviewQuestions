package leetCode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

	public static void main(String[] args) {
		System.out.println(letterCombinations("2"));
	}
	public static List<String> letterCombinations(String digits) {
        String[] source={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result=new LinkedList<String>();
        if(digits==null)
        	return result;
        result.add("");
		for(int i=0; i<digits.length(); i++)
        {
			List<String> temp=new LinkedList<String>();
        	int num=(int)(digits.charAt(i)-48);
        	for(int j=0; j<source[num].length(); j++)
        		for(String s:result)
        		{
        			String tempS=s+source[num].charAt(j);
        			temp.add(tempS);
        		}
        	result.clear();
        	result=temp;
        }
		return result;
    }
}
