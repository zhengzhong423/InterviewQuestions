package geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

import leetCode.TreeNode;

public class Serialize {

	public static void main(String[] args) {
		Serialize ser=new Serialize();
		String s="1,2,#,3,4,#,#,5,6";
		TreeNode root=ser.deserialize(s);
		System.out.println(ser.serialize(root));
	}
	
	public String serialize(TreeNode root)
	{
		String rs="";
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		rs+=(root.val+",");
		
		while(!q.isEmpty())
		{
			TreeNode cur=q.poll();
			if(cur.left==null)
				rs+="#,";
			else
			{
				rs+=(String.valueOf(cur.left.val)+",");
				q.add(cur.left);
			}
			
			if(cur.right==null)
				rs+="#,";
			else
			{
				rs+=(String.valueOf(cur.right.val)+",");
				q.add(cur.right);
			}
		}
		
		
		return rs.substring(0, rs.length()-1);
	}
	
	public TreeNode deserialize(String s)
	{
		String[] strs=s.split(",");
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
		q.add(root);
		
		int cur=1;
		
		while(!q.isEmpty() && cur<strs.length)
		{
			TreeNode tr=q.poll();
			
			if(!strs[cur].equals("#"))
			{
				tr.left=new TreeNode(Integer.parseInt(strs[cur]));
				q.add(tr.left);
			}
			cur++;
			
			if(cur>=strs.length)
				break;
			
			if(!strs[cur].equals("#"))
			{
				tr.right=new TreeNode(Integer.parseInt(strs[cur]));
				q.add(tr.right);
			}
			cur++;
		}
		
		return root;
	}

}
