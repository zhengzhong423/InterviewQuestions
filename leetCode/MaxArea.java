package leetCode;


public class MaxArea {

	public static void main(String[] args)
	{
		
	}
	public int maxArea(int[] height) {
		int max=0;
		int i=0;
		int j=height.length-1;
		while(i!=j)
		{
        		max=Math.max((j-i)*Math.min(height[i], height[j]), max);
        		if(height[i]<height[j])
        			i++;
        		else
        			j--;
        		
		}
		return max;
    }
}
