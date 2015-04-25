package interesting;

import java.util.Stack;

import leetCode.TreeNode;

public class PocketGem {

	public static void main(String[] args) {
		String str="1?2?3:28?9:0:5?6:47";
		new PocketGem().toTree(str);
	}
	
	public TreeNode toTree(String str)
	{
		Stack<TreeNode> s=new Stack<TreeNode>();
		int index=0;
		String buffer=nextNum(str, index);
		int val=Integer.parseInt(buffer);
		index+=buffer.length();
		TreeNode root=new TreeNode(val);
		TreeNode cur=root;
		while(index<str.length())
		{
			if(str.charAt(index)=='?')
			{
				index++;
				s.push(cur);
				buffer=nextNum(str, index);
				cur.left=new TreeNode(Integer.parseInt(buffer));
				cur=cur.left;
				index+=buffer.length();
			}
			else
			{
				index++;
				buffer=nextNum(str, index);
				s.peek().right=new TreeNode(Integer.parseInt(buffer));
				cur=s.pop().right;
				index+=buffer.length();
			}
		}
		return root;
	}
	public String nextNum(String str, int index)
	{
		String buffer="";
		while(index<str.length() && str.charAt(index)!=':' && str.charAt(index)!='?')
			buffer+=str.charAt(index++);
		return buffer;
	}
}
