package tp9plus.entities;

import java.util.concurrent.ThreadLocalRandom;

import tp9plus.utils.Utils;

public class Gold implements Loot {

	private String name = "Gold";
	private int value;

	/**
	 * @return the name
	 */
	public String getName() {
		return Utils.getInstance().bolder(name + "(" + value + ")");
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = Utils.getInstance().limit(value);
	}

	public Gold() {
		this.setValue(ThreadLocalRandom.current().nextInt(0, 100));
	}
	
	/**
	 * @param value
	 */
	public Gold(int value) {
		super();
		this.setValue(value);
	}

}
