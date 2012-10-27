package effectivejava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GenericMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TEST union
		Set<String> s1 = new HashSet<>(Arrays.asList("Tom","Dick","Harry"));
		Set<String> s2 = new HashSet<>(Arrays.asList("Larry","Moe","Curly"));
		Set<String> u  = union(s1,s2);
		System.out.println(u);
		
		//TEST Unaryfunction
		String[] strings = {"jute", "hemp","nylon"};
		UnaryFunction<String> sameString = identityFunction();
		for (String s: strings)
			System.out.println(sameString.apply(s));
		
		Number[] numbers = {1, 2.0, 3L};
		UnaryFunction<Number> sameNumber = identityFunction();
		
		for(Number n: numbers)
			System.out.println(sameNumber.apply(n));

	}
	
	private static <E> Set<E> union(Set<E> s1, Set<E> s2){
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	private static UnaryFunction<Object> IDENTITY_FUNCTION =
			new UnaryFunction<Object>(){
		public Object apply(Object arg){
			return arg;
		}
	};
	
	// IDENTITY_FUNCTION is stateless and its' type parameter is unbounded
	// so it's safe to share one instance across all types
	@SuppressWarnings("unchecked")
	private static <T> UnaryFunction<T> identityFunction(){
		return  (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
	
	
	private interface UnaryFunction<T>{
		T apply(T arg);
	}
}
