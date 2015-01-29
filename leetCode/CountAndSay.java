package leetCode;

public class CountAndSay {

	public static void main(String[] args) {
		
		System.out.println(countAndSay(5));
		System.out.println();
	}
	   public static String countAndSay(int n) {
	        String s="1";
	        String temp="";
	        if(n==1)
	            return s;
	        for(int i=2; i<=n; i++)
	        {
	        	temp="";
	            int count=1;
	            for(int j=1; j<s.length(); j++)
	            {
	                if(j>0 && s.charAt(j-1)==s.charAt(j))
	                {
	                    count++;
	                    continue;
	                }
	                if(j>0 && s.charAt(j-1)!=s.charAt(j))
	                {
	                    temp=temp+Integer.toString(count)+s.charAt(j-1);
	                    count=1;
	                }
	            }
	            temp=temp+Integer.toString(count)+s.charAt(s.length()-1);
	            s=new String(temp);
	        }
	        return s;
	    }

}
