package leetCode;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRU {
		public
			int count;
			int capacity;
			LinkedHashMap<Integer, Integer> hash=new LinkedHashMap<Integer, Integer>();
		LRU(int capacity)
		{
			this.capacity=capacity;
		}
		public static void main(String[] args) 
		{
			LRU newLRU=new LRU(2);
			newLRU.set(2, 1);
			newLRU.set(1, 1);
			System.out.println(newLRU.get(2));
			newLRU.set(4, 1);
			System.out.println(newLRU.get(1));
			System.out.println(newLRU.get(2));
		}   
	    int get(int key)
	    {
	        if(hash.containsKey(key))
	        {
	        	int temp=hash.remove(key);
	        	hash.put(key, temp);
	        	return hash.get(key);
	        }
	        return -1;
	    }
	    
		void set(int key, int value) 
	    {
			 if(hash.size()<capacity)
		        {
		            hash.put(key, value);
		        }
		        else
		        {
		            Iterator<Integer> iter=hash.keySet().iterator();
		            hash.remove(iter.next());
		            hash.put(key, value);
		        }
	    }
}
