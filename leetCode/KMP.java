package leetCode;

public class KMP {

	public static void main(String[] args) {
		System.out.println(strStr("abbabbbbcab","bbcab"));
	}
	public static int strStr(String haystack, String needle) {
		int[] next=makeNext("abac".toCharArray());
		int j=0;
		for(int i=0; i<haystack.length(); i++)
		{
			if(j>0 && haystack.charAt(i)!=needle.charAt(j))
				j=next[j];
			if(haystack.charAt(i)==needle.charAt(j))
				j++;
			if(j==needle.length())
				return 1+i-j;
		}
		return -1;
		
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
