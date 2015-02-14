package lintCode;

public class WoodCut {

	public static void main(String[] args) {
		WoodCut w=new WoodCut();
		System.out.println(w.woodCut(new int[] {232,124,456}, 7));
	}
	public int count(int[] L, int mid)
    {
        int count=0;
        for(int i=0; i<L.length; i++)
            count+=L[i]/mid;
        return count;
    }
    public int woodCut(int[] L, int k) {
        // write your code here
        int max=0;
        int sum=0;
        for(int i=0; i<L.length; i++)
        {
            max=Math.max(max, L[i]);
            sum+=L[i];
        }
        
        if(k>sum)
            return 0;
        int left=1; 
        int right=max;
        while(right>left)
        {
            int mid=(left+right)/2;
            if(count(L, mid)==k && count(L, mid+1)<k)
            	return mid;
            if(count(L, mid)>=k)
                left=mid+1;
            else
                right=mid-1;
        }
        if(right==left && count(L, left)==k)
            return right;
        if(count(L, right)==k)
            return right;
        else
            return left;
    }

}
