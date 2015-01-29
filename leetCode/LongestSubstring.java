package leetCode;

public class LongestSubstring {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
	}
    public static int lengthOfLongestSubstring(String s) {
    	int cur=0;
    	int result=0;
        String temp="";
        for(int i=0; i<s.length(); i++)
        {
        	if(!temp.contains(""+s.charAt(i)))
        	{
        		temp+=s.charAt(i);
        		cur++;
        	}
        	else
        	{
        		int index=temp.indexOf(s.charAt(i));
        		temp+=s.charAt(i);
        		temp=temp.substring(index+1);
        		cur=temp.length();
        	}
        	result=Math.max(result, cur);
        }
        return result;
    }
}
