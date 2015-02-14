package interesting;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

	public static void main(String[] args) {
		JSONObject obj=new JSONObject();
		try {
			obj.put("name", "mkyong.com");
		} catch (JSONException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			obj.put("age", new Integer(100));
		} catch (JSONException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	 
		JSONArray lists = new JSONArray();
		lists.put("msg 1");
		lists.put("msg 2");
		lists.put("msg 3");
	 
		try {
			obj.put("messages", lists);
		} catch (JSONException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	 
		try {
	 
			FileWriter file = new FileWriter("c:\\test.json");
			file.write(obj.toString());
			file.flush();
			file.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		System.out.print(obj);
	}

}
