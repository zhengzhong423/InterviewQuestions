package interesting;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterIt {
	
	public static void main(String[] args)
	{
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			twitter.updateStatus("≈£¥Û≈££°");
		} catch (TwitterException e1) {
			e1.printStackTrace();
		}
	    
	  
	   
		  
	}
}
