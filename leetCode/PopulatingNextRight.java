package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRight {

	public static void main(String[] args) 
	{
		TreeLinkNode a=new TreeLinkNode(1);
		a.left=new TreeLinkNode(2);
		a.right=new TreeLinkNode(3);
		connect2(a);
	}
	 public static void connect(TreeLinkNode root)
	 {
	       Queue<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
	       Queue<TreeLinkNode> next=new LinkedList<TreeLinkNode>();
	       q.add(root);
	       while(!q.isEmpty() || !next.isEmpty())
	       {
		       while(!q.isEmpty())
		       {
			       TreeLinkNode temp=q.remove();
			       if(temp.left!=null)
			    	   next.add(temp.left);
			       if(temp.right!=null)
			    	   next.add(temp.right);
			       if(q.isEmpty())
			    	   temp.next=null;
			       else
			    	   temp.next=q.peek();
		       }
		       q.addAll(new LinkedList<TreeLinkNode>(next));
		       next.clear();
	       }
	 }
	 public static void connect2(TreeLinkNode root)
	 {
	       TreeLinkNode mover=root;
	       TreeLinkNode cur=root;
	       if(root==null)
	    	   return;
	       while(cur!=null)
	       {
		       while(mover!=null)
		       {
		    	   if(mover.left!=null)
		    		   mover.left.next=mover.right;
		    	   if(mover.right!=null)
		    		   mover.right.next=mover.next;
		    	   mover=mover.next;
		       }
		       cur=cur.left;
	       }
	 }

}
