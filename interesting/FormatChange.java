package interesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FormatChange {

	public static void main(String[] args) {
		File file=new File("c://users//dell//desktop//test.txt");
		StringBuffer rs=new StringBuffer();
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String line="";
			while((line=br.readLine())!=null)
			{	
				String[] nums=line.split(" ");
				rs.append("{");
				rs.append((int)Double.parseDouble(nums[0]));
				rs.append(",");
				rs.append((int)Double.parseDouble(nums[1]));
				rs.append("}");
				rs.append(",");
			}
			rs.deleteCharAt(rs.length()-1);
			System.out.println(rs);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
