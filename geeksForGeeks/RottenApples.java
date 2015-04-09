package geeksForGeeks;

import java.awt.Point;

import java.util.LinkedList;
import java.util.Queue;

class RottenApples
{
	public static void main (String[] args) throws java.lang.Exception
	{
		RottenApples ide=new RottenApples();
		int[][] matrix={{2,1,0,2,1},{1,0,1,2,1},{1,0,0,2,1}};
		System.out.println(ide.helper(matrix));
	}
	
	public int helper(int[][] matrix)
	{
		Queue<Point> change=new LinkedList<Point>();
		
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[0].length; j++)
				if(matrix[i][j]==2)
					change.add(new Point(i, j));
		
		int steps=0;
		
		while(!change.isEmpty())
		{
			Queue<Point> temp=new LinkedList<Point>();
			while(!change.isEmpty())
			{
				Point p=change.poll();
				if(p.x+1<matrix.length && matrix[p.x+1][p.y]==1)
				{
					matrix[p.x+1][p.y]=2;
					temp.add(new Point(p.x+1,p.y));
				}
				if(p.x-1>=0 && matrix[p.x-1][p.y]==1)
				{
					matrix[p.x-1][p.y]=2;
					temp.add(new Point(p.x-1,p.y));
				}
				if(p.y+1<matrix[0].length && matrix[p.x][p.y+1]==1)
				{
					matrix[p.x][p.y+1]=2;
					temp.add(new Point(p.x, p.y+1));
				}
				if(p.y-1>=0 && matrix[p.x][p.y-1]==1)
				{
					matrix[p.x][p.y-1]=2;
					temp.add(new Point(p.x, p.y-1));
				}
			}
			change.addAll(temp);
			steps++;
		}
		return steps;
	}
}
