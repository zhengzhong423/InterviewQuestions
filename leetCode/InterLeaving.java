package leetCode;

import java.util.ArrayList;


public class InterLeaving {

	
	public static void main(String[] args) {
		System.out.println(isInterleave2("a","b","ab"));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()==0 && s3.length()==0 && s2.length()==0)
			return true;
		if(s3.length()==0)
			return false;
		if(s1.length()>0 && s2.length()>0)
		if(s1.charAt(0)==s3.charAt(0) && s2.charAt(0)==s3.charAt(0))
			return isInterleave(s1, s2.substring(1), s3.substring(1)) || isInterleave(s1.substring(1), s2, s3.substring(1));
		if(s2.length()>0)
			if(s2.charAt(0)==s3.charAt(0))
				return isInterleave(s1, s2.substring(1), s3.substring(1));
		if(s1.length()>0)
			if(s1.charAt(0)==s3.charAt(0))
				return isInterleave(s1.substring(1), s2, s3.substring(1));
		return false;
    }
    public static boolean isInterleave2(String s1, String s2, String s3) {
    	return helper(s1, s2, s3) || helper(s2, s1, s3);
       
    }
	private static boolean helper(String s1, String s2, String s3) {
			int j=0;
			int i=0;
			ArrayList<Integer> l=new ArrayList<Integer>();
	        for(i=0; i<s3.length(); i++)
	        {
	        	if(j>=s1.length())
	        		break;
	        	if(s1.charAt(j)==s3.charAt(i))
	        	{
	        		j++;
	        		continue;
	        	}
	        	l.add(i);
	        }
	        if(j!=s1.length())
	        	return false;
	        for(int k=i; k<s3.length(); k++)
	        	l.add(k);
	        String copy="";
	        for(int k=0; k<l.size(); k++)
	        	copy+=s3.charAt(l.get(k));

	        if(copy.equals(s2))
	        	return true;
	        return false;
	}

}
