package leetCode;

public class MinimumHP {

	public static void main(String[] args) {
		System.out.println(calculateMinimumHP(new int[][] {{10,4,-48,-8,-87,9},{49,-100,6,-15,41,-99}, {-76,-45,-26,50,46,14}, {-81,-92,46,-62,-26,1}, {-44,19,26,-98,-49,-72}}));
	}
	public static int calculateMinimumHP(int[][] dungeon) {
        int[][] cur=new int[dungeon.length][dungeon[0].length];
        int[][] health=new int[dungeon.length][dungeon[0].length];
        if(dungeon[0][0]>0)
        {
            health[0][0]=1;
            cur[0][0]=dungeon[0][0]+1;
        }
        else
        {
            health[0][0]=1+Math.abs(dungeon[0][0]);
            cur[0][0]=1;
        }
        
        for(int i=1; i<dungeon.length; i++)
            if(dungeon[i][0]+cur[i-1][0]>0)
            {
                health[i][0]=health[i-1][0];
                cur[i][0]=dungeon[i][0]+cur[i-1][0];
            }
            else
            {
                health[i][0]=health[i-1][0]+Math.abs(dungeon[i][0]+cur[i-1][0])+1;
                cur[i][0]=1;                
            }
            
        for(int j=1; j<dungeon[0].length; j++)
            if(dungeon[0][j]+cur[0][j-1]>0)
            {
                health[0][j]=health[0][j-1];
                cur[0][j]=dungeon[0][j]+cur[0][j-1];
            }
            else
            {
                health[0][j]=health[0][j-1]+Math.abs(dungeon[0][j]+cur[0][j-1])+1;
                cur[0][j]=1;                
            }
            
        for(int i=1; i<dungeon.length; i++)
            for(int j=1; j<dungeon[0].length; j++)
            {
                 int top=0;
                 if(dungeon[i][j]+cur[i-1][j]>0)
                    top=health[i-1][j];
                 else
                    top=health[i-1][j]+Math.abs(dungeon[i][j]+cur[i-1][j])+1;  
                 
                 int left=0;
                 if(dungeon[i][j]+cur[i][j-1]>0)
                    left=health[i][j-1];
                 else
                    left=health[i][j-1]+Math.abs(dungeon[i][j]+cur[i][j-1])+1; 
                 
                if(top<left)
                {
                    health[i][j]=top;
                    cur[i][j]= dungeon[i][j]+cur[i-1][j]>0 ? dungeon[i][j]+cur[i-1][j] : 1;
                }
                else
                {
                	if(left<top)
                	{
	                    health[i][j]=left;
	                     cur[i][j]= dungeon[i][j]+cur[i][j-1]>0 ? dungeon[i][j]+cur[i][j-1] : 1;
                	}
                	else
                	{
                		health[i][j]=top;
                		if( dungeon[i][j]+cur[i][j-1]<=0 && dungeon[i][j]+cur[i-1][j]<=0 )
                			cur[i][j]=1;
                		else
                			cur[i][j]=Math.max(dungeon[i][j]+cur[i-1][j], dungeon[i][j]+cur[i][j-1]);
                	}
                	
                }
                
            
            }
        return health[dungeon.length-1][dungeon[0].length-1];
            
            
        
    }

}
