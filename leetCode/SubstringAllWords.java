package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringAllWords {

	public static void main(String[] args) {
		SubstringAllWords saw=new SubstringAllWords();
		String S="aboofooowingdingbarrwingmonkeypoundcake";
		String[] L={"fooo","barr","wing","ding","wing"};
		System.out.println(saw.findSubstring(S, L));
		
	}
public List<Integer> findSubstring(String S, String[] L) {
        
        List<Integer> rs=new LinkedList<Integer>();
        
        int len=L.length*L[0].length();
        
        for(int index=0; index<L[0].length(); index++)
        {   
                HashMap<String, Integer> hash=getInfo(L);
                for(int i=index; i<=S.length(); i=i+L[0].length())
                {
                    if(i<index+len)
                    {
                        String key=S.substring(i, i+L[0].length());
                        if(hash.containsKey(key))
                        {
                            hash.put(key, hash.get(key)-1);
                            if(isSol(hash))
                                rs.add(index);
                        }
                    }
                    else if(i+L[0].length()<=S.length())
                    {
                        String lost=S.substring(i-len, i-len+L[0].length());
                        String got=S.substring(i, i+L[0].length());
                        if(hash.containsKey(lost))
                            hash.put(lost, hash.get(lost)+1);
                        if(hash.containsKey(got))
                            hash.put(got, hash.get(got)-1);
                        if(isSol(hash))
                            rs.add(i-len+L[0].length());
                    }
                }
        }
        return rs;
    }
    
    public HashMap<String, Integer> getInfo(String[] L)
    {
        HashMap<String, Integer> hash=new HashMap<String, Integer>();
        for(String str: L)
        {
            if(!hash.containsKey(str))
                hash.put(str, 1);
            else
                hash.put(str, hash.get(str)+1);
        }
        return hash;
    }
    
    public boolean isSol(HashMap<String, Integer> hash)
    {
        for(String str: hash.keySet())
            if(hash.get(str)!=0)
                return false;
        return true;
    }

}
