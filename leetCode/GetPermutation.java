package leetCode;

import java.util.ArrayList;

public class GetPermutation {

	public static void main(String[] args) {
		System.out.println(getPermutation(1, 1));

	}
	public static String getPermutation(int n, int k) {
        ArrayList <Integer> al=new ArrayList<>();
        for(int i=1; i<=n; i++)
            al.add(i);
            
        StringBuffer sb=new StringBuffer();
        for(int i=1; i<=n; i++)
        {
            int base=factorial(n-1);
            int digit=1+(k-1)/base;
            int num=al.get(digit-1);
            al.remove(digit-1);
            sb.insert(0, Integer.toString(num));
            n--;
            k=1+(k-1)%base;
        }
        return sb.toString();
    }
    public static int factorial(int n)
    {
        if(n==1)
            return 1;
        return n*factorial(n-1);
    }
}
