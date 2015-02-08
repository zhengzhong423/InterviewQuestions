package geeksForGeeks;

public class LinkedListPalindrome {
		static class ListNode
		{
			int val;
			ListNode next;
			public ListNode(int val)
			{
				this.val=val;
			}
		}
		public static void main (String[] args) throws java.lang.Exception
		{
			
			ListNode l=new ListNode(10);
			l.next=new ListNode(5);
			l.next.next=new ListNode(1);
			l.next.next.next=new ListNode(1);
			l.next.next.next.next=new ListNode(5);
			l.next.next.next.next.next=new ListNode(10);
			System.out.println(helper(l));
		}
		public static boolean helper(ListNode l)
		{
			ListNode root=new ListNode(0);
			root.next=l;
			ListNode slow=root;
			ListNode fast=root;
			while(fast!=null && fast.next!=null)
			{
				fast=fast.next.next;
				slow=slow.next;
			}
			ListNode temp=slow.next;
			while(temp!=null && temp.next!=null)
			{
				ListNode tempNode=slow.next;
				slow.next=temp.next;
				temp.next=temp.next.next;
				slow.next.next=tempNode;
			}
			ListNode mid=slow.next;
			while(mid!=null)
			{
				if(l.val!=mid.val)
					return false;
				mid=mid.next;
				l=l.next;
			}
			return true;
			
		}
		

}
