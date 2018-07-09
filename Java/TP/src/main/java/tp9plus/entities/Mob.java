package tp9plus.entities;

import java.util.concurrent.ThreadLocalRandom;

import tp9plus.entities.armor.Armor;
import tp9plus.entities.weapon.Weapon;
import tp9plus.utils.Utils;

public class Mob extends Charact {

	private int dodge;
	private Fighter fighter;
	private Loot loot;

	/**
	 * @return the dodge
	 */
	public int getDodge() {
		return dodge;
	}

	/**
	 * @param dodge
	 *            the dodge to set
	 */
	public void setDodge(int esquive) {
		this.dodge = Utils.getInstance().limit(esquive);
	}

	/**
	 * @return the fighter
	 */
	public Fighter getFighter() {
		return fighter;
	}

	/**
	 * @param fighter
	 *            the fighter to set
	 */
	public void setFighter(Fighter fighter) {
		this.fighter = fighter;
	}

	/**
	 * @return the loot
	 */
	public Loot getLoot() {
		return loot;
	}

	/**
	 * @param loot
	 *            the loot to set
	 */
	public void setLoot(Loot loot) {
		this.loot = loot;
	}

	@Override
	public boolean willEsquive(int precision) {
		return precision < dodge;
	}

	public Mob() {
	}

	public Mob(String name, Weapon weapon, Armor armor, int pv, int pa) {
		super(name, weapon, armor, pv, pa);
		this.dodge = ThreadLocalRandom.current().nextInt(0, 75);
		this.loot = new Gold();
	}

	public Mob(String name, Weapon weapon, Armor armor, int pv, int pa, Fighter fighter) {
		super(name, weapon, armor, pv, pa);
		this.dodge = ThreadLocalRandom.current().nextInt(0, 75);
		this.setFighter(fighter);
		this.loot = new Gold();
	}

	@Override
	public int attack(Charact c) {
		if (fighter != null) {
			return fighter.attack(c);
		}
		return super.attack(c);
	}

}
