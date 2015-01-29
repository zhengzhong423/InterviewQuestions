package leetCode;

public class PermutationSequence {

	public static void main(String[] args) {
		
		PermutationSequence s=new PermutationSequence();
		System.out.println(s.getPermutation(4,4));
	}
    public String getPermutation(int n, int k) 
    {
        int[] visited=new int[n];
		return helper(n, k-1,visited);
    }
    public String helper(int n, long l, int[] visited)
    {
        if(n==1)
        {
            if(l==0)
                return findNthNum(visited, 0);
            if(l==1)  
            	return findNthNum(visited, 1);
        }
        long ans=l/fractional(n-1);
        return findNthNum(visited, ans)+helper(n-1, l-fractional(n-1)*ans, visited);
        	
    }
    public long fractional(int k)
    {
    	if(k==1)
    		return 1;
    	return fractional(k-1)*k;
    }
    public String findNthNum(int[] visited, long num)
    {
        for(int i=0; i<visited.length; i++)
        {
            if(visited[i]==0)
            {
            	if(num==0)
            	{
	                visited[i]=1;
	                return Integer.toString(i+1);
            	}
            	else
            		num--;
            }
        }  
        return "";
    }

}
