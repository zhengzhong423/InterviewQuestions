package regularExp;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class RegularEXP {
	public static void main(String[] args) {
//		fileHelper();
		validIP("321.3.2.3");
	}
	public static void validIP(String str)
	{
		Pattern p=Pattern.compile("(([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		Matcher matcher=p.matcher(str);
		System.out.println(matcher.matches());
	}
	public static void fileHelper()
	{
		// TODO 自动生成的方法存根
				File file=new File("D://");
				File[] ListFiles=file.listFiles();
			/*	File[] parts=File.listRoots();
				for(File part : parts){

				    System.out.println(part.getAbsolutePath());

				}*/
				for(File f: ListFiles)
				{
					
				Pattern pattern = Pattern.compile(".*");
				Matcher matcher = pattern.matcher(f.getPath());
//				System.out.println(f.getName());
				if(matcher.matches())
				  System.out.println(matcher.group());
				}
	}
}

