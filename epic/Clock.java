package epic;

public class Clock {

	public static void main(String[] args) {
		Clock c=new Clock();
		System.out.println(c.helper(new int[] {13,00}));
	}
	
	public int helper(int[] time)
	{
		int hour=time[0];
		int min=time[1];
		
		int degreeMin=min*360/60;
		int degreeHour=hour*360/12+min/60*360/12;
		
		if(Math.abs(degreeMin-degreeHour)>180)
			return 360-Math.abs(degreeMin-degreeHour);
		return Math.abs(degreeMin-degreeHour);
	}

}
