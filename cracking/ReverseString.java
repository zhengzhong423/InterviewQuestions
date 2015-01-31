package cracking;

public class ReverseString {
	public static void main(String[] args) {
		String t = "liu xin yu yu yu";
		ReverseString s = new ReverseString();
		String p = s.reverseWords(t);
		System.out.println(p);
	}

	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder();
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				temp = temp + s.charAt(i);
			} else {

				result.insert(0, temp);
				result.insert(0, " ");
				temp = "";
			}
		}
		result.insert(0, temp);
		if (s.length() > 0) {
			if (result.charAt(s.length() - 1) == ' ')
				result.deleteCharAt(s.length() - 1);
			return result.toString();
		}
		return result.toString();
	}
}
