package effectivejava.chapter4.minimizeaccessibility.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModelClass {
	public static final Integer[] VALUES = {2,5,6,10};
	
	public static final List<Integer> UNMODIFIABLE_VALUES = Collections.unmodifiableList(Arrays.asList(VALUES));
	//public static final List<Integer> UNMODIFIABLE_VALUES = Arrays.asList(VALUES);
			
	
	public static String asString(){
		return Arrays.toString(VALUES);
	}

}
