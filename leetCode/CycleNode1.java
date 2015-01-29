package leetCode;

import java.util.ArrayList;

public class CycleNode1 {

	public static void main(String[] args) {
		int[] input={1,2,3,4,5};
		ArrayList<ListNode> l=new ArrayList<ListNode>();
		for(int c:input)
			l.add(new ListNode(c));
		if(input.length>=2)
			for(int i=0;i<=input.length-2;i++)
			{
				l.get(i).next=l.get(i+1);
			}
		l.get(l.size()-1).next=l.get(1);
		if(detectCycle(l.get(0))!=null)
			System.out.println(detectCycle(l.get(0)).val);
		else
			System.out.println(-1);
	}
	 public static ListNode detectCycle(ListNode head) 
	 {
	    ListNode fast=head, slow=head;
	    while(fast!=null || slow!=null)
	    {
	    	fast=fast.next.next;
	    	slow=slow.next;
	    	if(fast==slow)
	    		return meetingNode(fast, head);
	    }
	    return null;
	 }
	public static ListNode meetingNode(ListNode fast, ListNode head) 
	{
		while(true)
		{
			if(fast==head)
				return fast;
			head=head.next;
			fast=fast.next;
		}
	}
}
