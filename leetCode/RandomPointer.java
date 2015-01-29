package leetCode;

public class RandomPointer {
	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * }; 
	 */
	public static void main(String args[])
	{
		RandomListNode r=new RandomListNode(1);
		RandomListNode result=copyRandomList(r);
		RandomListNode temp=result;
		while(temp!=null)
		{
			System.out.println(temp.label);
			temp=temp.next;
		}
	}
	public static RandomListNode copyRandomList(RandomListNode head) 
	{
		RandomListNode temp=head;
		if(head==null)
			return head;
		//copy each node once
        while(temp!=null)
        {
        	RandomListNode tempNext=temp.next;
        	temp.next=new RandomListNode(temp.label);
        	temp.next.next=tempNext;
        	temp=tempNext;
        }
        //copy random pointer
        temp=head;
        while(temp!=null)
        {
        	if(temp.random!=null)
        		temp.next.random=temp.random.next;
        	temp=temp.next.next;
        }
        //remove redundant node
        RandomListNode head1=head.next;
        temp=head;
        while(temp!=null)
        {
        	RandomListNode tempNext=temp.next.next;
			if(tempNext==null)
			{
				temp.next.next=null;
				temp.next=null;
			}
			else
			{
				temp.next.next=tempNext.next;
				temp.next=tempNext;
			}
             temp=temp.next;
        }
        return head1;
    }
}
