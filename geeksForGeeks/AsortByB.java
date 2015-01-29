package geeksForGeeks;

import java.util.*;

public class AsortByB {
	static HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
    static class cmp implements Comparator<Integer>
	{
		public int compare(Integer o1, Integer o2) {
			if(hash.containsKey(o1) && !hash.containsKey(o2))
				return -1;
			if(hash.containsKey(o2) && !hash.containsKey(o1))
				return 1;
			if(hash.containsKey(o1) && hash.containsKey(o2))
			{
				return hash.get(o1)-hash.get(o2);
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Integer[] A={3,4,8,5};
		int B[] = {2, 1, 8, 3, 4};
		statics(B);
		Arrays.sort(A, new AsortByB.cmp());
		System.out.println(A);
	}
	public static void statics(int[] B)
	{
		for(int i=0; i<B.length; i++)
		{
			hash.put(B[i], i);
		}
	}

}
