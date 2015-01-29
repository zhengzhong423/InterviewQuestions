package hackerank;

import java.util.*;

public class Xreplace {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.nextLine();
        String[] a=new String[n];
        for(int i=0; i<n; i++)
           a[i]=s.nextLine();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==0 || i==n-1 || j==0 || j==n-1)
                    System.out.print(a[i].charAt(j));
                else
               {
                if(a[i].charAt(j)>a[i-1].charAt(j) && a[i].charAt(j)>a[i+1].charAt(j) && a[i].charAt(j)>a[i].charAt(j-1) && a[i].charAt(j)>a[i].charAt(j+1))
                    System.out.print('X');
                else
                    System.out.print(a[i].charAt(j));
                }
            }
        System.out.println();
        }
        s.close();
    }
}
