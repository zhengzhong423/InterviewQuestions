package geeksForGeeks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

public class ReadLastTenLines {

	public class myQueue
	{
		int capacity=2;
		Queue<String> queue=new LinkedList<String>();
		public  void add(String s)
		{
			if(queue.size()==capacity)
				queue.remove();
			queue.add(s);
		}
	}
	public static void main(String[] args) {

		File f=new File("C:/Users/dell/Desktop/test.txt");
		myQueue q=new ReadLastTenLines().new myQueue();
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String s="";
			while((s=br.readLine()) != null)
				q.add(s);
			br.close();
			System.out.println(q.queue);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
