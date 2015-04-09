package multiThread;

public class Thread2 extends Thread {
		int k=200;
		Object lock;
		
		public Thread2(Object lock) {
			this.lock=lock;
		}
		
		public void run()
		{
			while(k-->0)
			{
				synchronized(lock)
				{
						System.out.println("222");
						lock.notify();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
		}
}
