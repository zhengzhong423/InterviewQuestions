package interviewExperience;

public class Node 
{ 
//**** LINK TO THE NEXT NODE *****// 
public Node next; 

//**** CONTENT OF THIS NODE *****// 
private int val; 

// … there are many more members here 

public Node(int val)
{
	this.val=val;
}
// Feel free to add helper functions if needed here. 

// Note: removalRequests_Length is the same as removalRequests.Length 
	 public Node Remove( Node firstNode, int[] removalRequests, int removalRequests_Length ) 
	{ 
	// Your implementation in C# or Java goes here 
	     int pointerNode=0;
	     int pointerRequest=0;
	     Node temp=firstNode;
	     Node pre=firstNode;
	     while(temp!=null)
	     {
	         temp=temp.next;
	         pointerNode++;
	         if(pointerNode==removalRequests[pointerRequest])
	         {
	             pre.next=temp.next;
	             pointerRequest++;
	             if(pointerRequest>=removalRequests_Length)
	                 break;
	         }
	         else
	        	pre=pre.next;
	     }
	     return firstNode;
	} 
	
	public static void main(String[] args)
	{
		Node n0=new Node(0);
		n0.next=new Node(1);
		n0.next.next=new Node(2);
		n0.next.next.next=new Node(3);
		n0.next.next.next.next=new Node(4);
		
		Node k=n0.Remove(n0, new int[]{1,2}, 2);
		System.out.println(k.val);
	}
}
