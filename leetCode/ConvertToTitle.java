package leetCode;

public class ConvertToTitle {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println(convertToTitle(703));
	}
	public static String convertToTitle(int n) {
        StringBuffer s=new StringBuffer();
        while(n>=26)
        {
        	s.insert(0, (char)((n-1)%26+'A'));
        	n=(n-1)/26;
        }
        s.insert(0,(char)((n-1)+'A'));
        return s.toString();
    }

}
