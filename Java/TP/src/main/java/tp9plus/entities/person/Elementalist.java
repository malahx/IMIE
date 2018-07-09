package tp9plus.entities.person;

import tp9plus.entities.Charact;
import tp9plus.entities.armor.MagicalArmor;
import tp9plus.entities.weapon.MagicalWeapon;

public class Elementalist extends Person {

	public Elementalist(String name, MagicalWeapon weapon, MagicalArmor armor, int pv, int pa) {
		super(name, weapon, armor, pv, pa);
	}

	@Override
	public int attack(Charact c) {
		return (int) (super.attack(c) * 1.1f);
	}

}
