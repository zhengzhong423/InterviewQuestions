package epic;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Snake {

	public static void main(String[] args) {
		Snake s=new Snake();
		int[][] maze={
				{1,3,2,6,8},
				{-9,7,1,-1,2},
				{1,5,0,1,9}
		};
		System.out.println(s.helper(maze));
	}
	public List<Integer> helper(int[][] maze)
	{
		int m=maze.length; 
		int n=maze[0].length;
		int[][] opt=new int[m][n];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
			{
				if(j!=0)
				{
					if(Math.abs(maze[i][j]-maze[i][j-1])==1)
						opt[i][j]=Math.max(opt[i][j], opt[i][j-1]+1);
				}
				if(i!=0)
				{
					if(Math.abs(maze[i][j]-maze[i-1][j])==1)
						opt[i][j]=Math.max(opt[i][j], opt[i-1][j]+1);
				}
			}
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				System.out.print(opt[i][j]+" ");
		List<Integer> rs=findPath(opt, maze);
		return rs;
		
	}
	private List<Integer> findPath(int[][] opt, int[][] maze) {
		int maxX=0;
		int maxY=0;
		int max=-1;
		for(int i=0; i<opt.length; i++)
			for(int j=0; j<opt[0].length; j++)
			{
				if(max<opt[i][j])
				{
					maxX=i;
					maxY=j;
					max=opt[i][j];
				}
			}
		
		Stack<Integer> rs=new Stack<Integer>();
		rs.push(maze[maxX][maxY]);
		while((maxX>=0 && maxY>=0) && opt[maxX][maxY]!=0)
		{
			if(maxX-1>=0)
				if((Math.abs(maze[maxX-1][maxY]-maze[maxX][maxY])==1) && opt[maxX][maxY]-1==opt[maxX-1][maxY])
				{
						maxX--;
						rs.push(maze[maxX][maxY]);
				}
			
			if(maxY-1>=0)
				if((Math.abs(maze[maxX][maxY-1]-maze[maxX][maxY])==1) && opt[maxX][maxY]-1==opt[maxX][maxY-1])
				{
						maxY--;
						rs.push(maze[maxX][maxY]);
				}
		}
		
		List<Integer> l=new LinkedList<Integer>();
		while(!rs.isEmpty())
			l.add(rs.pop());
		return l;
	}

}
