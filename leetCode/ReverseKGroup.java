package leetCode;

public class ReverseKGroup {

	public static void main(String[] args) {
			ListNode l=new ListNode(1);
			l.next=new ListNode(2);
			l.next.next=new ListNode(3);
			l.next.next.next=new ListNode(4);
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
        int num=1;
        int count=1;
        ListNode counter=head;

        if(head==null)
            return head;
            
        while(counter.next!=null)
        {
            counter=counter.next;
            count++;
        }
        
        if(count<k)
            return head;
        
        ListNode pre=new ListNode(0);
        pre.next=head;
    
        ListNode root=pre;
        
        while(head.next!=null && num<=count)
        {
            if(num>k*(count/k))
                break;
            if(num%k==0)
            {
                pre=head;
                head=head.next;
                num++;
                continue;
            }
            ListNode temp=head.next.next;
            head.next.next=pre.next;
            pre.next=head.next;
            head.next=temp;
            num++;
        }
        
        return root.next;
    }

}
