package effectivejava.chapter2.builder.client;

import effectivejava.chapter2.builder.model.NutritionFacts;

public class Client {
	public static void main(String[] args){
		// The advantage:
		// we want our class instances to be immutable, but we have to initialize them with many parameters
		// we could use a constructor but it wouldn't be readable, or we could use setters but it wouldn't be immutable anymore
		// with the builder patter we have a more readable code and our instance is immutable
		NutritionFacts theFacts = new NutritionFacts.Builder(40,40).calories(10).carbohydrate(23).fat(22).sodium(2312).build();
		
		
	}

}
