package tp9plus.entities.weapon;

import tp9plus.entities.TypeDamage;

public class PhysicalWeapon extends Weapon {

	public PhysicalWeapon(String name, int damage, int pa) {
		super(name, damage, pa, TypeDamage.PHYSICAL);
	}

}
