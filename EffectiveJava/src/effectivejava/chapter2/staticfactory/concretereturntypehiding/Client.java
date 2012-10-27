package effectivejava.chapter2.staticfactory.concretereturntypehiding;

import effectivejava.chapter2.staticfactory.concretereturntypehiding.types.Animal;
import effectivejava.chapter2.staticfactory.concretereturntypehiding.types.IAnimal;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IAnimal genericAnimal = Animal.getAnimal();
		IAnimal genericCat    = Animal.getCat();
		IAnimal genericDog    = Animal.getDog();
		
		genericAnimal.describeMySelf();
		genericCat.describeMySelf();
		genericDog.describeMySelf();
		
	}

}
