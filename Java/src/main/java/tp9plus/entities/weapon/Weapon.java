/**
 * 
 */
package tp9plus.entities.weapon;

import tp9plus.entities.Loot;
import tp9plus.entities.TypeDamage;
import tp9plus.utils.Utils;

public abstract class Weapon implements Loot {

	private String name;
	private int damage;
	private int pa;
	private TypeDamage type;

	/**
	 * @return the name
	 */
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
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage
	 *            the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = Utils.getInstance().limit(damage);
	}

	/**
	 * @return the pa
	 */
	public int getPa() {
		return pa;
	}

	/**
	 * @param pa
	 *            the pa to set
	 */
	public void setPa(int pa) {
		this.pa = Utils.getInstance().limit(pa);
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

	
	protected Weapon() {}
	/**
	 * 
	 * @param name
	 * @param damage
	 * @param pa
	 * @param type
	 */
	protected Weapon(String name, int damage, int pa, TypeDamage type) {
		super();
		this.name = name;
		this.setDamage(damage);
		this.setPa(pa);
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "(" + damage + "/" + pa + ")";
	}

}
