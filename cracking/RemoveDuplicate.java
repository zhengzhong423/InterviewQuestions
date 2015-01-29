import java.util.Hashtable;


public class RemoveDuplicate {

	public static void main(String[] args) 
	{	
		RemoveDuplicate r=new RemoveDuplicate();
		System.out.println(r.removeDuplicate("aabbccddsdffiuhuuwuewriuwuerjkj"));
	}
	public String removeDuplicate(String s)
	{
		Hashtable<Integer,String> hash=new Hashtable<Integer,String>();
		String result="";
		int num=1;
		for(int i=0;i<=s.length()-1;i++)
		{
			String temp2="";
			if(hash.contains(temp2+s.charAt(i)))
			{}
			else
			{
				String temp="";
				temp+=s.charAt(i);
				hash.put(num++,temp);
				result+=s.charAt(i);
			}
		}
		return result;
	}

}
