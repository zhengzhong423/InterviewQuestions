package bit;

import java.util.BitSet;

public class Bitset {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BitSet bs=new BitSet(32);
		for(int i=1; i<bs.size(); i++)
			bs.set(i);
		if(bs.get(1))
			System.out.println(bs.get(1));
	}

}
