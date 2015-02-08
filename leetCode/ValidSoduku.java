package leetCode;

public class ValidSoduku {
		public static void main(String[] args)
		{
			ValidSoduku vs=new ValidSoduku();
			String[] strs={"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
			char[][] board=new char[9][9];
			for(int i=0; i<strs.length; i++)
				for(int j=0; j<strs[0].length(); j++)
					board[i][j]=strs[i].charAt(j);
			vs.solveSudoku(board);
		}
		public void solveSudoku(char[][] board) {
	       solveSudoku2(board, 0);
	    }
	    public Boolean solveSudoku2(char[][] board, int index)
	    {
	        if(index==81)
	            return true;
	        int i=index/9;
	        int j=index%9;
	        if(board[i][j]=='.')
	        {
	            for(int k=1; k<=9; k++)
	            {
	                if(checkValid(board, i, j, k))
	                {
	                        board[i][j]=(char)('0'+k);
	                        if(solveSudoku2(board,index+1))
	                        	return true;
	                        board[i][j]='.';
	                }
	            }
	        }
	        else
	            return solveSudoku2(board, index+1);
			return false;
	            
	    }
	    public boolean checkValid(char[][] board, int x, int y, int num)
	    {
	        if(board[x][y]!='.')
	            return false;
	        for(int i=0; i<board.length; i++)
	            if(board[i][y]==(char)(num+'0'))
	                return false;
	        for(int j=0; j<board[0].length; j++)
	            if(board[x][j]==(char)(num+'0'))
	                return false;
	        int row=x/3;
	        int col=y/3;
	        for(int i=row*3; i<row*3+3; i++)
	            for(int j=col*3; j<col*3+3; j++)
	                if(board[i][j]==(char)(num+'0'))
	                    return false;
	        return true;
	    }
	

}
