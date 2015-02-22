package index;

import java.io.File;

public class FindFiles {

	public static void main(String[] args) {
		String des="C://Users//dell//workspace//Solution//src";
//		if(args.length==0)
//		{
//			System.out.println("Use: FindFiles + [KeyWord]");
//			return;
//		}
//		String key=args[0];
		String key="match";
		File ufile=new File(des);
		File[] files=ufile.listFiles();
		for(File file: files)
			findFiles(file, key);
	}
	public static void findFiles(File file, String key)
	{
		File[] files=file.listFiles();
		for(File f: files)
			match(f, key);
	}
	private static void match(File f, String key) {
		if(f.getName().contains(key))
		{
			String[] strs=f.getParent().split("\\\\");
			System.out.println(strs[strs.length-1]+"\\"+f.getName());
		}
	}

}
