package leetCode;

public class StackMax2 {

	public static void main(String[] args) {
		int[] prices={3,4,2,100};
		System.out.println(maxProfit2(prices));
	}
	public static int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int[] OPT=new int[prices.length];
        OPT[0]=0;
        for(int i=1; i<prices.length; i++)
        	for(int j=0; j<=i; j++)
        	{
        		OPT[i]=Math.max(OPT[j], OPT[j]+prices[i]-prices[j]);
        	}
        return OPT[prices.length-1];
    }
	public static int maxProfit2(int[] prices) 
	{
		if(prices.length<2)
            return 0;
		 int max=0;
		 for(int i=1; i<prices.length; i++)
			 if(prices[i]>prices[i-1])
				 max+=prices[i]-prices[i-1];
		 return max;
	}
	public static int maxProfit3(int[] prices)
	{
		if(prices.length<2)
			return 0;
		int[] a=new int[prices.length];
		int[] b=new int[prices.length];
		int locMin=prices[0];
		a[0]=locMin;
		int locMax=prices[prices.length-1];
		b[prices.length-1]=locMax;
		int max=0;
		int max2=0;
 		for(int i=1; i<prices.length; i++)
 		{
 			max=Math.max(max, prices[i]-locMin);
 			locMin=Math.min(locMin, prices[i]);
 			a[i]=max;
 		}
 		for(int i=prices.length-1; i>=0; i--)
 		{
 			max2=Math.max(max2, locMax-prices[i]);
 			locMax=Math.max(locMax, prices[i]);
 			b[i]=max2;
 		}
 		int maxProfit=0;
 		for(int i=0; i<prices.length; i++)
 			maxProfit=Math.max(maxProfit, a[i]+b[i]);
 		return maxProfit;
 		
	}

}
