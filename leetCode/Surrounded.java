package leetCode;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Surrounded {

	public static void main(String[] args)
	{
		char[][] board=new char[4][4];
		 for(int i=0; i<4; i++)
	        	for(int j=0; j<4; j++)
	        			board[i][j]='X';
		 board[2][2]=board[1][2]='O';
		 solve(board);
	}
	public static void solve(char[][] board)
	{
		int w =board.length;
        int h =board[0].length;
        int[][] visited=new int[w][h];
        Queue<Point> q=new LinkedList<Point>();
        for(int i=0; i<w; i++)
        {
        	if(board[i][0]=='O')
        	{
        		visited[i][0]=1;
        		q.add(new Point(i,0));
        		Search(q,board, visited);
        	}
        }	
        for(int i=0; i<w; i++)
        {
        	if(board[i][h-1]=='O')
        	{
        		visited[i][h-1]=1;
        		q.add(new Point(i,h-1));
        		Search(q,board, visited);
        	}
        }
        for(int j=0; j<h; j++)
        {
        	if(board[0][j]=='O')
        	{
        		visited[0][j]=1;
        		q.add(new Point(0,j));
        		Search(q,board, visited);
        	}
        }
        for(int j=0; j<h; j++)
        {
        	if(board[w-1][j]=='O')
        	{
        		visited[w-1][j]=1;
        		q.add(new Point(w-1,j));
        		Search(q,board, visited);
        	}
        }
        for(int i=0; i<w; i++)
        	for(int j=0; j<h; j++)
        		if(visited[i][j]==1)
        			board[i][j]='O';
        		else
        			board[i][j]='X';
        return ;
     }
	private static void Search(Queue<Point> q, char[][] board, int[][] visited) {
		int w =board.length-1;
        int h =board[0].length-1;
		while(!q.isEmpty())
		{
			Point temp=q.remove();
			if(temp.x>0)
				if(board[temp.x-1][temp.y]=='O' && visited[temp.x-1][temp.y]!=1)
				{	
					q.add(new Point(temp.x-1, temp.y));
					visited[temp.x-1][temp.y]=1;
				}
			if(temp.x<w )
				if(board[temp.x+1][temp.y]=='O' && visited[temp.x+1][temp.y]!=1)
				{	
					q.add(new Point(temp.x+1, temp.y));
					visited[temp.x+1][temp.y]=1;
				}
			if(temp.y>0)
				if(board[temp.x][temp.y-1]=='O' && visited[temp.x][temp.y-1]!=1)
				{	
					q.add(new Point(temp.x, temp.y-1));
					visited[temp.x][temp.y-1]=1;
				}
			if(temp.y<h )
				if(board[temp.x][temp.y+1]=='O' && visited[temp.x][temp.y+1]!=1)
				{	
					q.add(new Point(temp.x, temp.y+1));
					visited[temp.x][temp.y+1]=1;
				}
		}
		
	}
}
