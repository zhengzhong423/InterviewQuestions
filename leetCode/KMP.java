package leetCode;

public class KMP {

	public static void main(String[] args) {
		System.out.println(strStr("mississippi","issip"));
	}
	public static int strStr(String haystack, String needle) {
		int[] next=getNext("issip");
		int j=0;
		for(int i=0; i<haystack.length(); i++)
		{
			if(haystack.charAt(i)!=needle.charAt(j))
				j=next[j];
			if(haystack.charAt(i)==needle.charAt(j))
				j++;
			if(j==needle.length())
				return 1+i-j;
		}
		return -1;
		
    }
	 public static int[] getNext(String needle)
	    {
	        int[] next= new int[needle.length()];
	        int j=0;
	        for(int i=1; i<needle.length(); i++)
	        {
	            if(needle.charAt(i)==needle.charAt(j))
	                j++;
	            else
	                next[i]=j;
	        }
	        return next;
	    }
	 public static int[] makeNext(char[] arr){
		 	int len = arr.length;
		    int[] next = new int[len];
		    next[0]=0;
		    int j=0;
		    if(arr.length==1)
		    	return next;
		    for(int i=1; i<len; i++)
		    {
		    	if(j>0 && arr[i]!=arr[j])
		    	{
		    		next[i]=j;
		    		j=0;
		    	}
		    	if(arr[i]==arr[j])
		    		j++;
		    }
		    return next;
	    }


}
