package leetCode;

public class BinaryAdd {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.print(addBinary("10","110010"));
	}
	public static String addBinary(String a, String b) {
        StringBuffer sa=new StringBuffer(a);
        sa.reverse();
        StringBuffer sb=new StringBuffer(b);
        sb.reverse();
        int i=0;
        int add=0;
        String result="";
        while(i<sa.length() && i<sb.length())
        {
        	if(sa.charAt(i)=='1' && sb.charAt(i)=='1')
                if(add==1)
                {
                    result="1"+result;
                    i++;
                    continue;
                }
                else
                {
                    result="0"+result;
                    add=1;
                    i++;
                    continue;
                }
            if(sa.charAt(i)=='0' && sb.charAt(i)=='0')
            {
                if(add==1)
                {
                    result="1"+result;
                    add=0;
                }
                else
                    result="0"+result;
            }
             else
                if(add==1)
                {
                    result="0"+result;
                    add=1;
                }
                else
                    result="1"+result;
            i++;
        }
        if(add==0)
        {
        	if(i<sa.length())
        	{
        		StringBuffer temp=new StringBuffer(sa.substring(i));
        		temp.reverse();
        		result=temp+result;
        	}
        	if(i<sb.length())
        	{
        		StringBuffer temp=new StringBuffer(sb.substring(i));
    			temp.reverse();
        		result=temp+result;
        	}
        }
        else
        {
        	if(i<sa.length())
	        	while(true)
	            {
	                if(sa.charAt(i)=='1')
	                    result="0"+result;
	                else
	                {
	                    result="1"+result;
	                    StringBuffer temp=new StringBuffer(sa.substring(i+1));
	            		temp.reverse();
	            		result=temp+result;
	                    
	                    break;
	                }
	                i++;
	                if(i>=sa.length())
	                {
	                    result="1"+result;
	                    break;
	                }
	            }
        	if(i<sb.length())
        		while(true)
	            {
	                if(sb.charAt(i)=='1')
	                    result="0"+result;
	                else
	                {
	                    result="1"+result;
	                    StringBuffer temp=new StringBuffer(sb.substring(i));
	            		temp.reverse();
	            		result=temp+result;
	                    break;
	                }
	                i++;
	                if(i>=sb.length())
	                {
	                    result="1"+result;
	                    break;
	                }
	            }
        	if(i==sb.length()&& i==sa.length())
        		result="1"+result;
        }
        return result;
        
    }
	

}
