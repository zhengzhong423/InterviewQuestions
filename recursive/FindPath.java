package recursive;

import java.awt.Point;
import java.util.LinkedList;

public class FindPath {
	public static void main(String[] args) {
		FindPath f = new FindPath();
		LinkedList<Point> current = new LinkedList<Point>();
		f.getPath(3, 3, current);

	}

	public void getPath(int x, int y, LinkedList<Point> current) {
		Point p = new Point(x, y);
		current.add(p);
		if (x == 0 && y == 0)
		{
				for(Point p1: current)
					System.out.println("("+p1.x+","+p1.y+")");
				System.out.println();
				return;
		}
		if (y - 1 >= 0 && checkMap(x, y - 1)) // Go down
		{
			getPath(x, y-1, current);
			current.removeLast();
		}
		if (x - 1 >= 0 && checkMap(x - 1, y)) // Go left
		{
			getPath(x-1, y, current);
			current.removeLast();
		}

	}

	private static boolean checkMap(int x, int y) {
		if(x==1 && y==1)
			return false;
		return true;
	}
}
