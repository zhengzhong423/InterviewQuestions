package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubStringWithConcatenation {

	public static void main(String[] args) {
		String[] a={"a"};
		System.out.println(findSubstring("a", a));
	}
	 public static List<Integer> findSubstring(String S, String[] L) {
	        int windowSize=L.length*L[0].length();
	        List<Integer> result=new LinkedList<Integer>();
	        HashMap<String, Integer> hash=new HashMap<String, Integer>();
	        for(String s: L)
	            if(hash.containsKey(s))
	                hash.put(s, hash.get(s)+1);
	            else
	                hash.put(s, 1);
	        
	        for(int index=0; index<L[0].length(); index++)
	        {
	            HashMap<String, Integer> tempHash=new HashMap<String, Integer>(hash);
	            int count=hash.size();
	            for(int i=index; i<=S.length()-windowSize; i=i+L[0].length())
	            {
	                if(i==index)
	                {
	                    for(int j=i; j<i+windowSize; j=j+L[0].length())
	                    {
	                        if(tempHash.containsKey(S.substring(j, j+L[0].length())))
	                        {
	                            tempHash.put(S.substring(j, j+L[0].length()), tempHash.get(S.substring(j, j+L[0].length()))-1);
	                            if(tempHash.get(S.substring(j, j+L[0].length()))==0)
	                                count--;
	                            if(tempHash.get(S.substring(j, j+L[0].length()))==-1)
	                                count++;
	                        }
	                    }
	                    if(count==0)
	                        result.add(i);
	                }
	                else
	                {
	                    String lost=S.substring(i-L[0].length(),i);
	                    String getC=S.substring(i+windowSize-L[0].length(),i+windowSize);
	                    if(lost.equals(getC))
	                        continue;
	                        
	                    if(tempHash.containsKey(lost))
	                    {
	                        tempHash.put(lost, tempHash.get(lost)+1);
	                        if(tempHash.get(lost)==1)
	                            count++;
	                        if(tempHash.get(lost)==0)
	                            count--;
	                    }
	                    if(tempHash.containsKey(getC))
	                    {
	                        tempHash.put(getC, tempHash.get(getC)-1);
	                        if(tempHash.get(getC)==-1)
	                            count++;
	                        if(tempHash.get(getC)==0)
	                            count--;
	                    }
	                        
	                    if(count==0)
	                        result.add(i);
	                }
	            }
	        }
	        return result;
	    }

}
