package leetCode;

public class GetReverseString {

	public static void main(String[] args) {
		GetReverseString a=new GetReverseString();
		System.out.println(a.reverseWords("   a   b "));
	}
	public String reverseWords(String s) 
	{
		
        String[] temp=s.split(" ");
        String result="";
        if(temp.length==0)
        	return s;
        for(int i=temp.length-1; i>=0; i--)
        {
        	
        	result+=temp[i].trim();
        	if(temp[i].length()!=0)
        		result+=" ";
        }
        return result.trim();
    }
}
