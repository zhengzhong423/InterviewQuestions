package epic;

public class BubbleSwitch {

	public static void main(String[] args) {
		BubbleSwitch bs=new BubbleSwitch();
		boolean[] rs=bs.helper();
		for(int i=0; i<100; i++)
			System.out.println(i+" "+rs[i]);
	}
	public boolean[] helper()
	{
		boolean[] rs=new boolean[100];
		for(int step=1; step<100; step++)
		{
			int i=0;
			while(i<100)
			{
				rs[i]=rs[i]^true;
				i+=step;
			}
		}
		return rs;
	}

}
