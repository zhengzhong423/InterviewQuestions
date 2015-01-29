package leetCode;

import java.util.*;

public class InsertInterpolation {

	public static void main(String[] args) {
		Interval l=new Interval(3,7);
		ArrayList<Interval> ar=new ArrayList<Interval>();
		ar.add(new Interval(3,8));
		ar.add(new Interval(9,11));
		System.out.println(insert(ar,l));

	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result=new ArrayList<Interval>();
        ArrayList<Interval> finalResult=new ArrayList<Interval>();
        if(intervals.size()==0)
        {
            result.add(newInterval);
            return result;
        }
        Interval temp=new Interval(newInterval.start, newInterval.end);
        for(Interval in: intervals)
        {
            if(in.end<newInterval.start || in.start>newInterval.end)
            {
                result.add(new Interval(in.start, in.end));
                continue;
            }
            else
            {
                if(in.start<newInterval.start && in.end<newInterval.end)
                {
                    temp.start=in.start;
                    continue;
                }
                if(in.start>newInterval.start && in.end<newInterval.end)
                {
                    continue;
                }
                if(in.start<newInterval.start && in.end>newInterval.end)
                {
                    temp.start=in.start;
                    temp.end=in.end;
                    continue;
                }
                if(in.start>newInterval.start && in.end>newInterval.end)
                {
                    temp.end=in.end;
                    continue;
                }
            }
        }
        if(result.size()>0)
        {
            if(temp.end<result.get(0).start)
            	finalResult.add(temp);
        }
        else
        {
            finalResult.add(temp);
            return finalResult;
        }
        for(int i=0; i<result.size(); i++)
        {
            if(result.get(i).start>temp.start)
                finalResult.add(temp);
            finalResult.add(result.get(i));
        }
        if(result.size()>0)
        {
            if(temp.start>result.get(result.size()-1).end)
        	    finalResult.add(temp);
        }
        return finalResult;
	}
}
