package leetCode;

public class DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings2("100"));
	}
	public static int numDecodings2(String s) {
		 if(s.length()==0)
	            return 0;
	         if(s.charAt(0)=='0')
	                return 0;
	        if(s.length()==1)
	                return 1;
	        int[] opt=new int[s.length()+1];
	        opt[0]=1;
	        opt[1]=1;
	        for(int i=1; i<s.length(); i++)
	        {
	           int num=Integer.parseInt(String.valueOf(s.charAt(i-1))+String.valueOf(s.charAt(i)));
	           if(num==0 && num>26)
	                return 0;
	           if(num==10 || num==20)
	                opt[i+1]=opt[i-1];
	           else
	           {
	                if(num>=1 && num<=26 && s.charAt(i-1)!='0')
	                    opt[i+1]=opt[i]+opt[i-1];
	                else
	                    opt[i+1]=opt[i];
	            }
	        }
	        return opt[s.length()];
    }
	static int numDecodings(String s) {
		 int[] result=new int[s.length()+1];
	        if(s.length()==0)
	        	return 0;
	        result[0]=1;
	        if(s.charAt(0)=='0')
	            result[1]=0;
	        else
	            result[1]=1;
	        for(int i=2; i<=s.length(); i++)
	        {
	        	if(s.charAt(i-1)=='0')
	        		continue;
	        	int num=(Integer.valueOf(s.charAt(i-2))-48)*10+(Integer.valueOf(s.charAt(i-1))-48);
	        	if(num<27)
	        	{
	        	    if(s.charAt(i-1)!='0')
	        		    result[i]=result[i-1]+result[i-2];
	        	}
	        	else
	        		result[i]=result[i-1];
	        }
	        if(s.charAt(s.length()-1)=='0')
	        {
	        	int num=(Integer.valueOf(s.charAt(s.length()-2))-48)*10+(Integer.valueOf(s.charAt(s.length()-1))-48);
	        	if(num<27)
	        		return 1+result[s.length()-1];
	        }
	        return result[s.length()];
    }
}
