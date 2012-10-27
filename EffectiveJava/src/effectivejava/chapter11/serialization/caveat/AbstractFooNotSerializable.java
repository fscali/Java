package effectivejava.chapter11.serialization.caveat;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractFooNotSerializable {
	private int x, y; //our state
	
	private enum State {NEW, INITIALIZING, INITIALIZED};
	
	private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);
	
	// if subclasses need to implement Serializable, we must provide a constructor with no parameter, 
	// otherwise they can't. So we define a final initialization method that we call in our constructor 
	// with parameters and must be used by subclasses, otherwise they can't access our state 
	public AbstractFooNotSerializable(int x, int y){
		initialize(x, y);
	}
	
	protected AbstractFooNotSerializable(){}

	protected final void initialize(int x2, int y2) {
		// TODO Auto-generated method stub
		if (!init.compareAndSet(State.NEW, State.INITIALIZING)){
			throw new IllegalStateException("Already initialized");
		}
		
		this.x = x2;
		this.y = y2;
		
		init.set(State.INITIALIZED);
		
	}
	
	protected final int getX(){ checkInit(); return x;}
	protected final int getY(){ checkInit(); return y;}

	private void checkInit() {
		if (init.get() != State.INITIALIZED){
			throw new IllegalStateException("Uninitialized!");
		}
		
	}
	

}
