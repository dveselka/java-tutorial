package generics;

public class BoxInteger extends AbstractValue<Integer> {
	
	public BoxInteger(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

}
