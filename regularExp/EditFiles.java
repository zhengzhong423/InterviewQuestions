package regularExp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditFiles {

	public static void main(String[] args) {
		File ufile=new File("C://Users//dell//workspace//Solution//src//cracking");
		addPackage(ufile);
	}
	public static void addPackage(File ufile)
	{
		File[] files=ufile.listFiles();
		for(File f: files)
		{
			try {
				BufferedReader br=new BufferedReader(new FileReader(f));
				StringBuffer sb=new StringBuffer();
				String temp="";
				sb.append("package cracking;\r\n");
				while((temp=br.readLine())!=null)
				{
						sb.append(temp+"\r\n");
				}
				br.close();
				
				BufferedWriter bw=new BufferedWriter(new FileWriter(f));
				bw.write(sb.toString());
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finish");
	}
	public static void deletePackage(File ufile)
	{
		File[] files=ufile.listFiles();
		for(File f: files)
		{
			try {
				BufferedReader br=new BufferedReader(new FileReader(f));
				StringBuffer sb=new StringBuffer();
				String temp="";
				while((temp=br.readLine())!=null)
				{
					if(!temp.equals("package cracking;"))
						sb.append(temp+"\r\n");
				}
				br.close();
				
				BufferedWriter bw=new BufferedWriter(new FileWriter(f));
				bw.write(sb.toString());
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finish");
	}

}
