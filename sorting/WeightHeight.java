package sorting;

import java.util.Comparator;

public class WeightHeight  implements Comparator<WeightHeight>{
	int height;
	int weight;
	
	public WeightHeight(){}
	
	public WeightHeight(int weight, int height)
	{
		this.weight=weight;
		this.height=height;
	}

		public int compare(WeightHeight arg0, WeightHeight arg1) {
			if(arg0.height<arg1.height)
				return -1;
			if(arg0.height>arg1.height)
				return 1;
			return 0;
		}

	
}
