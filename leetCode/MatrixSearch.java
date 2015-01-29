package leetCode;

public class MatrixSearch {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MatrixSearch m=new MatrixSearch();
		int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		m.searchMatrix(matrix, 5);
	}
	public boolean searchMatrix(int[][] matrix, int target) {
	 return helper(0, matrix.length-1, 0, matrix[0].length-1, matrix, target);
	}
		public boolean helper(int xLow, int xHigh, int yLow, int yHigh, int[][] matrix, int target)
		{
		    if(xLow>xHigh || yLow>yHigh)
		        return false;
		    int xMid=(xLow+xHigh)/2;
		    int yMid=(yLow+yHigh)/2;
		    if(target==matrix[xMid][yMid])
		        return true;
		    if(target<matrix[xMid][yMid])
		        return helper(xLow, xMid-1, yLow, yHigh, matrix, target) || helper(xMid, xMid, yLow, yMid-1, matrix, target);
		    return helper(xMid, xMid, yMid+1, yHigh, matrix, target) || helper(xMid+1, xHigh, yLow, yHigh, matrix, target);
		}

}
