package leetCode;


public class InsertionSortedList {

	public static void main(String[] args) {
		ListNode l=new ListNode(3);
		l.next=new ListNode(4);
		l.next.next=new ListNode(1);
		System.out.println(insertionSortList(l));
	}
	 public static ListNode insertionSortList(ListNode head) {
	        if(head==null)
	            return null;

	        ListNode root=new ListNode(0);
	        ListNode sorted=head;
	        int count=1;
	        root.next=head;
	        ListNode temp=head;
	        temp=temp.next;
	        
	        while(temp!=null)
	        {
	            ListNode prevNode=root;
	            ListNode tempNext=temp.next;
	            while(head!=temp)
	            {
	                if(temp.val<head.val)
	                {
	                	temp.next=prevNode.next;
	                    prevNode.next=temp;
	                    sorted.next=tempNext;
	                    break;
	                }
	                prevNode=prevNode.next;
	                head=head.next;
	            }
	            head=root.next;
	            count++;
	            sorted=root;
	            for(int i=0; i<count; i++)
	            {
	            	sorted=sorted.next;
	            } 
	            temp=tempNext;
	        }
	        return root.next;
	    }

}
