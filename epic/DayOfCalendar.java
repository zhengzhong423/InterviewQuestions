package epic;

import java.util.Stack;

public class DayOfCalendar{
	
	public static void main(String[] args)
	{
		DayOfCalendar d=new DayOfCalendar();
		d.getWeek(2015, 2, 28);
	}

	public void getWeek(int year, int month, int day)
	{

		Integer[] today=new Integer[] {year, month, day};
		
		Stack<Integer[]> s=new Stack<>();
		for(int i=0; i<2; i++)
		{
			Integer[] yes=yesterday(today[0], today[1], today[2]);
			s.push(yes);
			for(int j=0; j<3; j++)
				today[j]=yes[j];
		}
		while(!s.isEmpty())
		{
			Integer[] rs=s.pop();
			System.out.print(rs[0].toString()+'/'+rs[1].toString()+'/'+rs[2].toString());
			System.out.println();
		}
		today=new Integer[] {year, month, day};
		System.out.println(today[0].toString()+'/'+today[1].toString()+'/'+today[2].toString());
		for(int i=0; i<4; i++)
		{
			Integer[] tom=tomorrow(today[0], today[1], today[2]);
			System.out.println(tom[0].toString()+'/'+tom[1].toString()+'/'+tom[2].toString());
			for(int j=0; j<3; j++)
				today[j]=tom[j];
		}
		
	}
	public Integer[] yesterday(int year, int month, int day)
	{
		day=day-1;
		if(day==0)
		{
			month--;
			if(month==0)
				return new Integer[] {year-1, 12, 31};
			else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
				return new Integer[] {year, month, 31};
			else if(month==4 || month==6 || month==9 || month==11)
				return new Integer[] {year, month, 30};
			else
			{
				if(year%4==0)
					return new Integer[] {year, 2, 29};
				else
					return new Integer[] {year, 2, 28};
			}
		}
		return new Integer[] {year, month, day};
	}

	public Integer[] tomorrow(int year, int month, int day)
	{
		day++;
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10)
			if(day>31)
				return new Integer[] {year, month+1, 1};
		if(month==12)
			if(day>31)
				return new Integer[] {year+1, 1, 1};
		 if(month==4 || month==6 || month==9 || month==11)
			 if(day>30)
				 return new Integer[]{year, month+1, day};
		 if(month==2)
		 {
			 if(day==29 && year%4==0)
				 return new Integer[]{year, 2, 29};
			 if(day>28)
				 return new Integer[]{year, 3, 1};
		 }
		return new Integer[]{year, month, day};	
	}
}
