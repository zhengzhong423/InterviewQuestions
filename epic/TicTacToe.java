package epic;

public class TicTacToe {
	
	static int[][] matrix={
			{1,0,0,0},
			{1,0,0,0},
			{1,0,0,0},
			{1,1,1,1}
	};
	
	int[][][] record=new int[matrix.length][matrix.length][4];
	
	int[] point=new int[2];
	public static void main(String[] args)
	{
		new TicTacToe().helper(matrix);
	}
	public void helper(int[][] matrix)
	{
			for(int i=0; i<matrix.length; i++)
				for(int j=0; j<matrix.length; j++)
				{
					//horizontally check
					horizon(matrix, i, j, matrix[i][j]);
					vertical(matrix, i, j, matrix[i][j]);
					d1(matrix,i, j, matrix[i][j]);
					d2(matrix, i, j, matrix[i][j]);
				}
			System.out.println("Player1: "+point[0]);
			System.out.println("Player2: "+point[1]);
	}

	private void vertical(int[][] matrix, int i, int j, int k) {	//DFS search
		if(record[i][j][1]!=0)
			return;
		
		int original=i;
		while(i<matrix.length && matrix[i][j]==k)
		{
			record[i][j][1]=1;
			i++;
		}
		
		if(i-original>=4)
			point[k]+=2;
		else if(i-original==3)
			point[k]+=1;
	}

	private void d1(int[][] matrix, int i, int j, int k) {
		if(record[i][j][2]!=0)
			return;
		
		int original=i;
		while(i<matrix.length && j<matrix.length && matrix[i][j]==k)
		{
			record[i][j][2]=1;
			i++;
			j++;
		}
		
		if(i-original>=4)
			point[k]+=2;
		else if(i-original==3)
			point[k]+=1;
	}

	private void d2(int[][] matrix, int i, int j, int k) {
		if(record[i][j][3]!=0)
			return;
		
		int original=j;
		while(i>=0 && j<matrix.length && matrix[i][j]==k)
		{
			record[i][j][3]=1;
			i--;
			j++;
		}
		
		if(j-original>=4)
			point[k]+=2;
		else if(j-original==3)
			point[k]+=1;
	}

	private void horizon(int[][] matrix, int i, int j, int k) {
		if(record[i][j][0]!=0)
			return;
		
		int original=j;
		while(j<matrix.length && matrix[i][j]==k)
		{
			record[i][j][0]=1;
			j++;
		}
		
		if(j-original>=4)
			point[k]+=2;
		else if(j-original==3)
			point[k]+=1;
	}
}
