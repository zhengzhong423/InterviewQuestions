package leetCode;

public class Candies {

	public static void main(String[] args) {
		int[] ratings={1,2,3,4,5};
		System.out.println(candy2(ratings));
	}
	public static int candy2(int[] ratings) 
	{
		int[] arr=new int[ratings.length];
		if(ratings.length==1)
			return 1;
		for(int i=0; i<ratings.length;i++)
			arr[i]=1;
		for(int i=0; i<ratings.length-1;i++)
			if(ratings[i+1]>ratings[i])
				arr[i+1]=arr[i]+1;
		for(int i=ratings.length-1; i>0; i--)
			if(ratings[i-1]>ratings[i])
				arr[i-1]=Math.max(arr[i]+1, arr[i-1]);
	     int num=0;
	        for(int i:arr)
	        	num+=i;
	        return num;
	}
	public static int candy(int[] ratings) 
	{
		int[] arr=new int[ratings.length];
		if(ratings.length==1)
			return 1;
		if(ratings.length==2)
			if(ratings[0]==ratings[1])
				return 2;
			else
				return 3;
		for(int i=0; i<ratings.length;i++)
			arr[i]=1;
		int count=1;
        while(!checkValid(ratings, arr))
        {
        	count++;
        	for(int i=0; i<ratings.length;i++)
    		{
    			if(i!=ratings.length-1 && i!=0)
    			{
    				if((ratings[i]>ratings[i+1] && arr[i]<=arr[i+1]) || (ratings[i]>ratings[i-1] && arr[i]<=arr[i-1]))
    					arr[i]=count;
    			}
    			if(i==0)
    			{
    				if(ratings[0]>ratings[1] && arr[0]<=arr[1])
    					arr[0]=count;
    			}
    			if(i==ratings.length-1)
    			{
    				if(ratings[i]>ratings[i-1] && arr[i]<=arr[i-1])
    					arr[i]=count;
    			}
    		}
        }
        int num=0;
        for(int i:arr)
        	num+=i;
        return num;
    }
	public static boolean checkValid(int[] ratings, int[] arr) {
		for(int i=0; i<ratings.length;i++)
		{
			if(i!=ratings.length-1)
			{
				if(ratings[i]>ratings[i+1] && arr[i]<=arr[i+1])
					return false;
				if(ratings[i]<ratings[i+1] && arr[i]>=arr[i+1])
					return false;
			}
			if(i!=0)
			{
				if(ratings[i]>ratings[i-1] && arr[i]<=arr[i-1])
					return false;
				if(ratings[i]<ratings[i-1] && arr[i]>=arr[i-1])
					return false;
			}
		}
		return true;
	}
}
