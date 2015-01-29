package leetCode;

public class SetColors {

	public static void main(String[] args) {
		SetColors s=new SetColors();
		int[] A={1,2,0};
		s.sortColors(A);

	}
	public void sortColors(int[] A) {
        int pointerA=0;
        int pointerB=0;
        int pointerC=0;
        if(A.length==0)
            return;
        for(int i=0; i<A.length; i++)
        {
            if(A[i]==0)
            {
                A[pointerA]=0;    
                if(pointerB!=pointerA)
                {
                    A[pointerB]=1;
                    if(pointerB!=pointerC)
                        A[pointerC]=2;
                }
                pointerA++;
                pointerB++;
                pointerC++;
                continue;
            }
            if(A[i]==1)
            {
                A[pointerB]=1;
                if(pointerB!=pointerC)
                {
                        A[pointerC]=2;
                        
                }
                pointerB++;
                pointerC++;
                continue;
            }
            if(A[i]==2)
            {
                A[pointerC]=2;
                pointerC++;
                continue;
            }
            
        }
    }
}
