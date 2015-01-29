package hackerank;

public class LCD {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(GCD(1016, 46511));
	}
	 public static boolean GCD(int a, int b)
	    {
	        int larger=Math.max(a,b);
	        int smaller=Math.min(a,b);
	        while(smaller!=0 && larger%smaller!=0)
	        {
	            int temp=larger;
	            larger=smaller;
	            smaller=temp%smaller;
	        }
	        if(smaller>1)
	            return false;
	        return true;
	    }

}
