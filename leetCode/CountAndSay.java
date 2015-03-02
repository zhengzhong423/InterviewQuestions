package leetCode;

public class CountAndSay {

	public static void main(String[] args) {
		
		System.out.println(countAndSay2(4));
		System.out.println();
	}
    public static String countAndSay2(int n) {
        if(n==0)
            return "";
        if(n==1)
            return "1";
            
        String str="1";
        String rs="";
        
        for(int j=2; j<=n; j++)
        {
            char buffer=str.charAt(0);
            int count=1;
            
            for(int i=1; i<str.length(); i++)
            {
               if(buffer==str.charAt(i))
                    count++;
                else
                {
                    rs=rs+(String.valueOf(count)+buffer);
                    buffer=str.charAt(i);
                    count=1;
                }
            }
            rs=rs+(String.valueOf(count)+buffer);
            str=rs;
            rs="";
        }
        return str;
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
