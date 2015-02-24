package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DNASequence {

	public static void main(String[] args) {
		DNASequence s=new DNASequence();
		System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
    static final HashMap<Character, Integer> hash=new HashMap<Character, Integer>();
    static{
        hash.put('A', 0);
        hash.put('C', 1);
        hash.put('G', 2);
        hash.put('T', 3);
    }
    int total=(int)Math.pow(4,9);
    
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> set=new HashSet<Integer>();
        HashSet<String> rs=new HashSet<String>();
        int hashValue=0;
        for(int i=0; i<s.length(); i++)
        {
            if(i>9)
                hashValue=hashValue-hash.get(s.charAt(i-10))*total;
                
            hashValue=hashValue*4+hash.get(s.charAt(i));
            if(i>8)
                if(!set.add(hashValue))
                    rs.add(s.substring(i-9, i+1));
        }
        return new LinkedList<String>(rs);
    }
   

}
