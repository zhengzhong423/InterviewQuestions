package regularExp;

import java.io.File;

public class MoveFiles {

	public static void main(String[] args) {
		File file=new File("C://Users//dell//Desktop//Resume");
		new CopyThread(file).run();
	}

}
