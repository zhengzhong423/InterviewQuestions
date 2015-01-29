package geeksForGeeks;

public class TravellingSalesman {
	int[][] distance={{0,1,3,4}, 
								{1,0,10,5},
								{3,10,0,2}, 
								{4,5,2,0}};
	int[] visited=new int[distance.length];
	
	public static void main(String[] args) {
		TravellingSalesman t=new TravellingSalesman();
		System.out.println(t.travel(0, 0));
	}
	public int travel(int cur, int num)
	{
		if(num==distance.length-2)
			return distance[cur][distance.length-1];
		int minValue=Integer.MAX_VALUE;
		for(int i=1; i<distance.length-1; i++)
		{
			if(visited[i]==0)
			{
				visited[i]=1;
				minValue=Math.min(travel(i, num+1)+distance[cur][i], minValue);
				visited[i]=0;
			}
		}
		return minValue;
	}

}
