package epic;

import java.util.HashSet;

public class Mingo {
	int[][] matrix=new int[10][10];
	HashSet<Integer> hash=new HashSet<Integer>();

	
	public static void main(String[] args) {
		new Mingo().generate();
	}
	public void generate()
	{
		int count=0;
		while(count<100)
		{
			int num=(int) (1+Math.random()*1000);
			int grid=(int)(1*99);
			while(hash.contains(grid))
			{
				grid=(int)(Math.random()*99);
			}
			hash.add(grid);
			matrix[grid/10][grid%10]=num;
			check(grid);
			count++;
		}
	}
	
	public void check(Integer grid)
	{
		int x=grid/10;
		int y=grid%10;
		
		for(int j=0; j<matrix[0].length; j++)
		{
			if(matrix[x][j]==0)
				break;
			if(j==matrix.length-1)
			{
				printout();
				return;
			}
		}
		
		for(int i=0; i<matrix.length; i++)
		{
			if(matrix[i][y]==0)
				break;
			if(i==matrix.length-1)
			{
				printout();
				return;
			}
		}
		
		if(x==y)
			for(int i=0; i<matrix.length; i++)
			{
				if(matrix[i][i]==0)
					break;
				if(i==matrix.length-1)
				{
					printout();
					return;
				}
			}
		
		if(x==matrix.length-1-x)
			for(int i=0; i<matrix.length; i++)
			{
				if(matrix[i][matrix.length-1-i]==0)
					break;
				if(i==matrix.length-1)
				{
					printout();
					return;
				}
			}
		
	}


	private void printout() {
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
}
