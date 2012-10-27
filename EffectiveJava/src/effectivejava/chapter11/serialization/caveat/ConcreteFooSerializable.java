package effectivejava.chapter11.serialization.caveat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ConcreteFooSerializable extends AbstractFooNotSerializable
		implements Serializable {

	//note that the subclass is responsible for reading and writing fields from parent class,
	//which doesn't implement Serializable
	
	private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException{
		s.defaultReadObject();
		int x = s.readInt();
		int y = s.readInt();
		initialize(x,y);
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException{
		s.defaultWriteObject();
		s.writeInt(getX());
		s.writeInt(getY());
		
	}
	
	public ConcreteFooSerializable(int x, int y){
		super(x,y);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6040657119485443666L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
