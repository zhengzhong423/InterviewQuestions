package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {

	public static void main(String[] args) {

	}
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
        Queue<UndirectedGraphNode> q= new LinkedList<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> hash=new HashMap<Integer, UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> hash2=new HashMap<Integer, UndirectedGraphNode>();
        if(node==null)
        	return null;
        q.add(node);
        while(!q.isEmpty())
        {
        	UndirectedGraphNode tmp=q.remove();
        	if(!hash.containsKey(tmp.label))
        	{
        		hash.put(tmp.label, new UndirectedGraphNode(tmp.label));
	        	for(UndirectedGraphNode neighbor: tmp.neighbors)
	        	{
	        		q.add(neighbor);
	        	}
        	}
        }
        q.add(node);
        UndirectedGraphNode newNode=hash.get(node.label);
        while(!q.isEmpty())
        {
        	UndirectedGraphNode tmp=q.remove();
        	if(!hash2.containsKey(tmp.label))
        	{
        		hash2.put(tmp.label, tmp);
        		for(UndirectedGraphNode neighbor: tmp.neighbors)
	        	{
	        		q.add(neighbor);
	            	hash.get(tmp.label).neighbors.add(hash.get(neighbor.label));
	        	}
        	}
        }
        return newNode;
    }
}
