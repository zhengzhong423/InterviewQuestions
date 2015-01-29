package leetCode;

public class ReorderList {

	public static void main(String[] args) {
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next.next=new ListNode(4);
		reorderList(root);
	}
	 public static void reorderList(ListNode head) {
	        ListNode root=new ListNode(0);
	        root.next=head;
	        ListNode fast=root;
	        ListNode slow=root;
	        while(fast!=null && fast.next!=null)
	        {
	            fast=fast.next.next;
	            slow=slow.next;
	        }
	        ListNode mid=slow;
	        //reverse the nodes after mid
	        ListNode temp=slow.next;
	        while(temp!=null && temp.next!=null)
	        {
	            ListNode tempNode=temp.next.next;
	            temp.next.next=mid.next;
	            mid.next=temp.next;
	            temp.next=tempNode;
	        }
	        //insert nodes
	        while(mid.next!=null && head.next.next!=null)
	        {
	            ListNode tempNode=head.next;
	            head.next=mid.next;
	            //update right pointer 
	            mid.next=mid.next.next;
	            head.next.next=tempNode;
	            head=tempNode;
	        }
	    }

}
