package leetCode;

public class JumpGame2 {

	public static void main(String[] args) {
		System.out.println(jump(new int[] {1,2,3}));

	}
    public static int jump(int[] A) {
        int range=0+A[0];
        if(A.length==1)
        	return 0;
        if(range>=A.length-1)
        	return 1;
        int newRange=0;
        int index=0;
        int count=0;
        
        while(true)
        {
        	for(int i=index+1; i<=range; i++)
             {
                 newRange=Math.max(i+A[i], newRange);
             }
             count++;
             index=range;
             range=newRange;
             if(newRange>=A.length-1)
                 break;
        }
        return count+1;
     }
}
