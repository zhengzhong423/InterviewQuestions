package leetCode;

public class UniqueBinaryTree {

	public static void main(String[] args) {

	}
	public int numTrees(int n) {
        if(n==0)
        	return 0;
        if(n==1)
        	return 1;
        int sum=0;
        for(int i=0; i<n; i++)
        {
        	sum=numTrees(i)+numTrees(n-1-i);
        }
        return sum;
    }

}
