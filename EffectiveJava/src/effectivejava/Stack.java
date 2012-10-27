package effectivejava;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
	
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public Stack(){
		
		/**
		 * The elements array will contain only E instances from push(E)
		 * This is sufficient to ensure type safety, but the runtime type of
		 * the array won't be E[]; it will always be Object[]
		 * 
		 */
		
		
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public static void main(String[] args){
		Stack<String> stack = new Stack<>();
		for (String arg:args)
			stack.push(arg);
		while (!stack.isEmpty()){
			System.out.println(stack.pop().toUpperCase());
		}
	}
	
	public void push(E e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop(){
		if (size == 0){
			throw new EmptyStackException();			
			
		}
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if (elements.length == size)
			elements = Arrays.copyOf(elements,2*size+1);
		
	}
	
	
}
