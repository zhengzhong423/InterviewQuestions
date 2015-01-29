package leetCode;

public class SwapNodes {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public ListNode swapPairs(ListNode head) {
		if(head==null)
			return null;
        if(head.next==null)
        	return head;
        ListNode root=new ListNode(0);
        ListNode prev=root;
        ListNode temp=head;
        while(temp.next!=null)
        {
        	ListNode firstNode=temp;
        	ListNode secondNode=temp.next;
        	ListNode future=secondNode.next;
        	prev.next=secondNode;
        	secondNode.next=firstNode;
        	firstNode.next=future;
        	temp=future;
        	prev=firstNode;
        	if(temp==null)
        		break;
        }
        return root.next;
    }

}
