package epic;

public class MagicSquare {

	
	public static void main(String[] args)
	{
		MagicSquare m=new MagicSquare();
		int matrix[][]=new int[5][5];
		m.helper(matrix, matrix.length);
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
				System.out.printf("%5d",matrix[i][j]);
			System.out.println();
		}
	}
	
	public void helper(int[][] matrix, int N)
	{
		int count=1;
		int curX=0;
		int curY=N/2;
		matrix[curX][curY]=count;
		while(count<N*N)
		{
			
			count++;
			
			int preX=curX;
			int preY=curY;
			
			if(curX==0)
				curX=N-1;
			else
				curX--;
			
			if(curY==N-1)
				curY=0;
			else
				curY++;
			
			if(matrix[curX][curY]==0)
				matrix[curX][curY]=count;
			else
			{
				curX=preX;
				curY=preY;
				while(matrix[curX][curY]!=0)
				{
					if(curX==N-1)
						curX=0;
					else
						curX++;
				}
				matrix[curX][curY]=count;
			}
				
			
		}
	}
}
