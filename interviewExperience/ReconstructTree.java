package interviewExperience;

import java.util.ArrayList;
import java.util.HashMap;

public class ReconstructTree {

	class NTreeNode
	{
		int val; 
		ArrayList<NTreeNode> children=new ArrayList<>();
		public NTreeNode(int val)
		{
			this.val=val;
		}
	}
	HashMap<NTreeNode, Boolean> hash=new HashMap<>();
	
	public void addRelation(NTreeNode  p, NTreeNode c)
	{
		p.children.add(c);
		if(!hash.containsKey(p))
			hash.put(p, false);
		hash.put(c, true);
	}
	
	public NTreeNode findRoot()
	{
		for(NTreeNode node: hash.keySet())
		{
			if(!hash.get(node))
				return node;
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		ReconstructTree rt=new ReconstructTree();
		NTreeNode a1=rt.new NTreeNode(0);
		NTreeNode a2=rt.new NTreeNode(1);
		NTreeNode a3=rt.new NTreeNode(2);
		NTreeNode a4=rt.new NTreeNode(3);
		
		rt.addRelation(a3, a4);
		rt.addRelation(a1, a2);
		rt.addRelation(a1, a3);
		
		NTreeNode root=rt.findRoot();
		System.out.println(root.val);
	}
		
}
