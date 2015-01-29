package leetCode;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(convert("0123456789", 4));
	}
	public static String convert(String s, int nRows) {
		String result="";
        for(int row=0; row<nRows; row++)
        	for(int k=0; k<= s.length()/(2*nRows-2); k++)
        	{
        		if(row+k*(2*nRows-2)< s.length())
        			result+=s.charAt(row+k*(2*nRows-2));
        		if(row!=0 && row!=nRows-1)
        			if(((2*k+2)*(nRows-1)-row)< s.length())
        				result+=s.charAt((2*k+2)*(nRows-1)-row);
        		
        	}
        return result;
    }

}
