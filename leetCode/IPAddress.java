package leetCode;

import java.util.LinkedList;
import java.util.List;

public class IPAddress {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public List<String> restoreIpAddresses(String s) {
        List<String> result=new LinkedList<String>();
        if(s.length()>12 || s.length()<4)
        	return result;
        for(int a=1; a<4; a++)
        {
        	if(Integer.parseInt(s.substring(0,a))<0 || Integer.parseInt(s.substring(0,a))>255)
        		continue;
        	if(Integer.parseInt(s.substring(0,a))==0 && a-0!=1)
        		continue;
        	if(Integer.parseInt(s.substring(0,1))==0 && Integer.parseInt(s.substring(0,a))!=0)
        		continue;
        	for(int b=a+1; b<a+4; b++)
        	{
        		if(b>s.length())
        			continue;
        		if(Integer.parseInt(s.substring(a,b))<0 || Integer.parseInt(s.substring(a,b))>255)
            		continue;
            	if(Integer.parseInt(s.substring(a,b))==0 && b-a!=1)
            		continue;
            	if(Integer.parseInt(s.substring(a,a+1))==0 && Integer.parseInt(s.substring(a,b))!=0)
            		continue;
        		for(int c=b+1; c<b+4; c++)
        		{
        			if(c>=s.length())
        				continue;
        			if(Integer.parseInt(s.substring(b,c))<0 || Integer.parseInt(s.substring(b,c))>255)
                		continue;
                	if(Integer.parseInt(s.substring(b,c))==0 && c-b!=1)
                		continue;
                	if(Integer.parseInt(s.substring(b,b+1))==0 && Integer.parseInt(s.substring(b,c))!=0)
                		continue;
        			if((s.length()-c)<0)
        				continue;
        			if(Integer.parseInt(s.substring(c,s.length()))<0 || Integer.parseInt(s.substring(c,s.length()))>255)
                		continue;
                	if(Integer.parseInt(s.substring(c,s.length()))==0 && s.length()-c!=1)
                		continue;
                	if(Integer.parseInt(s.substring(c,c+1))==0 && Integer.parseInt(s.substring(c,s.length()))!=0)
                		continue;
        			result.add(s.substring(0,a)+"."+s.substring(a, b)+"."+s.substring(b,c)+"."+s.substring(c,s.length()));
        		}
        	}
        }
        return result;
    }

}
