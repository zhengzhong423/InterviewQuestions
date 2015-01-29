package leetCode;

public class ConvertSortedList {

	public static void main(String[] args) {
		
	}
	 public TreeNode sortedListToBST(ListNode head)
	 {  
		 	if(head==null)
		 		return null;
		 	if(head.next==null)
		 		return new TreeNode(head.val);
			 ListNode slow=head;
			 ListNode fast=head;
			 while(fast.next.next!=null && slow.next!=null)
			 {
				 fast=fast.next.next;
				 if(fast.next==null)
					 break;
				 slow=slow.next;
			 }
			 TreeNode root=new TreeNode(slow.next.val);
			 ListNode head2=slow.next.next;
			 slow.next=null;
			 root.left=sortedListToBST(head);
			 root.right=sortedListToBST(head2);
			 return root;
	  }
}
