public class Setting {
	private String name;
	private int value;

	public Setting(String nameIn, int valueIn) {
		name = nameIn;
		value = valueIn;
	}

	public void setValue(int valueIn) {
		value = valueIn;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}