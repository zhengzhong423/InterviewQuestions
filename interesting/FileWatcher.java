package interesting;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;


public class FileWatcher {
	
	private WatchService watcher;
	private static String base="D://cygwin//home//dell//runtime//local//";
	private static String portal="Round15//linkdb//";
	
	public static void main(String[] args) {
		try {
			new FileWatcher().handleEvent(Paths.get(base+portal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void handleEvent(Path path) throws Exception
	{
		while(true)
		{
			watcher=FileSystems.getDefault().newWatchService();
			path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			WatchKey key=watcher.take();
			for(WatchEvent<?> event: key.pollEvents())
			{
				Kind<?> kind=event.kind();
				if(kind==StandardWatchEventKinds.OVERFLOW)
					continue;
				System.out.println(event.context());
				deleteFile(event.context().toString());
			}
		}
	}

	private void deleteFile(String context) {
		String des=base+portal+context;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new File(des).delete());
	}

}
