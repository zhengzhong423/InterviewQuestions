package geeksForGeeks;

public class ThrowException {

	public static void main(String[] args) {
		try {
			checkValid(13);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void checkValid(int i) throws Exception
	{
		if(i>10)
			throw new Exception();
	}

}
