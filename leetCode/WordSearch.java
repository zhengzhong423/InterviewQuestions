package leetCode;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch w=new WordSearch();
		char[][] board=new char[2][2];
		board[0][0]='a';
		board[0][1]='b';
		board[1][0]='c';
		board[1][1]='d';
		w.exist(board,"dbac");

	}
	public boolean exist(char[][] board, String word) {
        boolean result=false;
        for(int i=0; i<board.length; i++)
        for(int j=0; j<board[0].length; j++)
            if(board[i][j]==word.charAt(0))
            {
            	int[][] visited= new int[board.length][board[0].length];
                result=result || helper(i,j,0, word, board, visited);
            }
        return result;
    }
	public boolean helper(int x, int y, int index, String word, char[][] board, int[][] visited)
	{
		if(index==word.length())
			return true;
		if(x<0 || x>=board.length || y<0 || y>=board[0].length)
			return false;
		if(visited[x][y]==1)
			return false;
		if(word.charAt(index)!=board[x][y])
			return false;
		visited[x][y]=1;
		boolean result=helper(x-1, y, index+1, word, board, visited) || helper(x+1, y, index+1, word, board, visited) || helper(x, y-1, index+1, word, board, visited) || helper(x, y+1, index+1, word, board, visited);
		visited[x][y]=0;
		return result;
	}

}
