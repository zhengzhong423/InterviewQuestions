
public class Rotate90Degree {

	public static void main(String[] args)
	{
		Rotate90Degree s=new Rotate90Degree();
		int[][] matrix={{1,2,3},{2,3,4},{3,4,5}};
	//	System.out.println(matrix[0].length);
		int[][] result=s.rotate90Degree(matrix,matrix.length);
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
	public int[][] rotate90Degree(int matrix[][],int k)
	{
		int[][] temp=new int[k][k];
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<k;j++)
			{
				temp[i][j]=matrix[k-j-1][i];
			}
		}
		return temp;
	}
}
