package leetCode;

public class CmpVersion {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.1.1", "0.1"));

	}
	public static int compareVersion(String version1, String version2) {
        String[] v1Array=version1.split("\\.");
        String[] v2Array=version2.split("\\.");
        int i=0;
        for(i=0; i<Math.min(v1Array.length, v2Array.length); i++)
        {
           if(Integer.parseInt(v1Array[i])>Integer.parseInt(v2Array[i]))
                return 1;
           if(Integer.parseInt(v1Array[i])<Integer.parseInt(v2Array[i]))
                return -1;
        }
        if(i==v1Array.length && i==v2Array.length)
            return 0;
        if(i<v1Array.length)
            return -1;
        return 1;
    }

}
