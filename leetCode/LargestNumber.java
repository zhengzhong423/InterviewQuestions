package leetCode;


public class LargestNumber {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
    public String largestNumber(int[] num) {
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<num.length; i++)
            sb.append(String.valueOf(num[i]));
        return sb.toString();
    }

}
