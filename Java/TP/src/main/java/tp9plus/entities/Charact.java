package tp9plus.entities;

import tp9plus.entities.armor.Armor;
import tp9plus.entities.weapon.Weapon;
import tp9plus.utils.Utils;

public abstract class Charact implements Fighter {
	protected String name;
	protected Weapon weapon;
	protected Armor armor;
	protected int pv;
	protected int pa;

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
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon
	 *            the weapon to set
	 */
	public final void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/**
	 * @return the armor
	 */
	public Armor getArmor() {
		return armor;
	}

	/**
	 * @param armor
	 *            the armor to set
	 */
	public final void setArmor(Armor armor) {
		this.armor = armor;
	}

	/**
	 * @return the pv
	 */
	public int getPv() {
		return pv;
	}

	/**
	 * @param pv
	 *            the pv to set
	 */
	public final void setPv(int pv) {
		this.pv = Utils.getInstance().limit(pv);
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

	public boolean willEsquive(int precision) {
		return false;
	}

	/**
	 * 
	 * @param dmg
	 *            the dmg received
	 * @return the calculated dmg
	 */
	public int calcDmg(Weapon w) {
		int dmg = w.getDamage()
				- (armor.getType() == TypeDamage.MIXED || w.getType() == armor.getType() ? armor.getDefense() : 0);
		return dmg;
	}

	@Override
	public int attack(Charact c) {
		float dmg = c.calcDmg(weapon);
		if (dmg <= 0) {
			return 0;
		}
		c.setPv((int) (c.getPv() - dmg));
		return (int)dmg;
	}

	/**
	 * 
	 * @return if the character is dead
	 */
	public boolean isDead() {
		return pv <= 0;
	}

	protected Charact() {
	}

	/**
	 * @param weapon
	 * @param armor
	 * @param pv
	 * @param pa
	 */
	public Charact(String name, Weapon weapon, Armor armor, int pv, int pa) {
		super();
		this.name = name;
		this.weapon = weapon;
		this.armor = armor;
		this.setPv(pv);
		this.setPa(pa);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + "\n  weapon=[" + weapon + "]\n  armor=[" + armor + "]\n  pv=[" + pv + "]\n  pa=[" + pa + "]";
	}

}
