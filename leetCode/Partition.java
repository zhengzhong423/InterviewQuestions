package leetCode;

public class Partition {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
    public ListNode partition(ListNode head, int x) 
    {
        ListNode root=new ListNode(0);
        if(head==null)
        	return null;
        root.next=head;
        ListNode pre=root;
        ListNode temp=head;
        ListNode fix=pre;
        //iteration
        while(temp!=null)
        {
        	if(temp.val>=x)
        	{
        		pre=temp;
        		temp=temp.next;
        	}
        	else
        	{
        		if(pre!=fix)
        		{
	        		ListNode l=fix.next;
	        		fix.next=temp;
	        		pre.next=temp.next;
	        		temp.next=l;
	        		fix=temp;
	        		temp=pre.next;
        		}
        		else
        		{
        			pre=temp;
        			fix=pre;
        			temp=temp.next;
        		}
        	}
        }
        return root.next;
       
        
    }
}
