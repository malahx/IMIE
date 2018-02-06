package tp9plus.entities.person;

import tp9plus.entities.Charact;
import tp9plus.entities.armor.PhysicalArmor;
import tp9plus.entities.weapon.PhysicalWeapon;

public class Warrior extends Person {

	public Warrior(String name, PhysicalWeapon weapon, PhysicalArmor armor, int pv, int pa) {
		super(name, weapon, armor, pv, pa);
	}

	@Override
	public int attack(Charact c) {
		return (int) (super.attack(c) * 0.9f);
	}

}
