package leetCode;

public class SellStock1 {

	public static void main(String[] args) 
	{

	}
	public static int maxProfit(int[] prices) 
	{
        if(prices.length<2)
        	return 0;
        int maxProfit=0;
        int locMin=prices[0];
        for(int i=0; i<prices.length; i++)
        {
        	maxProfit=Math.min(maxProfit, prices[i]-locMin);
        	locMin=Math.min(locMin, prices[i]);
        }
        return maxProfit;
    }

}
