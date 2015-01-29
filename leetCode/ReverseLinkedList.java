package leetCode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		

	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root=new ListNode(0);
        if(head==null)
        	return null;
        root.next=head;
        ListNode temp=head;
        ListNode pre=root;
        int num=1;
        while(num<n)
        {
        	if(num>=m)
        	{
        		if(temp.next!=null)
        		{
	        		pre.next=temp.next;
	        		ListNode l=pre.next.next;
	        		pre.next.next=temp;
	        		temp.next=l;
	        		num++;
	        		continue;
        		}
        	}
        	pre=temp;
        	temp=temp.next;
        	num++;
        }
        return root.next;
    }

}
