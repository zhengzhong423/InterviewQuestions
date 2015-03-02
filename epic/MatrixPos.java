package epic;

public class MatrixPos {

	public static void main(String[] args) {
		int[][] matrix={
				{5,6,9},
				{1,4,2},
				{1,8,3},
		};
		MatrixPos m=new MatrixPos();
		int[] r=m.maxRows(matrix);
		int[] c=m.minCols(matrix);
		int[] p=m.getPoint(r, c);
		System.out.println(p[0]+" "+p[1]);
	}
	public int[] maxRows(int matrix[][])
	{
		int[] rows=new int[matrix.length];
		for(int i=0; i<matrix.length; i++)
		{
			int max=Integer.MIN_VALUE;
			int index=-1;
			for(int j=0; j<matrix[0].length; j++)
			{
				if(max<matrix[i][j])
				{
					max=Math.max(matrix[i][j], max);
					index=j;
				}
			}
			rows[i]=index;
		}
		return rows;
	}
	
	public int[] minCols(int matrix[][])
	{
		int[] col=new int[matrix[0].length];
		for(int j=0; j<matrix[0].length; j++)
		{
			int min=Integer.MAX_VALUE;
			int index=-1;
			for(int i=0; i<matrix.length; i++)
			{
				if(min>matrix[i][j])
				{
					min=Math.min(min, matrix[i][j]);
					index=i;
				}
			}
			col[j]=index;
		}
		return col;
	}
	
	public int[] getPoint(int[] rows, int[] cols)
	{
		for(int i=0; i<rows.length; i++)
			if(cols[rows[i]]==i)
				return new int[] {i, rows[i]};
		return new int[] {-1, -1};
	}

}
