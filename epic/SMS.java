package epic;

import java.util.HashMap;

public class SMS {

	static HashMap<Integer, String> hash=new HashMap<>();
	static{
		hash.put(0, "0");
		hash.put(1, "1");
		hash.put(2, "ABC2");
		hash.put(3, "DEF3");
		hash.put(4, "GHI4");
		hash.put(5, "JKL5");
		hash.put(6, "MNO6");
		hash.put(7, "PQRS7");
		hash.put(8, "TUV8");
		hash.put(9, "WXYZ9");
	}
	
	public static void main(String[] args) {
		SMS s=new SMS();
		System.out.println(s.getMessage("66***#####***2#23#3*88#88"));
	}
	public String getMessage(String s)
	{
		String rs="";
		String buffer="";
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='*')
			{
				if(buffer.length()>0)
				{
					int num=Integer.parseInt(buffer.charAt(0)+"");
					char ch=hash.get(num).charAt((buffer.length()-1)%hash.get(num).length());
					buffer="";
					rs+=ch;
				}
				
				rs+=" ";
			}
			else if(s.charAt(i)=='#' && buffer.length()>0)
			{
				int num=Integer.parseInt(buffer.charAt(0)+"");
				char ch=hash.get(num).charAt((buffer.length()-1)%hash.get(num).length());
				buffer="";
				rs+=ch;
			}
			else if(s.charAt(i)>='0' && s.charAt(i)<='9')
			{
				if(buffer.length()==0)
					buffer+=s.charAt(i);
				else
				{
					if(buffer.charAt(0)==s.charAt(i))
						buffer+=s.charAt(i);
					else
					{
						int num=Integer.parseInt(buffer.charAt(0)+"");
						char ch=hash.get(num).charAt((buffer.length()-1)%hash.get(num).length());
						buffer="";
						buffer+=s.charAt(i);
						rs+=ch;
					}
				}
			}
		}
		if(buffer.length()!=0)
		{
			int num=Integer.parseInt(buffer.charAt(0)+"");
			char ch=hash.get(num).charAt((buffer.length()-1)%hash.get(num).length());
			rs+=ch;
		}
		return rs;
	}
	
}
