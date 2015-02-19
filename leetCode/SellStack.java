package leetCode;

public class SellStack {

	 int max=0;
	 int maxTrans=0;
	    
	public static void main(String[] args) {
		SellStack s=new SellStack();
		System.out.println(s.maxProfit(3, new int[] {1,3,2,1,3,2,1}));
	}
	    
	    public int maxProfit(int k, int[] prices) {
	        maxTrans=k;
	            helper(0, prices, 0, 0);
	        return max;
	    }
	    
	    public void helper(int trans, int[] prices, int start, int sum)
	    {
	       if(trans==maxTrans)
	          return;
	       for(int j=start; j<prices.length; j++)
		       for(int i=j+1; i<prices.length; i++)
		       {
		           if(prices[i]-prices[j]>0)
		           {
		                max=Math.max(max, sum+prices[i]-prices[j]);
		                helper(trans+1, prices, i, sum+prices[i]-prices[j]);     
		           }
		       }
	    }

}
