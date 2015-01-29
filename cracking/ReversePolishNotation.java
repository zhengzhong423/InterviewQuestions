import java.util.*;


public class ReversePolishNotation 
{
	public static void main(String[] args) 
	{
		String[] test1={"2","1","+","3","*"};
		String[] test2={"4","13","5","/","+"};
		ReversePolishNotation a=new ReversePolishNotation();
		System.out.println(a.evalRPN(test1));
		System.out.println(a.evalRPN(test2));
	}
    public int evalRPN(String[] tokens)
    {
        int temp1=0;
        int temp2=0;
        int temp3=0;
    	Stack<Integer> s=new Stack<Integer>();
         for(int i=0;i<=tokens.length-1;i++)
         {
        	 switch(tokens[i])
        	 {
        	 case "+":
        		 temp1=s.pop();
        		 temp2=s.pop();
        		 s.push(temp1+temp2);
        		 break;
        	 case "-":
        		 temp1=s.pop();
        		 temp2=s.pop();
        		 s.push(temp2-temp1);
        		 break;
        	 case "*":
        		 temp1=s.pop();
        		 temp2=s.pop();
        		 s.push(temp1*temp2);
        		 break;
        	 case "/":
        		 temp1=s.pop();
        		 temp2=s.pop();
        		 temp3=temp2/temp1;
        		 s.push(temp3);
        		 break;
        	 default:
        		s.push(Integer.parseInt(tokens[i]));        		 
        	 }  	
         }
         return s.pop();
    }
}

