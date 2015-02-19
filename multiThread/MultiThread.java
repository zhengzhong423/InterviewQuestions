package multiThread;

public class MultiThread {

	public static void main(String[] args) {
		Thread1 myThread1=new Thread1();
		Thread2 myThread2=new Thread2();
		
		Thread obj1=new Thread(myThread1);
		Thread obj2=new Thread(myThread2);
		
		obj1.start();
		obj2.start();
	}

}
