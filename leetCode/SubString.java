package leetCode;

import java.io.*;

public class SubString {

	public static void main(String[] args) {
		String s="abcde";
		for(int i=0; i<s.length(); i++)
			System.out.println(s.substring(0,i)+s.substring(i+1, s.length()));

	}
	public static void sumFile ( String name ) {
        try {
            int total = 0;
            BufferedReader in = new BufferedReader ( new InputStreamReader ( new FileInputStream(name) ));
            for ( String s = in.readLine(); s != null; s = in.readLine() ) {
                total += Integer.parseInt ( s );
            }
            System.out.println ( total );
            in.close();
        }
        catch ( Exception xc ) {
            xc.printStackTrace();
        }
    }

}
