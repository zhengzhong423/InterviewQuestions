package leetCode;

public class ReverseKGroup {

	public static void main(String[] args) {
			ListNode l=new ListNode(1);
			l.next=new ListNode(2);
//			l.next.next=new ListNode(3);
//			l.next.next.next=new ListNode(4);
			ReverseKGroup rkg=new ReverseKGroup();
			rkg.reverseKGroup(l, 2);
	}
	 public int getLength(ListNode head)
	    {
	        ListNode temp=head;
	        int len=0;
	        while(temp!=null)
	        {
	            temp=temp.next;
	            len++;
	        }
	        return len;
	    }
	 
	 public ListNode reverseKGroup(ListNode head, int k) {
	        if(head==null)
	            return null;
	           
	        int len=getLength(head);
	        
	        if(k>len || k<=1)
	            return head;
	            
	        ListNode temp=head;
	        ListNode root=new ListNode(0);
	        root.next=head;
	        ListNode pre=root;
	        
	        int round=0;
	        
	        while(temp!=null && round<len/k)
	        {
	            int count=1;
	            while(count<k)
	            {
	                ListNode tempNode=pre.next;
	                pre.next=temp.next;
	                temp.next=temp.next.next;
	                temp.next.next=tempNode;
	                count++;
	            }
	            pre=temp;
	            temp=temp.next;
	            round++;
	        }
	        
	        return root.next;
	        
	    }
	 
//	public static ListNode reverseKGroup(ListNode head, int k) {
//        int num=1;
//        int count=1;
//        ListNode counter=head;
//
//        if(head==null)
//            return head;
//            
//        while(counter.next!=null)
//        {
//            counter=counter.next;
//            count++;
//        }
//        
//        if(count<k)
//            return head;
//        
//        ListNode pre=new ListNode(0);
//        pre.next=head;
//    
//        ListNode root=pre;
//        
//        while(head.next!=null && num<=count)
//        {
//            if(num>k*(count/k))
//                break;
//            if(num%k==0)
//            {
//                pre=head;
//                head=head.next;
//                num++;
//                continue;
//            }
//            ListNode temp=head.next.next;
//            head.next.next=pre.next;
//            pre.next=head.next;
//            head.next=temp;
//            num++;
//        }
//        
//        return root.next;
//    }

}
