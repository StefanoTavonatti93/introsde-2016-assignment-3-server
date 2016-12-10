package tavonatti.stefano.model;

import java.util.Comparator;

public class ComaparatorMeasureDate implements Comparator<Measure>{

	@Override
	public int compare(Measure o1, Measure o2) {
		/*if(o1==null || o2==null)
			return 0;*/
		if(o1.getDateRegistered().getTime()>o2.getDateRegistered().getTime())
			return -1;
		return 1;
	}

}
