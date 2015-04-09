package leetCode;

import java.util.HashMap;

public class RandomPointer {
	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * }; 
	 */
	public static void main(String args[])
	{
		RandomPointer rp=new RandomPointer();
		RandomListNode r=new RandomListNode(1);
		RandomListNode result=rp.copyRandomList(r);
		RandomListNode temp=result;
		while(temp!=null)
		{
			System.out.println(temp.label);
			temp=temp.next;
		}
	}
	 public RandomListNode copyRandomList(RandomListNode head) {
	        
	        HashMap<RandomListNode, RandomListNode> hash=getAllNodes(head);
	        RandomListNode root=head;
	        while(head!=null)
	        {
	            if(hash.containsKey(head.next))
	                hash.get(head).next=hash.get(head.next);
	            if(hash.containsKey(head.random))
	                hash.get(head).random=hash.get(head.random);
	            head=head.next;
	        }
	        return hash.get(root);
	    }
	    
	    public HashMap<RandomListNode, RandomListNode> getAllNodes(RandomListNode head)
	    {
	        HashMap<RandomListNode, RandomListNode> hash=new HashMap<RandomListNode, RandomListNode>();
	        while(head!=null)
	        {
	            hash.put(head,new RandomListNode(head.label));
	            head=head.next;
	        }
	        return hash;
	    }
}
