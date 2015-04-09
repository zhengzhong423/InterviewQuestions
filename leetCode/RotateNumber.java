package leetCode;

public class RotateNumber {

	public static void main(String[] args) {
//		RotateNumber rn=new RotateNumber();
//		ListNode head=new ListNode(1);
//		head.next=new ListNode(2);
//		int k=1;
//		
//		
////		ListNode rs=rn.rotateRight(head, k);
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        
        int len=getLen(head);
        if(len==0)
            return head;
        int rotateNum=len-k%len;
        
        ListNode root=reverse(head, rotateNum);
        
        head.next=reverse(head.next, k%len);
        
        return reverse(root, len);
    }
    
    public ListNode reverse(ListNode head, int rotateNum)
    {
        if(head==null || head.next==null || rotateNum==0)
            return head;
        ListNode root=new ListNode(0);
        root.next=head;
        while(rotateNum>0 && head.next!=null)
        {
            ListNode temp=root.next;
            root.next=head.next;
            head.next=head.next.next;
            root.next.next=temp;
            rotateNum--;
        }
        return root.next;
    }
    
    public int getLen(ListNode head)
    {
        int len=0;
        while(head!=null)
        {
            head=head.next;
            len++;
        }
        return len;
    }

}
