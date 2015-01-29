package hackerank;
import java.util.*;


public class ICPCteam {
	
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int num=in.nextInt();
       in.nextInt();
       int max=0;
       String[] str=new String[num];
       in.nextLine();
       for(int i=0; i<num; i++)
       {
          str[i]=in.nextLine();
       }
       int temp=0;
       int flag=0;
       int count=0;
       for(int i=0; i<num; i++)
    	   for(int j=i+1; j<num; j++)
    	   {
    		   temp=Integer.valueOf(str[i], 2) | Integer.valueOf(str[j],2);
    		   flag=compare(max, temp);
    		   if(flag==-1)
    			   count++;
    		   else
    		   {
    			   count=1;
    			   max=flag;
    		   }
    	   }
       System.out.println(max);
       System.out.println(count);
       in.close();
    }

	private static int compare(int max, int temp) {
		int num = 0;
		for(int i=0; i<Integer.toBinaryString(temp).length(); i++)
		{
			String s=Integer.toBinaryString(temp);
			if(s.charAt(i)=='1')
				num++;
		}
		if(num>max)
			return num;
		if(num==max)
			return -1;
		return max;
	}
}
