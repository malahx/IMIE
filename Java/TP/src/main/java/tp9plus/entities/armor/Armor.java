package tp9plus.entities.armor;

import tp9plus.entities.Loot;
import tp9plus.entities.TypeDamage;
import tp9plus.utils.Utils;

public abstract class Armor implements Loot {
	private String name;
	private int defense;
	private TypeDamage type;

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return Utils.getInstance().bolder(name);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense
	 *            the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = Utils.getInstance().limit(defense);
	}

	/**
	 * @return the type
	 */
	public TypeDamage getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeDamage type) {
		this.type = type;
	}

	/**
	 * @param name
	 * @param defense
	 */
	protected Armor(String name, int defense, TypeDamage type) {
		super();
		this.name = name;
		this.setDefense(defense);
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "(" + defense + "/" + type + ")";
	}

}
