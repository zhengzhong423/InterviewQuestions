package leetCode;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		
		SimplifyPath s=new SimplifyPath();
		System.out.println(s.simplifyPath2("/abc/..."));
	}
	public String simplifyPath2(String path)
	{
			
	        String[] s=path.split("/");
	        Stack<String> stack=new Stack<>();
	        for(int i=0; i<s.length; i++)
	        {
	            if(s[i].equals(".."))
	            {
	                if(!stack.isEmpty())
	                    stack.pop();
	            }
	            else if(!s[i].equals(".") && !(s[i].length()==0))
	                    stack.push(s[i]);
	        }
	        StringBuffer sb=new StringBuffer();
	        for(int i=0; i<stack.size(); i++)
	            sb.insert(0, "/"+stack.pop());
	        if(stack.size()==0)
	            sb.insert(0, "/");
	        return sb.toString();
	}
	public String simplifyPath(String path) {
        String[] split=path.split("/");
        Stack<String> stack=new Stack<String>();
        for(int i=1; i<split.length; i++)
        {
        	if(!split[i].equals(".") && !split[i].equals(".."))
        		stack.add(split[i]);
        	if(!stack.isEmpty() && split[i].equals(".."))
        		stack.pop();
        }
        String result="/";
        while(!stack.isEmpty())
        	result="/"+stack.pop()+result;
        if(result.length()!=1)
        	result=result.substring(0, result.length()-1);
        return result;
    }
}
