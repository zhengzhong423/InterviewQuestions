package bit;


public class TokenTest {

	public static void main(String[] args) {
		
		String str="<element> content </element>";
		
		String[] strs=str.split("</?[a-z]*>");
		for(int i=0; i<strs.length; i++)
			System.out.println(strs[i]);
	}

}
