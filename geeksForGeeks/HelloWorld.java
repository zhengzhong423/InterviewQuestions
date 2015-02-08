package geeksForGeeks;

public class HelloWorld {
	Object a=new Object();
	int state=0;
	public static void main(String[] args) {
		HelloWorld h1=new HelloWorld();
		printHello hello=h1.new printHello();
		printWorld world=h1.new printWorld();
		hello.start();
		world.start();
	}
	public class printHello extends Thread
	{
		public void run()
		{
			while(true)
				synchronized(a)
				{
					try {
						if(state==0)
						{
							System.out.println("Hello");
							state=1;
							a.notify();
						}
						else
							a.wait();
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
		}
	}
	
	public class printWorld extends Thread
	{
		public void run()
		{
			while(true)
					synchronized(a)
					{
						if(state==1)
						{
							System.out.println("World");
							state=0;
							a.notify();
						} else
							try {
								a.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
					}
			
		}
	}

}
