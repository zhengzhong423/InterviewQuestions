package interesting;

import java.util.HashSet;

public class EightPuzzle {

	class Grid
	{
		int[][] grid=new int[3][3];
		public Grid(int[][] a)
		{
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					this.grid[i][j]=a[i][j];
		}
	}
	
	
	public static void main(String[] args) 
	{
		EightPuzzle p=new EightPuzzle();
		Grid g=p.new Grid(new int[][] {{1,2,3},{4,5,6},{8,0,7}});
		int zeroX=0;
		int zeroY=0;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(g.grid[i][j]==0)
				{
					zeroX=i;
					zeroY=j;
				}
		
			
		while(true)
		{
			int sum1=Integer.MAX_VALUE;
			int sum2=Integer.MAX_VALUE;
			int sum3=Integer.MAX_VALUE;
			int sum4=Integer.MAX_VALUE;
			
			HashSet<int[][]> hash=new HashSet<>();
			if(p.Manhattan(g.grid)==0)
			{
				System.out.println("Success");
				break;
			}
			if(zeroX+1<3)
			{
				p.swap(g.grid, zeroX+1, zeroY, zeroX, zeroY);
				if(!hash.contains(g.grid))
					sum1=p.Manhattan(g.grid);
				p.swap(g.grid, zeroX+1, zeroY, zeroX, zeroY);
			}
			if(zeroX-1>=0)
			{
				p.swap(g.grid, zeroX-1, zeroY, zeroX, zeroY);
				if(!hash.contains(g.grid))
					sum2=p.Manhattan(g.grid);
				p.swap(g.grid, zeroX-1, zeroY, zeroX, zeroY);
			}
			if(zeroY+1<3)
			{
				p.swap(g.grid, zeroX, zeroY+1, zeroX, zeroY);
				if(!hash.contains(g.grid))
					sum3=p.Manhattan(g.grid);
				p.swap(g.grid, zeroX, zeroY+1, zeroX, zeroY);
			}
			if(zeroY-1>=0)
			{
				p.swap(g.grid, zeroX, zeroY-1, zeroX, zeroY);
				if(!hash.contains(g.grid))
					sum4=p.Manhattan(g.grid);
				p.swap(g.grid, zeroX, zeroY-1, zeroX, zeroY);
			}
			
			if(sum1<=sum2 && sum1<=sum3 && sum1<=sum4 && sum1!=Integer.MAX_VALUE)
			{
				p.swap(g.grid, zeroX+1, zeroY, zeroX, zeroY);
				hash.add(g.grid);
				zeroX++;
			}
			else if(sum2<=sum1 && sum2<=sum3 && sum2<=sum4 && sum2!=Integer.MAX_VALUE)
			{
				p.swap(g.grid, zeroX-1, zeroY, zeroX, zeroY);
				hash.add(g.grid);
				zeroX--;
			}
			else if(sum3<=sum1 && sum3<=sum2 && sum3<=sum4 && sum3!=Integer.MAX_VALUE)
			{
				p.swap(g.grid, zeroX, zeroY+1, zeroX, zeroY);
				hash.add(g.grid);
				zeroY++;
			}
			else if(sum4<=sum1 && sum4<=sum2 && sum4<=sum3 && sum4!=Integer.MAX_VALUE)
			{
				p.swap(g.grid, zeroX, zeroY-1, zeroX, zeroY);
				hash.add(g.grid);
				zeroY--;
			}
		}
	}
	
	public void swap(int[][] a, int x, int y, int x0, int y0)
	{
		int temp=a[x][y];
		a[x][y]=a[x0][y0];
		a[x0][y0]=temp;
	}
	
	
	public int Manhattan(int[][] a)
	{
		int sum=0;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
			{
				if(a[i][j]==1)
					sum=sum+i+j;
				if(a[i][j]==2)
					sum=sum+Math.abs(j-1)+i;
				if(a[i][j]==3)
					sum=sum+Math.abs(j-2)+i;
				if(a[i][j]==4)
					sum=sum+j+Math.abs(i-1);
				if(a[i][j]==5)
					sum=sum+Math.abs(j-1)+Math.abs(i-1);
				if(a[i][j]==6)
					sum=sum+Math.abs(j-2)+Math.abs(i-1);
				if(a[i][j]==7)
					sum=sum+Math.abs(j)+Math.abs(i-2);
				if(a[i][j]==8)
					sum=sum+Math.abs(j-1)+Math.abs(i-2);
				if(a[i][j]==0)
					sum=sum+Math.abs(j-2)+Math.abs(i-2);
			}
		return sum;
	}

}
