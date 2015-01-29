package leetCode;

import java.awt.Point;
import java.util.HashMap;


public class MaxPointLine {
	public static void main(String[] args)
	{
		Point[] points={new Point(1,1), new Point(2,3), new Point(2,4)};
		System.out.println(maxPoint(points));
	}
	public static int maxPoint(Point[] points)
	{
		float slope=0;
		int max=0;
		HashMap<Float, Integer> hash=new HashMap<Float, Integer>();
		if(points.length==0)
			return 0;
		if(points.length==1)
			return 1;
		for(int i=0; i<=points.length-1; i ++)
		{
			for(int j=i+1; j<=points.length-1; j++)
			{
				if((points[i].x!=points[j].x)||(points[i].y!=points[j].y))
				{
					if((points[j].x!=points[i].x))
					{
						slope=(float)(points[j].y-points[i].y)/(points[j].x-points[i].x);
					}
					else
						slope=Float.MAX_VALUE;
					if(slope==-0.0)
						slope=(float) 0.0;
					if(hash.containsKey(Float.MIN_VALUE))
					{
						hash.put(slope, hash.get(Float.MIN_VALUE)+1);
						hash.remove(Float.MIN_VALUE);
						continue;
					}
					if(hash.containsKey(slope))
						hash.put(slope, 1+hash.get(slope));
					else
						hash.put(slope, 2);
					
				}
				else
				{
					if((points[i].x==points[j].x)&&(points[i].y==points[j].y)&&hash.size()==0)
					{
						hash.put(Float.MIN_VALUE, 2);
						continue;
					}
					for(float f: hash.keySet())
					{
						hash.put(f, hash.get(f)+1);
					}
				}
			}
			for(Integer p: hash.values())
			{
				max=Math.max(max, p);
			}	
			hash.clear();
		}
		return max;
	}
}
