package interesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Youku {

	public static void main(String[] args) {
		try {
			new Youku().getInfo();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getInfo() throws Exception
	{
		String url = "https://openapi.youku.com/v2/searches/video/by_keyword.json?" + "&client_id=d368f4c4fab16e22"+"&keyword=sc2";
   	 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
 
		System.out.println("\nSending 'GET' request to URL : " + url);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
	
		
		String inputLine=in.readLine();
		System.out.println(inputLine);
		in.close();
	}

}
