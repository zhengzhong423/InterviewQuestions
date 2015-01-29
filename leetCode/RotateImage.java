package leetCode;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		rotate(new int[][] {{1,2},{3,4}});
		int[][] k=new int[2][2];
		for(int i=0; i<2; i++)
			Arrays.fill(k[i], 0);
	}
	  public static void rotate(int[][] matrix) {
	        int temp=0;
	        int swap=0;
	        for(int i=0; i<(1+matrix.length)/2; i++)
	        {
	            for(int top=i; top<matrix.length-i-1; top++)
	            {
	                //left element
	                temp=matrix[top][matrix.length-i-1];
	                matrix[top][matrix.length-i-1]=matrix[i][top];
	                //bottom element
	                swap=matrix[matrix.length-i-1][matrix.length-top-1];
	                matrix[matrix.length-i-1][matrix.length-top-1]=temp;
	                temp=swap;
	                //right element
	                swap=matrix[matrix.length-top-1][i];
	                matrix[matrix.length-top-1][i]=temp;
	                temp=swap;
	                //top element
	                matrix[i][top]=temp;
	            }
	        }
	        return;
	        
	    }

}
