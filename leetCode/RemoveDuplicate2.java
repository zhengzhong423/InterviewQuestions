package leetCode;

public class RemoveDuplicate2 {

	public static void main(String[] args) {
		

	}
	public ListNode deleteDuplicates(ListNode head) {
        ListNode root=new ListNode(0);
        ListNode pre=root;
        if(head==null)
        	return null;
        root.next=head;
        ListNode temp=head;
        int delete=0;
        while(temp.next!=null)
        {
        	if(temp.val==temp.next.val)
        	{
        		delete=1;
        		temp.next=temp.next.next;
        	}
        	else
        	{
        		if(delete==0)
        		{
        			pre=temp;
        			temp=temp.next;
        		}
        		else
        		{
        			pre.next=temp.next;
        			temp=temp.next;
        			delete=0;
        		}
        	}
        }
        if(delete==1)
        {
        	pre.next=null;
        }
        return root.next;
    }

}
