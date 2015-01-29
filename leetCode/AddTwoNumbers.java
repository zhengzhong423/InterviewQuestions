package leetCode;

public class AddTwoNumbers {
	public static void main(String[] args)
	{
		
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
			return null;
		ListNode l3=new ListNode(0);
		ListNode head=l3;
		int add=0;
		ListNode temp1=l1;
		ListNode temp2=l2;
		while(!(temp1.next==null && temp2.next==null)) 
		{
			if(temp1.next==null && temp2.next!=null)
				temp1.next=new ListNode(0);
			if(temp2.next==null && temp1.next!=null)
				temp2.next=new ListNode(0);
			temp1=temp1.next;
			temp2=temp2.next;
		}
		while(l1!=null && l2!=null)
        {
        	int value=l1.val+l2.val+add;
        	if(value>=10)	
        	    add=1;
        	else 
        	    add=0;
        	value=value%10;
        	l3.next=new ListNode(value);
        	l3=l3.next;
        	l1=l1.next;
        	l2=l2.next;
        }
		if(add==1)
			l3.next=new ListNode(1);
		return head.next;
    }
}
