package leetCode;

public class SortedListToBST {

	public static void main(String[] args) {
	}
	 public TreeNode sortedListToBST(ListNode head) {
	        
	        if(head==null)
	            return null;
	        ListNode mid=findMid(head);
	        if(mid.next==null)
	            return new TreeNode(mid.val);
	            
	        ListNode temp=mid.next.next;
	        TreeNode thisNode=new TreeNode(mid.next.val);
	        mid.next=null;
	        TreeNode left=sortedListToBST(head);
	        TreeNode right=sortedListToBST(temp);
	        thisNode.left=left;
	        thisNode.right=right;
	        
	        return thisNode;
	    }
	    public ListNode findMid(ListNode head)
	    {
	        ListNode fast=head;
	        ListNode slow=head;
	        while(fast!=null && fast.next!=null && fast.next.next!=null)
	        {
	            fast=fast.next.next;
	            slow=slow.next;
	        }
	        return slow;
	    }

}
