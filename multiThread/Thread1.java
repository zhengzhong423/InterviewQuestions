package multiThread;

public class Thread1 extends Thread {
		int k=200;
		public void run()
		{
			while(k-->0)
			{
				System.out.println("1");
				try {
					sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}
