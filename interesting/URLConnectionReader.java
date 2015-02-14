package interesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;


public class URLConnectionReader {
	static String USER_AGENT = "Mozilla/5.0";
	
    public static void main(String[] args) throws Exception {
    	String url = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&" + "q=BAIDU&userip=USERS-IP-ADDRESS";
    	 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
	
		
		String inputLine=in.readLine();
		System.out.println();
		parseJson(inputLine);
		in.close();
    }
    public static void parseJson(String inputLine)
    {
    	try {
			JSONObject obj=new JSONObject(inputLine);
			JSONObject a=(JSONObject) obj.get("responseData");
			JSONArray arr=a.getJSONArray("results");
			for(int i=0; i<a.length(); i++)
			{
				JSONObject o=arr.getJSONObject(i);
				Iterator<?> iter=o.keys();
				while(iter.hasNext())
				{
					Object object=iter.next();
					System.out.println(object+ " : " +o.getString(object.toString()));
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}