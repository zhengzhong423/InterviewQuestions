package cracking;
import java.util.*;
public class RowColumnToZero {

	public static void main(String[] args) 
	{
		RowColumnToZero r=new RowColumnToZero();	
		ArrayList<Integer> row=new ArrayList<Integer>();
		ArrayList<Integer> column=new ArrayList<Integer>();
		int[][] a={{1,2,3,4,5},{2,3,3,4,5,},{5,4,3,2,3},{0,3,4,5,0},{2,3,4,5,6},{4,3,5,6,7}};
		r.findZero(a, row, column);
		
		r.setZero(a,row,column);
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	private void setZero(int[][] a, ArrayList<Integer> row,ArrayList<Integer> column) 
	{
		
		while(column.isEmpty()==false)
		{
			int k=row.size();
			for(int i=0;i<=a.length-1;i++)
			{
				a[i][column.get(k-1)]=0;
			}
			column.remove(k-1);
			for(int j=0;j<=a[0].length-1;j++)
			{
				a[row.get(k-1)][j]=0;
			}
			row.remove(k-1);
		}
	}
	public void findZero(int[][] a, ArrayList<Integer> row, ArrayList<Integer> column)
	{
		for(int i=0;i<=a.length-1;i++)
		{
			for(int j=0;j<=a[0].length-1;j++)
			{
				if(a[i][j]==0)
				{
					row.add(i);
					column.add(j);
				}
			}
		}
	}
}
