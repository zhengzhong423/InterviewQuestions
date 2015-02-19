package multiThread;

public class Thread2 extends Thread {
		int k=200;
		public void run()
		{
			while(k-->0)
			{
				System.out.println("2");
				
				try {
					sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}
