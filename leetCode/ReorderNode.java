package leetCode;

import java.util.ArrayList;

public class ReorderNode {

	public static void main(String[] args) {
		int[] input={1,2,3,4,5};
		ArrayList<ListNode> l=new ArrayList<ListNode>();
		for(int c:input)
			l.add(new ListNode(c));
		if(input.length>=2)
			for(int i=0;i<=input.length-2;i++)
			{
				l.get(i).next=l.get(i+1);
			}
		reorderList(l.get(0));
	}
	public static void reorderList(ListNode head)
	{
		ArrayList<ListNode> a=new ArrayList<ListNode>();
		ListNode temp=head;
		if(temp==null || temp.next==null)
			return;
		while(temp!=null)
		{
			a.add(temp);
			temp=temp.next;
		}
		for(int i=0; i<a.size()/2; i++)
		{
			temp=a.get(i).next;
			a.get(i).next=a.get(a.size()-1-i);
			a.get(a.size()-1-i).next=temp;
		}
			a.get(a.size()/2).next=null;
    }
}
