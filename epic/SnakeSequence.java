package epic;

import java.util.LinkedList;
import java.util.List;

public class SnakeSequence {

	static List<List<Integer>> rs=new LinkedList<List<Integer>>();
	
	int[][] maze={
			{1,2,6,6,7},
			{-9,1,7,8,7},
			{1,0,1,1,6}
	};
	
	public static void main(String[] args) {
		
		SnakeSequence s=new SnakeSequence();
		s.helper();
		System.out.println(rs);
	}
	
	public void helper()
	{
		
		rs.add(new LinkedList<Integer>());
		for(int i=0; i<maze.length; i++)
			for(int j=0; j<maze[0].length; j++)
			{
				List<Integer> temp=new LinkedList<Integer>();
				temp.add(maze[i][j]);
				dfs(i, j, temp);
			}
	}

	private void dfs(int x, int y, List<Integer> temp) 
	{
		if(x+1<maze.length && Math.abs(maze[x+1][y]-maze[x][y])==1)
		{
			List<Integer> newTemp=new LinkedList<Integer>(temp);
			newTemp.add(maze[x+1][y]);
			dfs(x+1, y, newTemp);
		}
		
		if(y+1<maze[0].length && Math.abs(maze[x][y+1]-maze[x][y])==1)
		{
			List<Integer> newTemp=new LinkedList<Integer>(temp);
			newTemp.add(maze[x][y+1]);
			dfs(x, y+1, newTemp);
		}
		
		if(temp.size()>rs.get(0).size())
		{
			rs.clear();
			rs.add(temp);
		}
		else if(temp.size()==rs.get(0).size())
			rs.add(temp);
	}
}
