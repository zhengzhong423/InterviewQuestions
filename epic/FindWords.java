package epic;


public class FindWords {

	public static void main(String[] args) {
		char[][] matrix={
				{'a', 'b', 'c', 'd'},
				{'e', 'f', 'g', 'h'},
				{'i', 'j', 'k', 'l'},
				{'m', 'n', 'o', 'p'},
		};
		String word="lpj";
		FindWords f=new FindWords();
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[0].length; j++)
			{	
				if(matrix[i][j]==word.charAt(0))
					System.out.println(f.find(matrix, word, i, j));
			}
	}
	
	public boolean find(char[][] matrix, String word, int curX, int curY)
	{
		int x=curX;
		int y=curY;
		if(y+word.length()-1<matrix[0].length)
		{
			for(int i=0; i<word.length(); i++)
			{
				if(matrix[x][y+i]!=word.charAt(i))
					break;
				if(i==word.length()-1)
					return true;
			}
		}
		
		if(y-word.length()+1>=0)
		{
			for(int i=0; i<word.length(); i++)
			{
				if(matrix[x][y-i]!=word.charAt(i))
					break;
				if(i==word.length()-1)
					return true;
			}
		}
		
		if(x+word.length()-1>matrix.length)
		{
			for(int i=0; i<word.length(); i++)
			{
				if(matrix[x+i][y]!=word.charAt(i))
					break;
				if(i==word.length()-1)
					return true;
			}
		}
		
		if(x-word.length()+1>=0)
		{
			for(int i=0; i<word.length(); i++)
			{
				if(matrix[x-i][y]!=word.charAt(i))
					break;
				if(i==word.length()-1)
					return true;
			}
		}
		
		return false;
		
		
	}

}
