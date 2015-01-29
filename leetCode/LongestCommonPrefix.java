package leetCode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	 public String longestCommonPrefix(String[] strs) 
	 {
		 String min=findMinLen(strs);
		 int common=0;
	     for(String s: strs)
	     {
	    	 int i=0;
	    	 while(s.charAt(i)==min.charAt(i))
	    		 i++;
	    	 common=Math.min(common, i);
	     }
	     if(common==0)
	    	 return "";
	     return min.substring(0, common);
	 }
	 public String findMinLen(String[] strs)
	 {
		 String min=strs[0];
		 for(String s: strs)
			 min=(s.length()<min.length())? s: min;
		 return min;
	 }
}
