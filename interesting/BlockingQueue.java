package interesting;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {

	public static void main(String[] args) {
		try {
			ArrayBlockingQueue < String > bQueue = new ArrayBlockingQueue < String > ( 2 ) ; 
			bQueue. put ( "Java" ) ; 
			System . out . println ( "Item 1 inserted into BlockingQueue" ) ; 
			bQueue. put ( "JDK" ) ; 
			System . out . println ( "Item 2 is inserted on BlockingQueue" ) ; 
			bQueue.take();
			bQueue. put ( "J2SE" ) ; 
			System . out . println ( "Done" ) ;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

	}

}
