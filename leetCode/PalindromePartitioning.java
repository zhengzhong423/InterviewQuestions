package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> result=new LinkedList<List<String>>();   // final result
	
	public static void main(String[] args) {
		PalindromePartitioning p=new PalindromePartitioning();
		p.partition("aab");
		}

    public  List<List<String>> partition(String s) {
        char[] ch=s.toCharArray();
        helper(ch, 0, new LinkedList<String>());
        return result;
        
    }
    public void helper(char[] ch, int index , List<String> temp)
    {
        if(index==ch.length)
            result.add(new LinkedList<String>(temp));   //deep copy
        int start=index;
        while(index<ch.length)
        {
            List<String> tempResult=new LinkedList<>(temp);
            if(isPalidrome(ch, start, index))
            {
                tempResult.add(new String(ch, start, index-start+1));
                helper(ch, index+1, tempResult);
            }
            index++;
        }
    }
    
    public boolean isPalidrome(char[] ch, int s, int e)
    {
        while(s<e)
        {
            if(ch[s]!=ch[e])
                return false;
            s++;
            e--;
        }
        return true;
    }
	 public static List<List<String>> partition2(String s) {
	     List<List<List<String>>> result= new ArrayList<List<List<String>>>();
	     for(int i=0; i<=s.length(); i++)
	     {
	    	 List<List<String>> tmp=new LinkedList<List<String>>();
	    	 result.add(tmp);
	     }
		 for(int i=0; i<=s.length(); i++)
	        	for(int j=0; j<=i ;j++)
	        	{
	        		if(isPalindrome(s.substring(j, i)))
	        		{
	        			for(List<String> r: result.get(j))
	        			{
	        					List<String> ri = new ArrayList<String>(r);
	        					ri.add(s.substring(j,i));
	        					result.get(i).add(ri);
	        			}
	        			if(result.get(j).size()==0)
	        			{
	        				List<String> ri = new ArrayList<String>();
        					ri.add(s.substring(j,i));
        					result.get(i).add(ri);
	        			}
	        		}
	        	}
		 return result.get(s.length());
	 }
	 public static boolean isPalindrome(String str)
	 {
		 if(str.length()==0)
			 return false;
		 for(int i=0; i<=str.length()/2; i++)
		 {
			 if(str.charAt(i)!=str.charAt(str.length()-i-1))
			 	return false;
		 }
		 return true;
	 }
}
