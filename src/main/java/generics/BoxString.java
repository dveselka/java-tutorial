package generics;

public class BoxString extends AbstractValue<String> {
	
	public BoxString(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

}
