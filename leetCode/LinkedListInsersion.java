package leetCode;

public class LinkedListInsersion {

	public static void main(String[] args)
	{
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(2);
		ListNode sortedList=insertionSortList(l1);
		System.out.println(sortedList);
	}
	public static ListNode insertionSortList(ListNode head) 
	{
		if(head==null || head.next==null)
			return head;
		ListNode sorted=new ListNode(0);
		ListNode tempHead=head;
		ListNode tempSorted=new ListNode(0);
		tempSorted.next=new ListNode(head.val);
		sorted.next=tempSorted;
		while(tempHead.next!=null)
		{
			tempHead=tempHead.next;
			while(tempSorted.next!=null)
			{
				if(tempSorted.next.val>tempHead.val)
				{
					ListNode temp=tempSorted.next;
					tempSorted.next=new ListNode(tempHead.val);
					tempSorted.next.next=temp;
					break;
				}
				if(tempSorted.next.next == null)
				{
					tempSorted.next.next=new ListNode(tempHead.val);
					break;
				}
				tempSorted=tempSorted.next;
			}
			tempSorted=sorted.next;
		}
		return sorted.next.next;
    }
}
