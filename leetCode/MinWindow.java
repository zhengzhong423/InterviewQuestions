package leetCode;

import java.util.HashMap;

public class MinWindow {

	public static void main(String[] args) {
		MinWindow mw=new MinWindow();
		System.out.println(mw.minWindow("bdab", "ab"));
	}
public String minWindow(String S, String T) {
        
        HashMap<Character, Integer> info=getInfo(T);
        int minLen=Integer.MAX_VALUE;
        String rs="";
        
        int i=0, j=0;
        while(i<S.length())
        {
            char ch=S.charAt(i++);
            if(info.containsKey(ch))
            {
                info.put(ch, info.get(ch)-1);
                if(checkAllZero(info))
                {
                    rs= minLen<i-j ? rs : S.substring(j, i);
                    minLen=rs.length();
                    while(j<i)
                    {
                        char cha=S.charAt(j++);
                        if(info.containsKey(cha))
                        {
                            info.put(cha, info.get(cha)+1);
                            if(info.get(cha)>0)
                                break;
                        }
                        if(checkAllZero(info))
                        {
                            rs=minLen<i-j ? rs : S.substring(j, i);
                            minLen=rs.length();
                        }
                    }
                }
            }
        }
        
        return rs;
    }
    
    public boolean checkAllZero(HashMap<Character, Integer> stats)
    {
        for(Character ch: stats.keySet())
            if(stats.get(ch)>0)
                return false;
        return true;
    }
    
    public HashMap<Character, Integer> getInfo(String T)
    {
        HashMap<Character, Integer> info=new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++)
        {
           char ch=T.charAt(i);
           info.put(ch, info.containsKey(ch) ? info.get(ch)+1: 1);
        }
        return info;
    }

}
