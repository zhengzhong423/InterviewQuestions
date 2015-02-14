package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RollingHash {

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
	public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<String>();
        HashSet<String> rs=new HashSet<String>();
        for(int i=0; i<s.length(); i++)
        {
            if(i>8)
                if(!set.add(s.substring(i-9, i+1)))
                    rs.add(s.substring(i-9, i+1));
        }
        return new LinkedList<String>(rs);
    }

}
