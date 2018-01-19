package generics;

public abstract class AbstractValue<T> implements Comparable<T> {

	protected T value;

	public abstract T getValue();
	
}
