package leetCode;

public class PalidromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome2(1410110141));
	}
	public static boolean isPalindrome2(int x) {
        if(x<0)
            return false;
        int length=getLength(x);
        if(length==1)
            return true;
        while(length>2)
        {
            int left=x/(int)(Math.pow(10.0, length-1.0));
            int right=x%10;
            if(left!=right)
                return false;
            x=x-left*(int)(Math.pow(10.0, length-1.0));
            x=x/10;
            length=length-2;
        }
        if(length==1)
            return true;
        return x%10==x/10;
        
    }
    public static int getLength(int x)
    {
        int i=1;
        int k=10;
        while(x/k>0)
        {
            k=k*10;
            i++;
        }
        return i;
    }
    public static boolean isPalindrome(int x) 
    {
    	long x1=x;
    	if(x==Integer.MIN_VALUE)
    		return false;
        int num=count(x1);
        for(int i=num; i>1; i=i-2)
        {
        	if((int)(x1/Math.pow(10, num-1))!=x1%10)
        		return false;
        	int a=(int)Math.pow(10, num-1);
        	x1=(x1%a-x1%10)/10;
        	num=num-2;
        }
        return true;
    }
	private static int count(long x1) {
		int count=1;
        long temp=x1;
        while(temp>=10)
        {
        	temp=temp/10;
        	count++;
        }
		return count;
	}

}
