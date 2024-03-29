package effectivejava.chapter4.minimizeaccessibility.arrays;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] values = ModelClass.VALUES;
		
		System.out.println(ModelClass.asString());
		values[2] = 232;
		System.out.println(ModelClass.asString());
		
		List<Integer> unmodifiableValues = ModelClass.UNMODIFIABLE_VALUES;
	//	unmodifiableValues.set(0, 1); // if the List is unmodifiable, this calls launches an UnSupportedOperationException
		//val = 112112;
		System.out.println(unmodifiableValues);
	
		AtomicReference<ModelClass> atomicReference = new AtomicReference<>();
		
		ModelClass prova = atomicReference.getAndSet(new ModelClass());
		atomicReference.lazySet(new ModelClass());
		String p = "";
	}

}
