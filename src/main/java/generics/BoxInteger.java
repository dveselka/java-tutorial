package generics;

public class BoxInteger extends AbstractValue<Integer> {
	
	public BoxInteger(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public int compareTo(Integer value) {
		
		return this.getValue().compareTo(value);
	}

}
