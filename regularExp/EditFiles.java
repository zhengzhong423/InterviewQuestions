package regularExp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditFiles {

	public static void main(String[] args) {
		File ufile=new File("C://Users//dell//workspace//Solution//src//cracking");
		File[] files=ufile.listFiles();
		for(File f:files)
		{
			try {
				BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				String str=buffer.readLine();
				if(!str.equals("package cracking;"))
				{
					BufferedWriter out=new BufferedWriter(new FileWriter(f));
					out.write("package cracking;");
					out.newLine();
					out.close();
				}
				buffer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
