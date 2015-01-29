package hackerank;

import java.util.*;


public class NumDiff {
    int numQuick;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int[] ar=new int[num];
        for(int i=0; i<num; i++)
            ar[i]=in.nextInt();
        NumDiff s=new NumDiff();
        int numI=s.numInsertion(ar);
        
        s.quickSort(ar);
        int k=numI-s.numQuick;
        System.out.println(k);
        in.close();
    }
    public int numInsertion(int[] ar)
     {
        int result=0;
        for(int i=0; i<ar.length; i++)
            for(int j=i; j>=0; j--)
                if(ar[i]<ar[j])
                    result++;
        return result;
    } 
    public void quickSort(int[] ar) {
                  helper(ar, 0, ar.length-1);
                }
          public void helper(int[] ar, int low, int high)
          {
              if(low<high)
              {
                  int mid=getMid(ar, low, high);
                  helper(ar, low, mid-1);
                  helper(ar, mid+1, high);
                  
              }
              return;
          }
            public int getMid(int[] ar, int low, int high)
            {
         		 int target=ar[high];
         int i=0;
         int j=0;
         int count=low;
         while(count<high)
         {
             if(ar[count]>target)
            	 j++;
             else
             {
            	 i++;
            	 j++;
            	 if(i!=j)
            	 {
            		 int temp=ar[low+i-1];
            		 ar[low+i-1]=ar[count];
            		 ar[count]=temp;
                     numQuick++;
            	 }
             }
             count++;
         }
         if(low+i!=count)
             numQuick++;
         int temp=ar[low+i];
		 ar[low+i]=ar[count];
		 ar[count]=temp;
        return i+low;
       }   
 
}
