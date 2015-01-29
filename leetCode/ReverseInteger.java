package leetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		

	}
	public int reverse(int x) {
		int neg=0;
		long sum=0;
		if(x<0) 
		{
			neg=1;
			x=-x;
		}
        while(x>=10)
        {
        	int i=x%10;
        	x/=10;
        	sum=sum*10+i;
        }
        sum=sum*10+x;
        if(sum>Integer.MAX_VALUE  && sum<Integer.MIN_VALUE) 
        	return 0;
        if(neg==1) 
        	return (int)(0-sum);
        return (int)sum;
    }

}
