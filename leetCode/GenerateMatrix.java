package leetCode;

public class GenerateMatrix {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(generateMatrix(3));
	}
    public static int[][] generateMatrix(int n) {
        int upperBound=0;
        int lowerBound=n-1;
        int leftBound=0;
        int rightBound=n-1;
        int[][] result=new int[n][n];
        if(n==0)
            return result;
        int num=1;
        
        while(num<=n*n)
        {
            for(int i=leftBound; i<=rightBound; i++)
            {
                result[upperBound][i]=num;
                num++;
            }
            upperBound++;
            for(int i=upperBound; i<=lowerBound; i++)
            {
                result[i][rightBound]=num;
                num++;
            }
            rightBound--;
            for(int i=rightBound; i>=leftBound; i--)
            {
                result[lowerBound][i]=num;
                num++;
            }
            lowerBound--;
            for(int i=lowerBound; i>=upperBound; i--)
            {
                result[i][lowerBound]=num;
                num++;
            }
            leftBound++;
        }
        return result;
    }
}
