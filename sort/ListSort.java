package sort;

public class ListSort {

	public static void main(String[] args) {
		ListNode root=new ListNode(3);
		root.next=new ListNode(2);
		root.next.next=new ListNode(4);
		System.out.println(sortList(root));
	}
	 public static ListNode sortList(ListNode head) {
	        if(head==null || head.next==null)
	            return head;
	        ListNode mid=getMid(head);
	        ListNode head2=mid.next;
	        if(head2==null)
	        	return merge(head, null);
	        mid.next=null;
	        head=sortList(head);
	        head2=sortList(head2);
	        ListNode root=merge(head, head2);
	        return root;
	    }
	    
	    public static ListNode merge(ListNode head, ListNode head2)
	    {
	        if(head==null)
	            return head2;
	        if(head2==null)
	            return head;
	        ListNode root=new ListNode(0);
	        ListNode temp=root;
	        ListNode p1=head;
	        ListNode p2=head2;
	        
	        while(p1!=null && p2!=null)
	        {
	            if(p1.val>p2.val)
	            {
	                temp.next=p2;
	                p2=p2.next;
	            }
	            else
	            {
	                temp.next=p1;
	                p1=p1.next;
	            }
	            temp=temp.next;
	        }
	        if(p1!=null)
	            temp.next=p1;
	        else
	            temp.next=p2;
	        return root.next;
	    }
	    
	    public static ListNode getMid(ListNode head)
	    {
	        ListNode fast=head;
	        ListNode slow=head;
	        while(fast.next!=null && fast.next.next!=null)
	        {
	            fast=fast.next.next;
	            slow=slow.next;
	        }
	        return slow;
	    }
}
