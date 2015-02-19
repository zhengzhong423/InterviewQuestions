package geeksForGeeks;

import java.util.HashSet;
import java.util.Stack;

public class TopoLogicalSort {
	
	int k=6;
	int[][] adjMatrix={
			{0, 0, 0, 0, 0, 0},
			{0, 0 ,0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0},
			{0, 1 ,0, 0, 0, 0},
			{1, 1, 0, 0, 0, 0},
			{1, 0 ,1, 0, 0, 0},
	};
	int[] visited=new int[k];
	
	Stack<Integer> stack=new Stack<>();
	
	
	public static void main(String[] args) 
	{
		TopoLogicalSort tp=new TopoLogicalSort();
		
		for(int i=tp.k-1; i>=0; i--)
			if(tp.visited[i]!=1)
			{
				if(!tp.topo(i,new HashSet<Integer>()))
				{
					System.out.println("Loop");
					return;
				}
			}
		
		while(!tp.stack.isEmpty())
			System.out.println(tp.stack.pop());
	}
	
	public boolean topo(int node, HashSet<Integer> tempVisited)
	{
		visited[node]=1;
		HashSet<Integer> temp=new HashSet<>(tempVisited);
		temp.add(node);
		for(int i=0; i<k; i++)
			if(adjMatrix[node][i]!=0)
			{
				if(temp.contains(i))
						return false;
				else if(visited[i]==0)
				{
					if(!topo(i, temp))
						return false;
				}
			}
		stack.push(node);
		return true;
	}

}
