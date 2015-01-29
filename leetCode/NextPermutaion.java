package leetCode;

import java.util.Arrays;

public class NextPermutaion {

	public static void main(String[] args) {
		int[] a=new int[] {1,2};
		nextPermutation(a);
		System.out.println(a);
	}
	public static void nextPermutation(int[] num) {
        //find first dis-order number backward
        int index=0;
        for(int i=num.length-1; i>=0; i--)
        {
            if(i==0)
            {
                Arrays.sort(num);
                return;
             }
            if(num[i]>num[i-1])
            {
                index=i-1;
                break;
            }
        }
        int temp=num[index];
        for(int i=num.length-1; i>=0; i--)
            if(num[i]>temp)
            {
                num[index]=num[i];
                num[i]=temp;
                break;
            }
        Arrays.sort(num, index+1, num.length);
    }

}
