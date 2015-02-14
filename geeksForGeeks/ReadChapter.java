package geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;

public class ReadChapter {
	static int min=Integer.MAX_VALUE;
	static ArrayList<Integer> rs=new ArrayList<>();
	static int days=3;
	
	public static void main(String[] args) {
		int[] num={10,3,3,4,2,2,6};
		int day=3;
		assign(num, day);
	}
	public static void assign(int[] num, int day)
	{
		int avg=getAvg(num, day);
		int[][] chapter=getChapter(num, avg);
		backTrack(chapter, 0, 0, -1, new ArrayList<Integer>());
		System.out.println("Recursion");
		System.out.println(rs);

 		int[][] opt=search(chapter, day);
		int[] path=getSolution(opt, chapter);
		System.out.println("DP");
		for(int i=2; i<path.length; i++)
			System.out.println(path[i]);
		System.out.println(chapter.length-1);
		
	}
	private static void backTrack(int[][] chapter, int day, int sum, int tillChapter, ArrayList<Integer> path)
	{
		if(day>days)
			return;
		if(tillChapter==chapter.length-1 && day==days)
		{
			if(sum<min)
			{
				rs=new ArrayList<>(path);
				min=sum;
			}
			return;
		}
		for(int i=tillChapter+1; i<chapter.length; i++)
		{
			ArrayList<Integer> newPath=new ArrayList<>(path);
			newPath.add(i);
			backTrack(chapter, day+1, sum+chapter[tillChapter+1][i], i, newPath);
		}
	}

	private static  int[] getSolution(int[][] opt, int[][] chapter) {
		int[] path=new int[opt.length];
		int i=opt.length-1;
		int j=opt[0].length-1;
		while(i>0)
		{
			int temp=-1;
			for(int k=0; k<j; k++)
					if(opt[i][j]==opt[i-1][k]+chapter[k+1][j])
					{
						path[i]=k;
						temp=k;
					}
			i--;
			j=temp;
		}
		return path;
	}
	public static int[][] search(int[][] chapter, int day)
	{
		int[][] opt=new int[day+1][chapter.length];
		for(int i=0; i<=day; i++)
			Arrays.fill(opt[i], Integer.MAX_VALUE);
		for(int i=1; i<=day; i++)
			for(int j=0; j<chapter.length; j++)
			{
				if(i==1)
					opt[1][j]=chapter[0][j];
				else
				for(int k=0; k<j; k++)
					if(opt[i-1][k]!=Integer.MAX_VALUE)
						opt[i][j]=Math.min(opt[i-1][k]+chapter[k+1][j], opt[i][j]);
			}
		return opt;
	}
	
	private static int getAvg(int[] num, int day) {
		int sum=0;
		for(int i=0; i<num.length; i++)
			sum+=num[i];
		return sum/day;
	}
	public static int[][] getChapter(int[] num, int avg)
	{
		int[][] chapter=new int[num.length][num.length];
		for(int i=0; i<num.length; i++)
		{
			int sum=0;
			for(int j=i; j<num.length; j++)
			{
				sum+=num[j];
				chapter[i][j]=Math.abs(sum-avg);
			}
		}
		return chapter;
	}
}
