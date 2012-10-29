package effectivejava.chapter6.enums.operations;

import java.util.HashMap;
import java.util.Map;

public class Client{
	
	public static void main(String[] args){
		double x = 5.0;
		double y = 2.1;
		for (Operation op : Operation.values()){
			System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
		}
	}
	
	//enum type with constant specific class bodies and data
	enum Operation {
		
		
		PLUS ("+"){ double apply(double x, double y) {return x+y;}},
		MINUS("-") { double apply(double x, double y) {return x-y;}},
		TIMES("*") { double apply(double x, double y) {return x*y;}},	
		DIVIDE("/") {double apply(double x, double y) {return x/y;}};
		
		private final String symbol;
		private static final Map<String, Operation> stringToEnum = new HashMap<>();
		static{
			
			for (Operation op : values()){
				stringToEnum.put(op.toString(), op);
			}
			
		}
		
		Operation(String symbol){this.symbol = symbol;}
		
		@Override
		public String toString(){ return this.symbol; }
		
		
		//as we have overriden the toString method, it is convenient to have a method that can convert the canonical
		//string representation back to the enum type
		public static Operation fromString(String symbol){
			return stringToEnum.get(symbol);
		}
		
		abstract double apply(double x, double y);
	
	}
}
