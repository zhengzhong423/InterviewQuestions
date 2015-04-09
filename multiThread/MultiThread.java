package multiThread;

public class MultiThread {

	public static void main(String[] args) {
		Object lock=new Object();
		
		Thread1 myThread1=new Thread1(lock);
		Thread2 myThread2=new Thread2(lock);
		
		Thread obj1=new Thread(myThread1);
		Thread obj2=new Thread(myThread2);
		
		obj1.start();
		obj2.start();
	}

}
