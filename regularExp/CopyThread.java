package regularExp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyThread extends Thread {
	String[] fileType=new String[] {"pdf","doc", "docx"};
	File file=null;
	private final String des="C:\\Users\\dell\\Desktop\\copy";
	
	public CopyThread(File file) {
		this.file=file;
	}
	
	public void run()
	{
			ListAllFiles(file, "");
			System.out.println("Done");
	}
	
	public void ListAllFiles(File ufile, String path)
	{
		File[] files=ufile.listFiles();
		for(File f: files)
		{
			if(f.isDirectory())
			{
				File newFile=new File(des+path+"\\"+f.getName());
				if(!newFile.exists())
					newFile.mkdir();
				ListAllFiles(f, path+"\\"+f.getName());
			}
			else	if(fileTypeMatch(f))
			{
				System.out.println(f.getAbsolutePath());
				System.out.println("Move To");
				System.out.println(des+path+"\\"+f.getName());
				doCopy(f , des+path+"\\"+f.getName());
			}
		}
	}

	private boolean fileTypeMatch(File f) {
		for(String s: fileType)
			if(f.getName().endsWith("."+s))
				return true;
		return false;
	}
	
	public void doCopy(File f, String str)
	{
		try {
			File newFile=new File(str);
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f));
			if(!newFile.exists())
			{
				new File(newFile.getParent()).mkdir();
			}
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newFile));
			byte[] buf=new byte[1000];
			int len=0;
			while((len=bis.read(buf))!=-1)
			{
				bos.write(buf, 0, len);
				bos.flush();
			}
			bis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
