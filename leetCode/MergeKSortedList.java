package leetCode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		ListNode a=new ListNode(0);
		a.next=new ListNode(1);
		ListNode b=new ListNode(3);
		b.next=new ListNode(4);
		List<ListNode> lists=new LinkedList<ListNode>();
		lists.add(a);
		lists.add(b);
	}
	public static ListNode mergeKLists2(List<ListNode> lists) {
		Comparator<ListNode> order=new Comparator<ListNode>()
		{
			@Override
			public int compare(ListNode arg0, ListNode arg1) {
				if(arg0.val<arg1.val)
					return -1;
				if(arg0.val==arg1.val)
					return 0;
				return 1;
			}
		};
		PriorityQueue<ListNode> p=new PriorityQueue<ListNode>(lists.size(), order);
		for(ListNode l: lists)
			if(l!=null)
				p.add(l);
		ListNode result= new ListNode(0);
		ListNode head=result;
		while(!p.isEmpty())
		{
			result.next=p.poll();
			result=result.next;
			if(result.next!=null)
				p.add(result.next);
		}
		return head.next;
	}
	public static ListNode mergeKLists(List<ListNode> lists) {
		 ListNode result= new ListNode(0);
		 ListNode head=result;
	        if(lists.size()==0)
	        	return null;
	        while(true)
	        {
	   		 int count=0;
			 int index=0;
	        	int stay=0;
	        	ListNode min=new ListNode(Integer.MAX_VALUE);
	        	for(ListNode l: lists)
	        	{
	        	    if(l==null)
	        	        ;
	        	    else
	        		{
	        			stay=1;
	        			min=(min.val>=l.val) ? l :min; 
	        			index=(min.val>=l.val) ? count : index;
	        		}
	        		count++;
	        	}
	        	if(stay==0)
	        		break;
	        	result.next=new ListNode(min.val);
	        	result=result.next;
	        	lists.set(index, min.next);
	        }
	        return head.next;
    }
}
