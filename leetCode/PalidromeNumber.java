package leetCode;

public class PalidromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(10101));
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
