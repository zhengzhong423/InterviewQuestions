package leetCode;


public class LinkedListMerge {
	public static void main(String[] args)
	{
		ListNode l1=new ListNode(1);
//		l1.next=new ListNode(3);
//		l1.next.next=new ListNode(2);
//		l1.next.next.next=new ListNode(4);
		ListNode sortedList=sortList(l1);
		System.out.println(sortedList);
	}
	public static ListNode sortList(ListNode head) 
	{
		int count=0;
		if(head==null)
			return head;
		ListNode temp=head;
		ListNode temp2;
		while (temp.next!=null)
		{
			count++;
			temp=temp.next;
		}
		int mid=count/2;
		if(count==0)
		{
			return head;
		}
		temp=head;
		for(int i=0; i<mid;i++)
		{
			temp=temp.next;
		}
		temp2=temp.next;
		temp.next=null;
		ListNode sorted1=sortList(head);
		ListNode sorted2=sortList(temp2);
		return merge(sorted1, sorted2);
	}
	private static ListNode merge(ListNode sorted1, ListNode sorted2) {
		ListNode merged = new ListNode(0);
		ListNode tempMerged=merged;
		while(sorted1!=null && sorted2!=null)
		{
			if(sorted1.val>= sorted2.val)
			{
				merged.next=sorted2;
				sorted2=sorted2.next;
			}
			else
			{
				merged.next=sorted1;
				sorted1=sorted1.next;
			}
			merged=merged.next;
		}
		if(sorted1!=null)	merged.next=sorted1;
		if(sorted2!=null)	merged.next=sorted2;
		return tempMerged.next;
	}
}