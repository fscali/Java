package effectivejava;

import java.util.ArrayList;
import java.util.List;

public class BoxDemo {
	
	public static <U> void addBox(U u,
			List<Box<U>> boxes){
		BoxDemo instance = new BoxDemo();
		Box<U> box = instance.new Box<U>();
		box.set(u);
		boxes.add(box);
		
	}
	
	public static <U> void outputBoxes(List<Box<U>> boxes){
		int counter = 0;
		for (Box<U> box : boxes){
			U boxContents = box.get();
			System.out.println("Box #" + counter + " contains [" +
			boxContents.toString() + "]");
			counter++;
		}
	}
	
	public static void main(String[] args){
		List<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
		BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		outputBoxes(listOfIntegerBoxes);
	}

	public class Box<T>{
		private T t;
		
		void set(T t){
			this.t = t;
		}
		
		T get() {
			return t;
		}
	}
	
}
