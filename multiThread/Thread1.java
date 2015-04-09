package multiThread;

public class Thread1 extends Thread {
		int k=200;
		Object lock;
		
		public Thread1(Object lock) {
			this.lock=lock;
		}
		
		public void run()
		{	
			while(k-->0)
			{
				System.out.println();
				synchronized(lock)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(111);
					lock.notify();
				}
			}
		}
}
