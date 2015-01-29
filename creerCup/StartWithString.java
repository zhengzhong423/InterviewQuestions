package creerCup;

import java.util.ArrayList;
import java.util.Arrays;

public class StartWithString {
	
	public static void main(String[] args)
	{
		String[] str={"/flapp/server/apache", 
				"/d/apps", 
				"/d/apps/pub", 
				"/flapp", 
				"/flocal/firms", 
				"/d/sw/java", 
				"/d/sw/orcl/jdbc"};
		ArrayList<String> ar=new ArrayList<>(Arrays.asList(str));
		for(int i=0; i<str.length; i++)
			for(int j=i+1; j<str.length; j++)
			{
					if(str[i].startsWith(str[j]))
						ar.remove(str[i]);
					if(str[j].startsWith(str[i]))
						ar.remove(str[j]);
			}
		System.out.println(ar);
	}
}
