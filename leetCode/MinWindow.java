package leetCode;

import java.util.HashMap;

public class MinWindow {

	public static void main(String[] args) {
		System.out.println(minWindow("bba", "ab"));
	}
    public static String minWindow(String S, String T) {
        HashMap<Character, Integer> hash=init(T);
        int count=hash.size();
        int minSize=Integer.MAX_VALUE;
        if(T.length()>S.length())
            return "";
        int j=0;
        int start=0;
        for(int i=0; i<S.length(); i++)
        {
            char temp=S.charAt(i);
            if(hash.containsKey(temp))
            {
                hash.put(temp, hash.get(temp)-1);
                if(hash.get(temp)==0)
                    count--;
                if(count==0)
                {
                    for(; j<=i; j++)
                    {
                        if(i-j<minSize)
                        {
                            start=j;
                            minSize=i-j;
                        }
                        char temp2=S.charAt(j);
                        if(hash.containsKey(temp2))
                        {
                            hash.put(temp2, hash.get(temp2)+1);
                            if(hash.get(temp2)==1)
                            {
                            	count++;
                            	j++;
                            	break;
                            }
                        }
                    }
                }
            }
        }
        return minSize==Integer.MAX_VALUE? "" : S.substring(start, start+minSize+1);
    }
    public static HashMap<Character, Integer> init(String T)
    {
        HashMap<Character, Integer> hash=new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++)
            if(hash.containsKey(T.charAt(i)))
                hash.put(T.charAt(i), 1+hash.get(T.charAt(i)));
            else
                hash.put(T.charAt(i), 1);
        return hash;
    }
	public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] opt=new boolean[s1.length()+1][s2.length()+1];
        
        if(s3.length()!=s2.length()+s1.length())
            return false;
        opt[0][0]=true;
        for(int i=1; i<=s1.length(); i++)
            opt[i][0] = opt[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        for(int j=1; j<=s2.length(); j++)
            opt[0][j] = opt[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
        for(int i=1; i<=s1.length(); i++)
            for(int j=1; j<=s2.length(); j++)
            {
                if(s2.charAt(j-1)==s1.charAt(i-1) && s1.charAt(i-1)==s3.charAt(i+j-1))
                {
                    opt[i][j]=opt[i-1][j] || opt[i][j-1];
                    continue;
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1))
                    opt[i][j]=opt[i][j-1];
                if(s1.charAt(i-1)==s3.charAt(i+j-1))
                    opt[i][j]=opt[i-1][j];
            }
        return opt[s1.length()][s2.length()];
    }
	public static String minWindow2(String S, String T) {
		HashMap<Character, Integer> hash=statistics(T);
		int countPos=hash.size();
		int j=0;
		String min="";
		for(int i=0; i<S.length(); i++)
		{
			char temp=S.charAt(i);
			if(hash.containsKey(temp))
			{
				hash.put(temp, hash.get(temp)-1);
				if(hash.get(temp)==0)
					countPos--;
			}
			
			if(countPos==0)
				for(; j<=i; j++)
				{
					char ch=S.charAt(j);
					if(hash.containsKey(ch))
					{
						if(min.length()==0)
							min=S.substring(j, i+1);
						else
							min=min.length()>i-j ? S.substring(j, i+1) : min;
						hash.put(ch, hash.get(ch)+1);
						if(hash.get(ch)==1)
						{
							countPos++;
							j++;
							break;
						}
						
					}
				}
		}
		return min;
    }
	public static HashMap<Character, Integer> statistics(String T)
	{
		HashMap<Character, Integer> hash=new HashMap<Character, Integer>();
		for(int i=0; i<T.length(); i++)
		{
			char temp=T.charAt(i);
			if(hash.containsKey(temp))
				hash.put(temp,  1+hash.get(temp));
			else
				hash.put(temp, 1);
		}
		return hash;
	}

}
