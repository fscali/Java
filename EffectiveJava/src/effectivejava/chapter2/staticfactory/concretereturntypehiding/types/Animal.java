package effectivejava.chapter2.staticfactory.concretereturntypehiding.types;

public class Animal implements IAnimal {

	private final String _type;
	
	
	private static final Animal _generator = new Animal();
	private static final IAnimal theCat = _generator.new Cat();
	private static final IAnimal theDog =_generator.new Dog();
	
	private Animal(String type){
		_type = type;
		
	}
	
	private Animal(){
		_type = "";
	}
	

	public static IAnimal getDog(){
		return theCat;
	}
	
	public static IAnimal getCat(){
		return theDog;
	}
	
	public static IAnimal getAnimal(){
		return new Animal("Generic Animal");
	}
	
	@Override
	public final void describeMySelf() {
		System.out.println(String.format("Hello, I'm a %s!!", _type));
	}

	private class Dog extends Animal {
		private Dog(){
			super("Dog");
		}
	}
	
	
	private class Cat extends Animal{
		private Cat(){
			super("Cat");
		}
	}

}
