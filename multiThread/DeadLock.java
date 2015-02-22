package multiThread;

public class DeadLock {

	public static void main(String[] args) {
		final Object o1=new Object();
		final Object o2=new Object();
		
		Thread t1=new Thread()
		{
			public void run()
			{
					synchronized (o1)
					{
						System.out.println("t1 lock o1");
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						synchronized (o2) {
							System.out.println("t1 lock o2");
						}
				}
			}
		};
		
		Thread t2=new Thread()
		{
			public void run()
			{
					synchronized (o2)
					{
						System.out.println("t2 lock o2");
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						synchronized (o1) {
							System.out.println("t2 lock o1");
						}
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
